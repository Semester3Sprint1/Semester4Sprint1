package com.general;

import java.util.Date;

public class Main {

    public static void main(String[]args){
        Member mem1 = AddMember.createMember();
        Member mem2 = AddMember.createMember();

        System.out.println(SearchForMember.findMember("A1"));

        System.out.println(mem1);
        System.out.println(mem2);
    }

    public static void addMember(){

    }
}
