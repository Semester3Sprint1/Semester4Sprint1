package com.database;

import com.members.Address;
import com.members.Member;
import com.members.membership.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

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
            // System.out.println("Connected to the PostgreSQL server successfully.");
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

    public HashMap<Integer, Member> getMembers() {
        HashMap<Integer, Member> memberList = new HashMap<>();

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

                memberList.put(rs.getInt("member_id"), member);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return memberList;
    }


    public ArrayList<Integer> getFamilyOnPlan(int plan_id){
        ArrayList<Integer> family = new ArrayList<>();

        String SQL = "SELECT member_id FROM member\n" +
                "WHERE plan_id = ?;";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, plan_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                family.add(rs.getInt("member_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return family;
    }

    public int addMembershipPlan(Membership planToAdd){
        // Add Membership
        String SQL = """
                INSERT INTO public.member_plans(
                \tduration, cost, discount_rate, type_id)
                \tVALUES (?, ?, ?, ?);""";

        int id = 0;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, planToAdd.getDURATION_IN_DAYS());
            pstmt.setDouble(2, planToAdd.getCost());
            pstmt.setDouble(3, planToAdd.getDISCOUNT_RATE());
            pstmt.setInt(4, planToAdd.getTypeCode());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return id;
    }

    public int addMemberToDBForReal(Member newMember, int plan_id){
        // Add Membership
        String SQL = """
                INSERT INTO public.member(
                	first_name, last_name, email_address, start_date, plan_id)
                	VALUES (?, ?, ?, ?, ?);""";

        int id = 0;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, newMember.getFirstName());
            pstmt.setString(2, newMember.getLastName());
            pstmt.setString(3, newMember.getEmail());
            pstmt.setTimestamp(4, Timestamp.from(newMember.getStartDateAsDate()));
            pstmt.setInt(5, plan_id);

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return id;
    }

    public int addAddressToDB(Address newAddress){
        String SQL = """
                INSERT INTO public.address(
                \tcity, province, postal, street)
                \tVALUES (?, ?, ?, ?);""";

        int id = 0;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, newAddress.getCity());
            pstmt.setString(2, newAddress.getProvince());
            pstmt.setString(3, newAddress.getPostalCode());
            pstmt.setString(4, newAddress.getStreetAddress());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return id;
    }

    public void joinMemberAndAddress(int memberID, int addressID){
        String SQL = """
                INSERT INTO public.address_member(
                \taddress_id, member_id)
                \tVALUES (?, ?);""";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, addressID);
            pstmt.setInt(2, memberID);

            int affectedRows = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int addMemberToDB(Member newMember){
        Address addressToAdd = newMember.getAddress();
        Membership planToAdd = newMember.getMembership();

        int plan_id = addMembershipPlan(planToAdd);

        // Add Member
        int new_member_id = addMemberToDBForReal(newMember, plan_id);

        // Add Address
        int new_address_id = addAddressToDB(addressToAdd);

        // Join Member and Address
        joinMemberAndAddress(new_member_id, new_address_id);

        return new_member_id;
    }


    /**
     * @param args the command line arguments
     */
    public static void main (String[]args){
        App app = new App();
        HashMap<Integer, Member> membersFromDB = app.getMembers();
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