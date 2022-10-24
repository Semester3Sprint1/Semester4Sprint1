package com.general;

import java.util.HashMap;

public class AddMember {
    private static HashMap<String, Member> members = new HashMap<>();

    public static Member createMember(){
        String memberID = Console.readString("Enter member ID: ");

        // Membership Type
        Trial m1 = new Trial();

        // Address Info
        Address address1 = new Address("21 first street", "St.John's",
                "A1A5A5", "NL", "Canada");

        // Member Info
        Member member = new Member("Mike", "Wadden", address1, "mike@email.com", memberID,"03/23/2022", m1);
        members.put(member.getMemberID(), member);

        new SearchForMember(members);

        return member;
    }
}
