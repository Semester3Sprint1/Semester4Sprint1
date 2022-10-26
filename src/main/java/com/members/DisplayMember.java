package com.members;

import java.util.HashMap;

public class DisplayMember {
    private Member member;
    private HashMap<String, Member> members;

    public DisplayMember(Member member){
        this.member = member;
    }

    public DisplayMember(HashMap<String, Member> members){
        this.members = members;
    }

    public void displayMembers(){
        System.out.println("\nAll Members:");
        members.forEach((key, value) -> {
            System.out.println("-----------");
            System.out.println(value);
            System.out.println();
        });
    }

    public void displayMember(){
        if (member != null){
        System.out.println("\nMember Info: ");
        System.out.println(member);
        System.out.println();
    }}
}
