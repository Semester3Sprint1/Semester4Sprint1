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
                        "mike", "database");

        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

//        stmt = c.createStatement();
//        String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
//                + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
//        stmt.executeUpdate(sql);
//
//        sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
//                + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
//        stmt.executeUpdate(sql);
//
//        sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
//                + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
//        stmt.executeUpdate(sql);
//
//        sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
//                + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
//        stmt.executeUpdate(sql);
//
//        stmt.close();
        c.commit();
        c.close();
    } catch (Exception e) {
        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        System.exit(0);
    }
    System.out.println("Records created successfully");
}
}
