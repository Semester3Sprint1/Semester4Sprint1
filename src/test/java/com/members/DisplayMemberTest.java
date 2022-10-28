package com.members;

import com.tournament.Tournament;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class DisplayMemberTest {

    @Test
    public void testDisplayMember(){
        Member testMember = AddMember.createDefaultMember();

        DisplayMember display = new DisplayMember(testMember);
        display.displayMember();
    }

    @Test
    public void testNullDisplay(){

        DisplayMember display = new DisplayMember(new HashMap<Integer, Member>());
        Assertions.assertNull(display.displayMember());
    }

    @Test
    public void displayMembers(){
        HashMap<Integer, Member> members = new HashMap<>();
        members.put(1, AddMember.createDefaultMember());
        members.put(2, AddMember.createDefaultMember());

        DisplayMember display = new DisplayMember(members);
        display.displayMembers();
    }
}
