package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class PostgreSQLSelect {
    public static void main( String args[] ) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://golf-database.cjuqnyg23emc.us-east-1.rds.amazonaws.com:5432/golf",
                            "mike", "database");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM public.address;" );
            while ( rs.next() ) {
                String id = rs.getString("address_id");
                String city = rs.getString("city");
                String province = rs.getString("province");
                String postal = rs.getString("postal");
                String street = rs.getString("street");


                System.out.println( "ID = " + id );
                System.out.println( "City = " + city );
                System.out.println( "Province = " + province );
                System.out.println( "Postal Code = " + postal );
                System.out.println( "Street Address = " + street );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}
