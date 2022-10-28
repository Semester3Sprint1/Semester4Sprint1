package com.tournament;

import com.database.InsertTournament;
import com.database.TournamentDetail;
import com.general.Console;
import com.members.AddMember;
import com.members.Member;
import com.members.SearchForMember;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@ExtendWith(MockitoExtension.class)
public class RemoveMemberFromTournament {
    @Mock
    private TournamentDetail mockDBInsert;
    HashMap<Integer, Member> members = new HashMap<>();

    @Test
    public void removeMemberFromTournamentTest() {

        Member newMember = AddMember.createDefaultMember();
        newMember.setMemberID(1);
        members.put(newMember.getMemberID(), newMember);

        Member newMember2 = AddMember.createDefaultMember();
        newMember2.setMemberID(2);
        newMember2.setFirstName("Mike");
        newMember2.setLastName("Wadden");
        members.put(newMember2.getMemberID(), newMember2);
        CompetitiveTournament t1 = new CompetitiveTournament(1, "Mike Open", new Date("03/23/2022"), new Date("03/30/2022"), "The House", 500, 5000);

        SearchForTournament.tList.add(t1);
        try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)) {
            console.when(() -> Console.readNumber("Enter Tournament ID: ", 0)).thenReturn(1.0);

            }
        try (MockedStatic<SearchForTournament> tSearch = Mockito.mockStatic(SearchForTournament.class)) {
            tSearch.when(() -> SearchForTournament.findTournament(1)).thenReturn(t1);

        }

        try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)) {
            console.when(() -> Console.readNumber("Enter Member ID: ", 0)).thenReturn(1.00);
        }
        try (MockedStatic<SearchForMember> search = Mockito.mockStatic(SearchForMember.class)) {
            search.when(() -> SearchForMember.findMember(1)).thenReturn(newMember);
        }

        RemoveTournamentMember.show(mockDBInsert);

    }
}