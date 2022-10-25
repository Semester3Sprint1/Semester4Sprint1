package com.tournament;

import com.general.Console;


public class CreateTournament  {


    public static  void userInput(){

       String name = Console.readLine("Enter Tournament Name: ");
        String startDate = Console.readString("Enter Tournament Start Date (03/22/2022) format : ");
        String endDate = Console.readString("Enter Tournament End Date (03/22/2022) format :");
        String location = Console.readLine("Enter Tournament Location: ");
        double entryFee =  Console.readNumber("Enter Entry fee: ", 0);
        Console.nextLine();
        String  selection = Console.readChar("Enter Tournament Type (C) Charity or (T) Competitive :" , "C", "T");

        if(selection.toUpperCase().equals("C")){
             String charityName = Console.readLine("Enter Charity Name: ");
            Tournament.tList.add(new CharityTournament(name, startDate, endDate, location, entryFee, charityName));
        }else{
             double cashPrize = Console.readNumber("Enter Cash Prize: ", 1000, 100_000 );
            Tournament.tList.add(new CompetitiveTournament(name, startDate, endDate, location, entryFee, cashPrize));
        }


    }






}
