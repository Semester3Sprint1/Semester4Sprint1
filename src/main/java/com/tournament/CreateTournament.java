package com.tournament;

import com.general.Console;

public class CreateTournament {

    public static void userInput(){

        String id = Console.readString("Enter Tournament Name: ");
        String startDate = Console.readString("Enter Tournament Start Date (03/22/2022) format : ");
        String endDate = Console.readString("Enter Tournament End Date (03/22/2022) format :");
        String location = Console.readString("Enter Tournament Location: ");
        Double entryFee =  Console.readNumber("Enter Entry fee: ", 0);
       String  tournamentType = Console.readChar("Enter Tournament Type (C) Charity or (T) Competitive :" , "C", "T");
        tournamentChoiceLogic(tournamentType);
        System.out.println(tournamentType);
    }


    private static void tournamentChoiceLogic(String  selection){
        if(selection.equals("C")){
            String charityName = Console.readString("Enter Charity Name: ");
        }else{
            double cashPrize = Console.readNumber("Enter Cash Prize: ", 1000, 100_000 );
        }
    }


}
