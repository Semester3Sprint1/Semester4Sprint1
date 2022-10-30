package com.tournament;


import com.database.GetTournament;
import com.database.InsertTournament;
import com.general.*;
import com.general.consoleInterfaces.DateUserInput;
import com.general.consoleInterfaces.NumberUserInput;
import com.general.consoleInterfaces.StringUserInput;

import java.util.ArrayList;
import java.util.Scanner;


public class CreateTournament {
    private StringUserInput stringInput;
    private NumberUserInput numberInput;
    private DateUserInput dateInput;
    private Tournament tournament;



    public CreateTournament(StringUserInput stringInput, NumberUserInput numberInput, DateUserInput dateInput, Tournament tournament) {
        this.stringInput = stringInput;
        this.numberInput = numberInput;
        this.dateInput = dateInput;
        this.tournament = tournament;
    }

    public void setStringInput(StringUserInput stringInput) {
        this.stringInput = stringInput;
    }

    public void setNumberInput(NumberUserInput numberInput) {
        this.numberInput = numberInput;
    }

    public void setDateInput(DateUserInput dateInput) {
        this.dateInput = dateInput;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public StringUserInput getStringInput() {
        return stringInput;
    }

    public NumberUserInput getNumberInput() {
        return numberInput;
    }

    public DateUserInput getDateInput() {
        return dateInput;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public static void loadTournament(){
        GetTournament connection = new GetTournament();
        SearchForTournament.tList = connection.getTournament();
    }

    public static void  show(){
        Scanner input = new Scanner(System.in);
        DateValidator  validator = new DateCheck("MM/dd/yyyy");
       Tournament tournament = new Tournament();
       StringUserInput stringUserInput = new StringInput(input);
       NumberUserInput numberUserInput = new NumberInput(input);
       DateUserInput dateUserInput = new DateInput(input, validator);
        CreateTournament createTournament = new CreateTournament(stringUserInput, numberUserInput, dateUserInput, tournament);
       tournament = createTournament.tournamentInput(tournament);
       createTournament.setTournament(tournament);
        String  selection = stringUserInput.readChar("Enter Tournament Type (C) Charity or (T) Competitive: ", "C", "T");
        stringUserInput.nextLine();

    }

    private Tournament tournamentInput(Tournament tournament){
        String name = getStringInput().readLine("Enter Tournament Name: ");
        String startDate = getDateInput().readStringDate("Enter Tournament Start Date (03/22/2022) format: ");
        String endDate = getDateInput().readStringDate("Enter Tournament End Date (03/22/2022) format: ");
        getStringInput().nextLine();
        String location = getStringInput().readLine("Enter Tournament Location: ");
        double entryFee = getNumberInput().readNumber("Enter Entry fee: ", 0);
        getStringInput().nextLine();
        tournament.setName(name);
        tournament.setStartDate(startDate);
        tournament.setEndDate(endDate);
        tournament.setLocation(location);
        tournament.setEntryFee(entryFee);
        return tournament;
    }

    public void tournamentTypeChoice(Tournament tournament, String selection, InsertTournament insert, ArrayList<Tournament> tList){
        if(selection.toUpperCase().equals("C")){
            String charityName = getStringInput().readLine("Enter Charity Name: ");
            CharityTournament newTournament = new CharityTournament(tournament, charityName);
            int newID = insert.addTournamentToDB(newTournament);
            newTournament.setTournamentID(newID);
            insert.addCharityTypeToDB(newTournament);
           tList.add(newTournament);
        }else{
            double cashPrize = getNumberInput().readNumber("Enter Cash Prize: ", 1000, 100_000);
            CompetitiveTournament newTournament = new CompetitiveTournament(tournament, cashPrize);

            int newID = insert.addTournamentToDB(newTournament);
            newTournament.setTournamentID(newID);

            insert.addCompetitiveTypeToDB(newTournament);
            tList.add(newTournament);
        }
    }



    public  void userInput(InsertTournament insert) {
        // Takes input from user to build tournament constructor
        String name = getStringInput().readLine("Enter Tournament Name: ");
        String startDate = getDateInput().readStringDate("Enter Tournament Start Date (03/22/2022) format: ");
        String endDate = getDateInput().readStringDate("Enter Tournament End Date (03/22/2022) format: ");
        getStringInput().nextLine();
        String location = getStringInput().readLine("Enter Tournament Location: ");
        double entryFee = getNumberInput().readNumber("Enter Entry fee: ", 0);
        getStringInput().nextLine();
        String  selection = getStringInput().readChar("Enter Tournament Type (C) Charity or (T) Competitive: ", "C", "T");
        getStringInput().nextLine();

        if(selection.toUpperCase().equals("C")){
             String charityName = getStringInput().readLine("Enter Charity Name: ");
            CharityTournament newTournament = new CharityTournament(name, startDate, endDate, location, entryFee, charityName);
             int newID = insert.addTournamentToDB(newTournament);
             newTournament.setTournamentID(newID);

             insert.addCharityTypeToDB(newTournament);
             SearchForTournament.tList.add(newTournament);
        }else{
             double cashPrize = getNumberInput().readNumber("Enter Cash Prize: ", 1000, 100_000);
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
