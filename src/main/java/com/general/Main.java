package com.general;

import com.database.GetMembersByTournament;
import com.members.AddMember;
import com.menus.HomeMenu;
import com.tournament.CreateTournament;
import com.tournament.DisplayScores;
import com.tournament.Score;

public class Main {

    public static void main(String[] args){
        System.out.println("Loading database...");
        // Loads the members from the database
        AddMember.loadMembers();

        // loads the tournaments from the database;
        CreateTournament.loadTournament();
        GetMembersByTournament load = new GetMembersByTournament();
        load.getMembersByTournament();
        System.out.println("Load completed. Launching program.\n");
//        DisplayScores.displayScores("PG Open");
        HomeMenu.show();
    }
}
