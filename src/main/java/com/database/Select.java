package com.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
    private java.sql.Connection connection = new Connection().connect();

    public void selectTest(){
        // Hard coded select statement - should probably include a version that takes in a value
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery( "SELECT * FROM public.address;" );

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
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
