package com.general;

import java.util.Date;

public class Main {

    public static void main(String[]args){

        Trial m1 = new Trial();
        Address address1 = new Address("21 first street", "St.John's",
                "A1A5A5", "NL", "Canada");
        Member member1 = new Member("Mike", "Wadden", address1, "mike@email.com", "M2","03/23/2022", m1  );
        System.out.println(member1);


    }
}
