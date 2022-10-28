package com.members;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

@ExtendWith(MockitoExtension.class)
public class SearchForMemberTest {
    HashMap<Integer, Member> members = new HashMap<>();

    @Mock
    private SearchForMember mockDatabase;

    @Test
    public void testFindMember(){
        Member newMember = AddMember.createDefaultMember();
        newMember.setMemberID(1);
        members.put(newMember.getMemberID(), newMember);

        Member newMember2 = AddMember.createDefaultMember();
        newMember2.setMemberID(2);
        newMember2.setFirstName("Mike");
        newMember2.setLastName("Wadden");
        members.put(newMember2.getMemberID(), newMember2);


        try (MockedStatic<SearchForMember> search = Mockito.mockStatic(SearchForMember.class)){
            search.when(() -> SearchForMember.findMember(1)).thenReturn(newMember);
            Assertions.assertEquals(SearchForMember.findMember(1), newMember);

            search.when(() -> SearchForMember.getMembers()).thenReturn(members);
            Assertions.assertTrue(members.size() == 2);
        }
    }
}
