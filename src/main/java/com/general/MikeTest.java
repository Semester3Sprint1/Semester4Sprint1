package com.general;

import com.members.Address;
import com.members.Member;
import com.members.membership.Membership;
import com.members.membership.Normal;
import com.tournament.*;

public class MikeTest {

    public static void main(String[] args){
        Address address1 = new Address("21 first avenue", "St.John's", "A1A5A5", "NL", "Canada" );
        Normal ms = new Normal();
        Member member1 = new Member("Mike", "Wadden", address1, "mike@email.com", "mike1", "03/23/2022", ms);
        CharityTournament t1 = new CharityTournament("PG Open", "03/25/2022", "03/26/2022", "18 Hole Course", 500, "RMDH");
        CompetitiveTournament t2 = new CompetitiveTournament("Clovally Classic", "04/25/2022", "04/25/2022", "9 hole course", 1000, 10_000);
        SearchForTournament.tList.add(t1);
        SearchForTournament.tList.add(t2);
        Tournament foundTournament = SearchForTournament.findTournament("pg open");
        System.out.println(foundTournament);



    }
}
