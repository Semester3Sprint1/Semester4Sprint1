package com.database;

import com.members.Address;
import com.members.Member;
import com.members.membership.*;

import java.sql.*;
import java.util.ArrayList;

public class App {
    private final String url = "jdbc:postgresql://golf-database.cjuqnyg23emc.us-east-1.rds.amazonaws.com:5432/golf";
    private final String user = "alex";
    private final String password = "password";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    /**
     * Call a built-in stored function demo
     *
     * @param s
     * @return
     */
    public String properCase(String s) {
        String result = s;
        try (Connection conn = this.connect();
             CallableStatement properCase = conn.prepareCall("{ ? = call initcap( ? ) }")) {
            properCase.registerOutParameter(1, Types.VARCHAR);
            properCase.setString(2, s);
            properCase.execute();
            result = properCase.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

//    /**
//     * Call the get_film stored function
//     * @param pattern
//     * @param addressId
//     */
//    public void getFilms(String townName, int addressId) {
//
//        String SQL = "SELECT * FROM address (?, ?)";
//        try (Connection conn = this.connect();
//             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
//
//            pstmt.setString(2, townName);
//            pstmt.setInt(1, addressId);
//            ResultSet rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                System.out.println(String.format("%d %s",
//                        rs.getInt("address_id"),
//                        rs.getString("city")));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public ArrayList<Address> getAddresses() {
        ArrayList<Address> addressList = new ArrayList<>();

        String SQL = "SELECT * FROM address";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("address_id");
                String city = rs.getString("city");
                String province = rs.getString("province");
                String postal = rs.getString("postal");
                String street = rs.getString("street");

                Address newAddress = new Address(street, city, postal, province, "Canada");
                addressList.add(newAddress);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return addressList;
    }

    public ArrayList<Member> getMembers() {
        ArrayList<Member> memberList = new ArrayList<>();

        String SQL = "SELECT member_id, first_name, last_name, email_address, start_date, city, province, postal, street, duration, cost, discount_rate, plan_name, plan_id FROM member\n" +
                "JOIN address_member USING (member_id)\n" +
                "JOIN address USING (address_id)\n" +
                "JOIN member_plans USING (plan_id)\n" +
                "JOIN memberships USING (type_id)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Address address = new Address(rs.getString("street"), rs.getString("city"), rs.getString("postal"), rs.getString("province"), "Canada");
                Membership membership = getMembership(rs.getString("plan_name"), rs.getInt("plan_id"), rs.getInt("duration"), rs.getInt("discount_rate"));

                Member member = new Member(rs.getString("first_name"), rs.getString("last_name"), address, rs.getString("email_address"), rs.getInt("member_id"), rs.getDate("start_date"), membership);

                memberList.add(member);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return memberList;
    }


    public ArrayList<Integer> getFamilyOnPlan(int plan_id){
        ArrayList<Integer> family = new ArrayList<>();

        String SQL = "SELECT member_id FROM member\n" +
                "WHERE plan_id = " + plan_id + ";";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                family.add(rs.getInt("member_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return family;
    }

    /**
     * @param args the command line arguments
     */
    public static void main (String[]args){
        App app = new App();
        ArrayList<Member> membersFromDB = app.getMembers();
        membersFromDB.forEach(member -> System.out.println(member));
    }


    public Membership getMembership(String plan_type, int plan_id, int duration, double discount){
        switch (plan_type){
            case "Normal" -> {
                return new Normal(duration, discount);
            }
            case "Trial" -> {
                return new Trial(duration, discount);
            }
            case "Special Offer" -> {
                return new SpecialOffer(duration, discount);
            }
            case "Other" -> {
                return new Other(duration, discount);
            }
            case "Family" -> {
                // Function to fetch other family members
                return new Family(duration, discount, getFamilyOnPlan(plan_id));
            }
            default -> {
                return null;
            }
        }
    }
}