package com.database;

import com.members.Address;
import com.members.Member;
import com.members.SearchForMember;
import com.members.membership.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class GetMember extends Connection {
    public HashMap<Integer, Member> getMembers() {
        HashMap<Integer, Member> memberList = new HashMap<>();

        String SQL = """
                SELECT member_id, first_name, last_name, email_address, start_date, city, province, postal, street, 
                duration, cost, discount_rate, plan_name, plan_id FROM member
                JOIN address_member USING (member_id)
                JOIN address USING (address_id)
                JOIN member_plans USING (plan_id)
                JOIN memberships USING (type_id)""";
        try (java.sql.Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Address address = new Address(rs.getString("street"), rs.getString("city"),
                        rs.getString("postal"), rs.getString("province"), "Canada");

                Membership membership = getMembership(rs.getString("plan_name"),
                        rs.getInt("plan_id"), rs.getInt("duration"),
                        rs.getDouble("discount_rate"));

                Member member = new Member(rs.getString("first_name"), rs.getString("last_name"),
                        address, rs.getString("email_address"), rs.getInt("member_id"),
                        rs.getDate("start_date"), membership);

                memberList.put(rs.getInt("member_id"), member);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return memberList;
    }


    public ArrayList<String> getFamilyOnPlan(int plan_id){
        ArrayList<String> family = new ArrayList<>();

        String SQL = "SELECT member_id, first_name ||' '|| last_name as name FROM member\n" +
                "WHERE plan_id = ?;";
        try (java.sql.Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, plan_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                family.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return family;
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
