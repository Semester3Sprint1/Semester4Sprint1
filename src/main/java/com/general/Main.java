package com.general;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[]args){
//        Member mem1 = AddMember.createMember();
//        Member mem2 = AddMember.createMember();
//        Member mem3 = AddMember.createMember();
//        Member mem4 = AddMember.createMember();


        Trial m1 = new Trial();
        Address address1 = new Address("21 first street", "St.John's",
                "A1A5A5", "NL", "Canada");
        Address address2 = new Address("55 second street", "Paradise",
                "A1A5A7", "NL", "Canada");
        Member member1 = new Member("Mike", "Wadden", address1, "mike@email.com", "M2","03/23/2022", m1  );
        Member member2 = new Member("Alex", "Ridgeley", address1, "alex@email.com", "A2","05/15/2022", m1  );
        System.out.println(member1);
        System.out.println(member2);
        CompetitiveTournament t1 = new CompetitiveTournament("Alex Open", "04/22/2022","04/23/2022", "The Wilds", 500, 10_000 );
        System.out.println(t1);
        t1.addMember(member1);
        t1.addMember(member2);
        t1.displayTournamentParticipants();

        CharityTournament t2 = new CharityTournament("RBC Charity Tournament", "05/15/2022", "05/15/2022", "The Wild", 1000,
                "RBC Water for All foundation");
        t2.setMoneyRaised(50_000);

        t2.addMember(member1);
        t2.addMember(member2);
        System.out.println(t2);
        t2.displayTournamentParticipants();

//        Member mem5 = AddMember.createFamilyMember();


//        System.out.println(mem5.getMembership());

    }

}
