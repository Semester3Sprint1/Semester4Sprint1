package com.database;

import com.members.Address;
import com.members.Member;
import com.members.membership.Membership;

import java.sql.*;

public class InsertMember extends Connection {
    public int addMembershipPlan(Membership planToAdd){
        // Add Membership
        String SQL = """
                INSERT INTO public.member_plans(
                \tduration, cost, discount_rate, type_id)
                \tVALUES (?, ?, ?, ?);""";

        int id = 0;

        try (java.sql.Connection conn = connect();
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

    public int addMemberToPG(Member newMember, int plan_id){
        // Add Membership
        String SQL = """
                INSERT INTO public.member(
                	first_name, last_name, email_address, start_date, plan_id)
                	VALUES (?, ?, ?, ?, ?);""";

        int id = 0;

        try (java.sql.Connection conn = connect();
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

        try (java.sql.Connection conn = connect();
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

        try (java.sql.Connection conn = connect();
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
        int new_member_id = addMemberToPG(newMember, plan_id);

        // Add Address
        int new_address_id = addAddressToDB(addressToAdd);

        // Join Member and Address
        joinMemberAndAddress(new_member_id, new_address_id);

        return new_member_id;
    }
}
