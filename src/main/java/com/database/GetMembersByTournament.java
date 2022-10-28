package com.database;

import com.members.Member;
import com.members.SearchForMember;
import com.tournament.*;
import com.tournament.scoring.Score;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class GetMembersByTournament extends Connection{

    public ArrayList<Member> tournamentList = new ArrayList<>();



    public void getMembersByTournament(){

        String SQL = """
                SELECT   m.first_name || ' ' || m.last_name as member_name, t.name as tournament_name, mt.score, t.start_date, m.member_id from member_tournament mt
                JOIN member m USING (member_id)
                JOIN tournament t USING(tournament_id);              
                """;

        try (java.sql.Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("member_name");

                String tournamentName = rs.getString("tournament_name");
                int score = rs.getInt("score");
                Date startDate = rs.getDate("start_date");
                int member_id = rs.getInt("member_id");
                Tournament tournamentToUse = SearchForTournament.findTournament(tournamentName, SearchForTournament.tList);
                Member memberToAdd = SearchForMember.findMember(member_id);
                tournamentToUse.addMember(memberToAdd);

                Score newScore = new Score(score, memberToAdd, tournamentToUse);
                Score.getScoreList().add(newScore);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
