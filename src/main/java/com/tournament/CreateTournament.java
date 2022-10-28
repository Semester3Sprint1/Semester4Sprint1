package com.tournament;

import com.database.GetMember;
import com.database.GetTournament;
import com.database.InsertTournament;
import com.general.Console;
import com.members.AddMember;
import com.members.Member;

import java.util.ArrayList;
import java.util.HashMap;


public class CreateTournament  {

    public static void loadTournament(){
        GetTournament connection = new GetTournament();
        SearchForTournament.tList = connection.getTournament();
    }

    public static  void userInput(InsertTournament insert) {
        // Takes input from user to build tournament constructor
       String name = Console.readLine("Enter Tournament Name: ", 5, 200);
        String startDate = Console.readStringDate("Enter Tournament Start Date (03/22/2022) format: ");
        String endDate = Console.readStringDate("Enter Tournament End Date (03/22/2022) format: ");
        Console.nextLine();
        String location = Console.readLine("Enter Tournament Location: ", 5, 200);
        double entryFee =  Console.readNumber("Enter Entry fee: ", 0);
        Console.nextLine();
        String  selection = Console.readChar("Enter Tournament Type (C) Charity or (T) Competitive: " , "C", "T");
        Console.nextLine();
        if(selection.toUpperCase().equals("C")){
             String charityName = Console.readLine("Enter Charity Name: ", 3, 150);
             CharityTournament newTournament = new CharityTournament(name, startDate, endDate, location, entryFee, charityName);

             int newID = insert.addTournamentToDB(newTournament);
             newTournament.setTournamentID(newID);

             insert.addCharityTypeToDB(newTournament);
             SearchForTournament.tList.add(newTournament);
        }else{
             double cashPrize = Console.readNumber("Enter Cash Prize: ", 1000, 100_000 );
             CompetitiveTournament newTournament = new CompetitiveTournament(name, startDate, endDate, location, entryFee, cashPrize);

             int newID = insert.addTournamentToDB(newTournament);
             newTournament.setTournamentID(newID);

             insert.addCompetitiveTypeToDB(newTournament);
             SearchForTournament.tList.add(newTournament);
        }
    }

    public static Tournament createDefaultTournament(String selection){
        String name = "PG Open";
        String startDate = "10/10/1991";
        String endDate = "10/11/1991";

        String location = "St. John's";
        double entryFee =  25.00;

        if(selection.equals("C")){
            String charityName = "Ultima Charity";
            CharityTournament newTournament = new CharityTournament(name, startDate, endDate, location, entryFee, charityName);

            SearchForTournament.tList.add(newTournament);
            return newTournament;
        } else {
            double cashPrize = 1000.0;
            CompetitiveTournament newTournament = new CompetitiveTournament(name, startDate, endDate, location, entryFee, cashPrize);

            SearchForTournament.tList.add(newTournament);
            return newTournament;
        }
    }
}
