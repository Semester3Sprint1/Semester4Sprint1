package com.database;

import com.tournament.CharityTournament;
import com.tournament.CompetitiveTournament;
import com.tournament.Tournament;

import java.sql.*;

public class InsertTournament extends Connection{
//     System.out.println(Tournament.tournamentCount);

    private int index;

    public void addTournamentToDB(Tournament newTournament) {

        String SQL = """
                INSERT INTO public.tournament(
                	\tname, start_date, end_date, location, entry_fee)
                	\tVALUES ( ?, ?, ?, ?, ?);
                """;


        index = Tournament.tournamentCount;
        index++;


        try (java.sql.Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

             pstmt.setString(1, newTournament.getName());
             pstmt.setTimestamp(2, Timestamp.from(newTournament.getStartDateObject().toInstant()));
             pstmt.setTimestamp(3, Timestamp.from(newTournament.getEndDateObject().toInstant()));
             pstmt.setString(4, newTournament.getLocation());
             pstmt.setDouble(5, newTournament.getEntryFee());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        index = rs.getInt(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    }

    public void addCharityTypeToDB(CharityTournament newTournament) {

        String SQL = """
                INSERT INTO public.tourney_type_details(
                	\ttourney_type_id, tournament_id, charitity_name,money_raised)
                	\tVALUES (?, ?, ?, ?);
                """;

        try (java.sql.Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, 2);
            pstmt.setInt(2, this.index);
            pstmt.setString(3, newTournament.getCharityName());
            pstmt.setDouble(4, newTournament.getMoneyRaised());


            int affectedRows = pstmt.executeUpdate();

        } catch (SQLException ex) {

        }

    }

    public void addCompetitiveTypeToDB(CompetitiveTournament newTournament) {

        String SQL = """
                INSERT INTO public.tourney_type_details(
                	\ttourney_type_id, tournament_id, cash_prize)
                	\tVALUES (?, ?, ?);
                """;

        try (java.sql.Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, 1);
            pstmt.setInt(2, this.index);
            pstmt.setDouble(3, newTournament.getCashPrize());

            int affectedRows = pstmt.executeUpdate();

        } catch (SQLException ex) {

        }

    }
}


