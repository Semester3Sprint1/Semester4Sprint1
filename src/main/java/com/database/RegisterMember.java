package com.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterMember extends Connection{

    public void joinMemberAndTournament(int memberID, int tournament_id){
        String SQL = """
                INSERT INTO public.member_tournament(
                	member_id, tournament_id)
                	VALUES (?, ?);""";

        try (java.sql.Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, memberID);
            pstmt.setInt(2, tournament_id);

            int affectedRows = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void removeMemberFromTournament(int memberID, int tournamentID){
        String SQL = """
                DELETE FROM public.member_tournament
                	WHERE member_id = ? AND tournament_id = ?;""";

        try (java.sql.Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, memberID);
            pstmt.setInt(2, tournamentID);

            int affectedRows = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
