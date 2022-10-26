package com.database;

import com.members.Address;

import java.sql.*;
import java.util.ArrayList;

public class Connection {
    private static final String url = "jdbc:postgresql://golf-database.cjuqnyg23emc.us-east-1.rds.amazonaws.com:5432/golf";
    private static final String user = "alex";
    private static final String password = "password";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public java.sql.Connection connect() {
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            // System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

//    /**
//     * Call a built-in stored function demo
//     *
//     * @param s
//     * @return
//     */
//    public String properCase(String s) {
//        String result = s;
//        try (java.sql.Connection conn = this.connect();
//             CallableStatement properCase = conn.prepareCall("{ ? = call initcap( ? ) }")) {
//            properCase.registerOutParameter(1, Types.VARCHAR);
//            properCase.setString(2, s);
//            properCase.execute();
//            result = properCase.getString(1);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return result;
//    }
//
//    public ArrayList<Address> getAddresses() {
//        ArrayList<Address> addressList = new ArrayList<>();
//
//        String SQL = "SELECT * FROM address";
//        try (java.sql.Connection conn = this.connect();
//             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
//
//            ResultSet rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                String id = rs.getString("address_id");
//                String city = rs.getString("city");
//                String province = rs.getString("province");
//                String postal = rs.getString("postal");
//                String street = rs.getString("street");
//
//                Address newAddress = new Address(street, city, postal, province, "Canada");
//                addressList.add(newAddress);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return addressList;
//    }

    /**
     * @param args the command line arguments
     */
//    public static void main (String[]args){
//        App app = new App();
//        HashMap<Integer, Member> membersFromDB = app.getMembers();
//    }
}