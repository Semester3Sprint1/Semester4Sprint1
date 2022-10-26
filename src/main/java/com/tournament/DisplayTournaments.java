package com.tournament;

public class DisplayTournaments {

    public static void show(){
        SearchForTournament.tList
                .forEach(m-> System.out.println(m.getName()));
    }
}
