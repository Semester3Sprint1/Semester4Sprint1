package com.members.membership;

import com.general.Console;
import com.members.AddMember;
import com.members.Member;
import com.members.SearchForMember;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;

public class FamilyTest {
    HashMap<Integer, Member> members = new HashMap<>();

    @Test
    public void familyTest(){
        Member newMember = AddMember.createDefaultMember();
        newMember.setMemberID(1);
        members.put(newMember.getMemberID(), newMember);

        try (MockedStatic<SearchForMember> search = Mockito.mockStatic(SearchForMember.class)){
            search.when(() -> SearchForMember.findMember(1)).thenReturn(newMember);
            search.when(() -> SearchForMember.findMember(3)).thenReturn(null);

            try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)){
                console.when(() -> Console.readNumber("Enter the Member ID of each additional family member, or enter 0 to finish: ", 0)).thenReturn(3.0).thenReturn(1.0).thenReturn(0.0);
                Family membership = new Family();

                Assertions.assertTrue(membership.getFamilyMembers().size() == 1);
                Assertions.assertEquals(membership.getCost(), 270);
                Assertions.assertEquals(membership.getTypeCode(), 4);
                Assertions.assertEquals(membership.getDURATION_IN_DAYS(), 365);
                Assertions.assertEquals(membership.getDISCOUNT_RATE(), 0.1);

                Assertions.assertEquals(membership.getFormat().format(membership.getCost()), "$270.00");

                Assertions.assertEquals(membership.toString(), """
                Member Type: Family Plan
                Duration: 365 days
                Cost: $270.00
                Family members on plan: [Alex Ridgeley]""");
            }
        }
    }

    @Test
    public void familyTest_withConstructor(){
        ArrayList<String> familyMembers = new ArrayList<>();
        familyMembers.add("Alex Ridgeley");
        familyMembers.add("Mike Wadden");

        Family membership = new Family(60, 0.5, familyMembers);

        Assertions.assertEquals(membership.getCost(), 150);
        Assertions.assertEquals(membership.getTypeCode(), 4);
        Assertions.assertEquals(membership.getDURATION_IN_DAYS(), 60);
        Assertions.assertEquals(membership.getDISCOUNT_RATE(), 0.5);

        Assertions.assertEquals(membership.getFormat().format(membership.getCost()), "$150.00");
        Assertions.assertTrue(membership.getFamilyMembers().size() == 2);

        Assertions.assertEquals(membership.toString(), """
                Member Type: Family Plan
                Duration: 60 days
                Cost: $150.00
                Family members on plan: [Alex Ridgeley, Mike Wadden]""");
    }
}
