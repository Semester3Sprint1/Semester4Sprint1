package com.tournament;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SearchForTournament {

    // This is the list of Tournaments

    public static ArrayList<Tournament> tList = new ArrayList<>();

    //to find a tournament in the list by its name // Note prob should change to id
    public static Tournament findTournament(String name, ArrayList<Tournament> tList){
        Tournament tournament = tList.stream()
                .filter(m-> m.getName().toUpperCase().equals(name.toUpperCase())).findAny().orElse(null);
        return tournament;
    }


}
