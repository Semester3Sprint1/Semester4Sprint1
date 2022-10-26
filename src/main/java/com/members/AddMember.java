package com.members;

import com.database.Connection;
import com.database.GetMember;
import com.database.InsertMember;
import com.general.Console;
import com.members.membership.*;

import java.util.HashMap;

public class AddMember {
    private static HashMap<Integer, Member> members = new HashMap<>();

    public static void loadMembers(){
        GetMember connection = new GetMember();
        members = connection.getMembers();

        new SearchForMember(members);
    }

    public static Member createMember(){
        // Membership Type
        Membership memType = choosePlanType();
        //Console.nextLine();

        // Member Info
        String firstName = Console.readString("First Name: ", 1, 32);
        String lastName = Console.readString("Last Name: ", 1, 32);
        String email = Console.readString("Email Address: ", 1, 32);

        //Console.nextLine();
        String startDate =  Console.readStringDate("Start Date (MM/DD/YYYY): ");

        Address address = getAddress();

        Member member = new Member(firstName, lastName, address, email, startDate, memType);


        InsertMember insert = new InsertMember();
        int newID = insert.addMemberToDB(member);

        member.setMemberID(newID);

        members.put(member.getMemberID(), member);

        new SearchForMember(members);

        return member;
    }

    public static Address getAddress(){
        Console.nextLine();

        // Address Info
        String streetAddress = Console.readLine("Street Address: ", 1, 32);
        String city = Console.readLine("City: ", 1, 32);
        String province = Console.readLine("Province: ", 1, 32);
        String postalCode = Console.readLine("Postal Code: ", 1, 32);

        Address address = new Address(streetAddress, city, postalCode, province, "Canada");
        return address;
    }

    // These two functions could be useful for testing
    public static Member createDefaultMember(){

        // Perhaps we should change this to an auto-generated value?
        int memberID = 1;

        // Membership Type
        Membership memType = choosePlanType();
        Console.nextLine();

        // Member Info
        String firstName = "Alex";
        String lastName = "Ridgeley";
        String email = "aridgeley@msn.com";
        String startDate =  "10/10/1991";

        Address address = getDefaultAddress();

        Member member = new Member(firstName, lastName, address, email, memberID, startDate, memType);

        members.put(member.getMemberID(), member);

        new SearchForMember(members);

        return member;
    }

    public static Address getDefaultAddress(){
        // Address Info
        String streetAddress = "51A Amherst Heights";
        String city = "St. John's";
        String province = "NL";
        String postalCode = "A0E 2M0";


        Address address = new Address(streetAddress, city, postalCode, province, "Canada");
        return address;
    }

    public static Membership choosePlanType(){
        while(true){
            System.out.println("""
                    Please choose a Membership Plan:
                        1. Normal Plan
                        2. 30-day free trial
                        3. Promotional Offer
                        4. Family Plan
                        5. Other
                    """);
            int selection = (int) Console.readNumber("Enter Selection: " , 1,5);
            System.out.println();

            switch(selection){
                case 1 -> {
                    return new Normal();
                }
                case 2 -> {
                    return new Trial();
                }
                case 3 -> {
                    return new SpecialOffer();
                }
                case 4  -> {
                    return new Family();
                }
                case 5 -> {
                    return new Other();
                }
                default -> {
                    System.out.println("Invalid Entry. Please choose a option between 1 and 5");
                    System.out.println();
                }
            }
        }
    }

    public static HashMap<Integer, Member> getMembers() {
        return members;
    }

    public static void removeMembers(Member member){
        members.remove(member.getMemberID());
        new SearchForMember(members);
    }
}
