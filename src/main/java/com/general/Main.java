package com.general;

import java.util.Date;

public class Main {

    public static void main(String[]args){
        Member mem1 = AddMember.createMember();
        Member mem2 = AddMember.createMember();
        Member mem3 = AddMember.createMember();
        Member mem4 = AddMember.createMember();

        Member mem5 = AddMember.createFamilyMember();

        System.out.println(mem5.getMembership());

    }

    public static void addMember(){

    }
}
