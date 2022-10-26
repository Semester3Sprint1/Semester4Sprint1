package com.database;

import com.members.Address;
import com.members.Member;
import com.members.membership.Membership;
import com.tournament.CharityTournament;
import com.tournament.CompetitiveTournament;
import com.tournament.Tournament;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetTournament extends Connection{

    public ArrayList<Tournament> getTournament(){
        ArrayList<Tournament> tournamentList = new ArrayList<>();

        String SQL = """
    SELECT t.tournament_id, t.name, t.start_date, t.end_date, t.location, t.entry_fee, td.cash_prize,
    td.charitity_name,td.tourney_type_id, td.money_raised, tt.type_name from tournament t
    JOIN tourney_type_details td USING (tournament_id)
    JOIN tourney_type tt USING (tourney_type_id)
    """;
        try (java.sql.Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // need to sort by Tournament Type to decide which constructor to use;
                int type = rs.getInt("tourney_type_id");
                if(type == 1){
                   CharityTournament tournament = new CharityTournament(rs.getString("name"),
                            rs.getDate("start_date"), rs.getDate("end_date"),
                                    rs.getString("location"), rs.getDouble("entry_fee"),
                                            rs.getString("charitity_name"));
                    tournament.setMoneyRaised(rs.getDouble("money_raised"));
                    tournamentList.add(tournament);
                } else if (type == 2) {
                    CompetitiveTournament tournament1 = new CompetitiveTournament(rs.getString("name"), rs.getDate("start_date"),
                            rs.getDate("end_date"), rs.getString("location"),
                            rs.getDouble("entry_fee"), rs.getDouble("cash_prize"));
                    tournamentList.add(tournament1);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tournamentList;

    }

}
