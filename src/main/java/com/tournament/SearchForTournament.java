package com.tournament;

import com.members.Member;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SearchForTournament {

    // This is the list of Tournaments

    public static ArrayList<Tournament> tList = new ArrayList<>();

    public static Tournament findTournament(String name){
        Tournament tournament = tList.stream()
                .filter(m-> m.getName().toUpperCase().equals(name.toUpperCase())).findAny().orElse(null);
        return tournament;
    }

    //to find a tournament in the list by its name // Note prob should change to id
    public static Tournament findTournament(String name, ArrayList<Tournament> tList){
        Tournament tournament = tList.stream()
                .filter(m-> m.getName().toUpperCase().equals(name.toUpperCase())).findAny().orElse(null);
        return tournament;
    }

    public static ArrayList<Tournament> findTournaments(String memberName){
        ArrayList<Tournament> tourneyList = new ArrayList<>();

        tList.forEach(tournament -> {
            tournament.getAllMembers().forEach(score -> {
                if (score.getMember().getName().equals(memberName)) tourneyList.add(tournament);
            });
        });

        return tourneyList;
    }
}
