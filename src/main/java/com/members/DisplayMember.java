package com.members;

import com.general.DateCheck;
import com.general.DateValidator;
import com.tournament.SearchForTournament;
import com.tournament.Tournament;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DisplayMember {
    private Member member;
    private HashMap<Integer, Member> members;

    public DisplayMember(Member member){
        this.member = member;
    }

    public DisplayMember(HashMap<Integer, Member> members){
        this.members = members;
    }

    public void displayMembers(){
        System.out.println("\nAll Members:");
        members.forEach((key, value) -> {
            System.out.println("-----------");
            System.out.println(value);
            System.out.println();
        });
    }

    public void displayMember(){
        if (member != null){
            System.out.println("\nMember Info: ");
            System.out.println("------------");
            System.out.println(member);
            System.out.println();

            // Gets Tournaments for this member
            getTournaments();
    }}

    public void getTournaments(){
        ArrayList<Tournament> tournaments = SearchForTournament.findTournaments(member.getName());
        ArrayList<String> pastTourney = new ArrayList<>();
        ArrayList<String> presentTourney = new ArrayList<>();
        ArrayList<String> futureTourney = new ArrayList<>();

        tournaments.forEach(tournament -> {
            // Check to see if tournament is now, before now, or after now
            DateValidator validator = new DateCheck(tournament.getStartDateObject(), new Date());
            switch (validator.dateCheck()){
                case 1 -> {
                    pastTourney.add(tournament.getName());
                }
                case 0 -> {
                    presentTourney.add(tournament.getName());
                }
                case -1 -> {
                    futureTourney.add(tournament.getName());
                }
            }
        });

        // Output
        System.out.println("Tournament Info");
        System.out.println("---------------");
        System.out.println();

        if (pastTourney.size() > 0) {
            System.out.println("Past Tournaments");
            System.out.println("----------------");
            pastTourney.forEach(System.out::println);
            System.out.println();
        }

        if (presentTourney.size() > 0) {
            System.out.println("Present Tournaments");
            System.out.println("-------------------");
            presentTourney.forEach(System.out::println);
            System.out.println();
        }

        if (futureTourney.size() > 0) {
            System.out.println("Future Tournaments");
            System.out.println("------------------");
            futureTourney.forEach(System.out::println);
            System.out.println();
        }
    }

}
