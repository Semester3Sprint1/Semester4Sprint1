package com.tournament;

import com.general.Console;


public class CreateTournament  {


    public static  void userInput(){

        // Takes input from user to build tournament constructor

       String name = Console.readLine("Enter Tournament Name: ");
        String startDate = Console.readStringDate("Enter Tournament Start Date (03/22/2022) format : ");
        String endDate = Console.readStringDate("Enter Tournament End Date (03/22/2022) format :");
        Console.nextLine();
        String location = Console.readLine("Enter Tournament Location: ");
        double entryFee =  Console.readNumber("Enter Entry fee: ", 0);
        Console.nextLine();
        String  selection = Console.readChar("Enter Tournament Type (C) Charity or (T) Competitive :" , "C", "T");
        Console.nextLine();
        if(selection.toUpperCase().equals("C")){
             String charityName = Console.readLine("Enter Charity Name: ");
            SearchForTournament.tList.add(new CharityTournament(name, startDate, endDate, location, entryFee, charityName));
        }else{
             double cashPrize = Console.readNumber("Enter Cash Prize: ", 1000, 100_000 );
            SearchForTournament.tList.add(new CompetitiveTournament(name, startDate, endDate, location, entryFee, cashPrize));
        }

    }


    public static void defaultTournamentInput(){
        String name = Console.readLine("Enter Tournament Name: ");
        String startDate = "03/22/2022";
        String endDate =  "03/23/2022";
        String location = "18 hole";
        double entryFee = 500.50;

        SearchForTournament.tList.add(new CharityTournament(name, startDate, endDate, location, entryFee, "Mikes Charity"));

    }






}
