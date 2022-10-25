package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PostgreSQLJDBC {
//    public static void main(String args[]) {
//        Connection c = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            c = DriverManager
//                    .getConnection("jdbc:postgresql://localhost:5432/golf",
//                            "alex", "password");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println(e.getClass().getName()+": "+e.getMessage());
//            System.exit(0);
//        }
//        System.out.println("Opened database successfully");
//    }

public static void main(String args[]) {
    Connection c = null;
    Statement stmt = null;

    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager
                .getConnection("jdbc:postgresql://golf-database.cjuqnyg23emc.us-east-1.rds.amazonaws.com:5432/golf",
                        "alex", "password");

        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        String sql = "INSERT INTO public.address(city, province, postal, street)"
                + "VALUES ('Townton', 'NL', 'A0E 2M0', '2 First Street' );";
        stmt.executeUpdate(sql);

        stmt.close();
        c.commit();
        c.close();
    } catch (Exception e) {
        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        System.exit(0);
    }
    System.out.println("Records created successfully");
}
}
