package com.members;

import java.util.HashMap;

public class SearchForMember {
    private static HashMap<Integer, Member> members;

    SearchForMember(HashMap<Integer, Member> members) {
        SearchForMember.members = members;
    }

    public static Member findMember(int memberID) {
        Member searchedAccount;

        boolean accountFound = members.containsKey(memberID);
        if (!accountFound) System.out.println("Invalid entry. That account ID does not exist.");
        searchedAccount = members.get(memberID);

        return searchedAccount;
    }

    public static HashMap<Integer, Member> getMembers() {
        return members;
    }
}