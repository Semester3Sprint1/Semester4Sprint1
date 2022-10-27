package com.database;

import com.members.Member;

import java.util.ArrayList;

public class GetMembersByTournament extends Connection{

    public ArrayList<Member>  tournamentList = new ArrayList<>();

    public ArrayList<Member> getMembersByTournament(){

        String SQL = """
                SELECT   m.first_name || ' ' || m.last_name as member_name, t.name as tournament_name, mt.score, t.start_date from member_tournament mt
                JOIN member m USING (member_id)
                JOIN tournament t USING(tournament_id);
                                
                """;


        return tournamentList;
    }

}
