package com.database;

import com.members.Member;
import com.members.SearchForMember;
import com.tournament.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class GetMembersByTournament extends Connection{

    public ArrayList<Score> getMembersByTournament(Tournament tournament){
        ArrayList<Score> memberList = new ArrayList<>();

        String SQL = """
                SELECT   m.member_id, t.tournament_id, t.name as tournament_name, mt.score, t.start_date from member_tournament mt
                JOIN member m USING (member_id)
                JOIN tournament t USING(tournament_id)
                WHERE t.name = ?;
                """;

        try (java.sql.Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, tournament.getName());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // need to sort by Tournament Type to decide which constructor to use;
                int score = rs.getInt("score");
                int member_id = rs.getInt("member_id");
                Member theMember = SearchForMember.findMember(member_id);
                memberList.add(new Score(score, theMember, tournament));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return memberList;
    }

}
