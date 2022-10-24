package com.general;

import java.util.Objects;

public class SearchForMember {
    private static Member[] members;

    SearchForMember(Member[] members) {
        SearchForMember.members = members;
    }

    public static Member findMember(String memberID) {
        Member searchedAccount = null;
        boolean accountFound = false;
        while (!accountFound) {
            for (Member member : members) {
                if (member != null) {
                    if (Objects.equals(member.getMemberID(), memberID)) {
                        searchedAccount = member;
                        accountFound = true;
                        break;
                    }
                }
            }
            if (!accountFound) System.out.println("Invalid entry. That account ID does not exist.");
        }
        return searchedAccount;
    }
}