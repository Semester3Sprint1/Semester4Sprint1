package com.general;

import com.general.consoleInterfaces.StringUserInput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringInput extends Console implements StringUserInput {

    public StringInput(Scanner scanner, int min, int max) {
        super(scanner,  min, max);
    }

    public StringInput(Scanner scanner, int min) {
        super(scanner,  min);
    }

    public StringInput(Scanner scanner) {
        super(scanner);
    }

    @Override
    public String readString(String prompt) {
            String value = null;
            boolean isValid = false;
            while(!isValid){
                System.out.print(prompt);
                value = getScanner().next().trim();
                isValid = isValid(value, getMin(), getMax());

            }
            return value;
        }

    @Override
    public String readLine(String prompt) {
        String value = null;
        boolean inputIsValid = false;

        while (!inputIsValid){
            System.out.print(prompt);
            value = getScanner().nextLine().trim();
            inputIsValid = isValid(value, getMin(), getMax());
        }
        return value;
    }

    @Override
    public String readChar(String prompt, String opt1, String opt2) {
        String choice = null;
        boolean inputIsValid = false;
        while (!inputIsValid) {
            System.out.print(prompt);
            choice = getScanner().next().toUpperCase().trim();
            inputIsValid = isValid(choice, opt1, opt2);
        }
        return choice;
    }


    @Override
    public boolean isValid(String value, int min, int max) {
        boolean inputIsValid = false;
        try {
            if (value.trim().length() < min) {
                System.out.println("Invalid Entry: Input can not be Blank");
                inputIsValid = false;
            } else if (value.trim().length() > max) {
                System.out.println("Invalid Entry: Input can not be longer than " + max + " characters");
                inputIsValid = false;
            } else inputIsValid = true;
        }catch (InputMismatchException e){
            System.out.println("Invalid entry. Please enter a valid text entry.");
            getScanner().nextLine();
        }
        return  inputIsValid;
    }

    @Override
    public boolean isValid(String value, String opt1, String opt2) {
        boolean inputIsValid = false;

            try {
                if (value.toUpperCase().equals(opt1) || value.toUpperCase().equals(opt2)) {
                    inputIsValid = true;
                } else {
                    System.out.println("Invalid Entry! Enter (" + opt1 + " or " + opt2 + ")");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid entry. Please enter a valid text entry.");
                getScanner().nextLine();
            }
            return  inputIsValid;
    }


}
