package com.members;

import com.general.Console;
import com.members.membership.*;

import java.util.HashMap;

public class AddMember {
    private static HashMap<Integer, Member> members = new HashMap<>();

    public static Member createMember(){
        // Perhaps we should change this to an auto-generated value?
        int memberID = (int) Console.readNumber("Enter member ID: ", 0);

        // Membership Type
        Membership memType = choosePlanType();
        Console.nextLine();

        // Member Info
        String firstName = Console.readString("First Name: ");
        String lastName = Console.readString("Last Name: ");
        String email = Console.readString("Email Address: ");
        String startDate =  Console.readStringDate("Start Date (MM/DD/YYYY): ");

        Address address = getAddress();

        Member member = new Member(firstName, lastName, address, email, memberID, startDate, memType);

        members.put(member.getMemberID(), member);

        new SearchForMember(members);

        return member;
    }

    public static Member createDefaultMember(){

        // Perhaps we should change this to an auto-generated value?
        int memberID = (int) Console.readNumber("Enter member ID: ", 0);

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

    public static Address getAddress(){
        // Address Info
        String streetAddress = Console.readLine("Street Address: ");
        String city = Console.readLine("City: ");
        String province = Console.readLine("Province: ");
        String postalCode = Console.readLine("Postal Code: ");

        Address address = new Address(streetAddress, city, postalCode, province, "Canada");
        return address;
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
