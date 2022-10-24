package com.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class SearchForMember {
    private static HashMap<String, Member> members;
    private static ArrayList<Member> members2;

    SearchForMember(HashMap<String, Member> members) {
        SearchForMember.members = members;
    }

    public static Member findMember(String memberID) {
        Member searchedAccount;
        var result = members2.stream().filter(m -> m.getMemberID().equals(memberID));
        boolean accountFound = members.containsKey(memberID);
        if (!accountFound) System.out.println("Invalid entry. That account ID does not exist.");
        searchedAccount = members.get(memberID);

        return searchedAccount;
    }

    public static void main(String[] args) {
    }
}