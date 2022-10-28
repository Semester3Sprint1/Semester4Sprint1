package com.general;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private static final Scanner input = new Scanner(System.in);
    private static final DateValidator validator = new DateCheck("MM/dd/yyyy");

    // For number inputs - method overloaded to allow for min & max values if needed

    // Main Methods
    public static double readNumber(String prompt, double min) {
        double value;
        while (true) {
            try {
                System.out.print(prompt);
                value = input.nextDouble();
                if (value >= min) {
                    break;
                } else System.out.println("Enter a value greater than " + min);
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry. Please enter a number.");
                input.nextLine();
            }

        }
        return value;
    }

    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            try {
                System.out.print(prompt);
                value = input.nextDouble();
                if (value >= min && value <= max) {
                    break;
                } else System.out.println("Enter a value between " + min + " and " + max);
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry. Please enter a number.");
                input.nextLine();
            }

        }
        return value;
    }

    // For string inputs

    // Read String uses next and is designed for one word inputs
    public static String readString(String prompt) {
        String value;
        System.out.print(prompt);
        value = input.next().trim();
        return value.toUpperCase();
    }


    public static String readString(String prompt, int min, int max){
        String value;

        while(true){
            System.out.print(prompt);
            value = input.next().trim();

            if(value.length() < min || value.length() > max){
                System.out.println("Invalid Entry: Input length can not be blank and more than " + max + " characters");
            }else break;

        }
        return value;
    }

    // Readline is designed for multi-word inputs

    public static String readLine(String prompt, int min, int max){
        String value;

        while(true){
            System.out.print(prompt);
            value = input.nextLine().trim();

            if(value.length() < min || value.length() > max){
                System.out.println("Invalid Entry: Input length can not be blank and more than " + max + " characters");
            }else break;

        }
        return value;
    }


    public static String readLine(String prompt){
        String value;
        System.out.print(prompt);
        value = input.nextLine().trim();
        return value;
    }

    public static void nextLine(){
        // Skips to the next line
        input.nextLine();
    }

    public static String readChar(String prompt, String opt1, String opt2) {
        String choice;
        while (true) {
            System.out.print(prompt);
            choice = input.next().toUpperCase().trim();
            if (choice.toUpperCase().equals(opt1) || choice.toUpperCase().equals(opt2)) {
                break;
            } else {
                System.out.println("Invalid Entry! Enter (" + opt1 + " or " + opt2 + ")");
            }
        }
        return choice;
    }

    public static String readStringDate(String prompt){
        String value;
        boolean check;
        DateValidator validator = new DateCheck("MM/dd/yyyy");
        while(true){
            System.out.print(prompt);
            value = input.next().trim();
           check =  validator.isValid(value);
            if(check)
                break;
            else System.out.println("Invalid Entry. Use the format mm/dd/yyyy");
        }
        return value;
    }


    // methods for Testing
    public static double readNumber(String prompt, double min, Scanner input) {
        double value;
        while (true) {
            try {
                System.out.print(prompt);
                value = input.nextDouble();
                if (value >= min) {
                    break;
                } else {
                    System.out.println("Enter a value greater than " + min);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry. Please enter a number.");
                input.nextLine();
            }

        }
        return value;
    }

    public static double readNumber(String prompt, double min, double max, Scanner input) {
        double value;
        while (true) {
            try {
                System.out.print(prompt);
                value = input.nextDouble();
                if (value >= min && value <= max) {
                    break;
                } else System.out.println("Enter a value between " + min + " and " + max);
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry. Please enter a number.");
                input.nextLine();
            }

        }
        return value;
    }


    public static String readString(String prompt, int min, int max, Scanner input){
        String value;

        while(true){
            System.out.print(prompt);
            value = input.next().trim();

            if(value.length() < min || value.length() > max){
                System.out.println("Invalid Entry: Input length can not be blank and more than " + max + " characters");
            }else break;

        }
        return value;
    }


    public static String readLine(String prompt, int min, int max, Scanner input){
        String value;

        while(true){
            System.out.print(prompt);
            value = input.nextLine().trim();

            if(value.length() < min || value.length() > max){
                System.out.println("Invalid Entry: Input length can not be blank and more than " + max + " characters");
            }else break;

        }
        return value;
    }


    public static String readChar(String prompt, String opt1, String opt2,Scanner input) {
        String choice;
        while (true) {
            System.out.print(prompt);
            choice = input.next().toUpperCase().trim();
            if (choice.toUpperCase().equals(opt1) || choice.toUpperCase().equals(opt2)) {
                break;
            } else {
                System.out.println("Invalid Entry! Enter (" + opt1 + " or " + opt2 + ")");
            }
        }
        return choice;
    }

    public static String readStringDate(String prompt,Scanner input, DateValidator validator){
        String value;
        boolean check;
        while(true){
            System.out.print(prompt);
            value = input.next().trim();
            check =  validator.isValid(value);
            if(check)
                break;
            else System.out.println("Invalid Entry. Use the format mm/dd/yyyy");
        }
        return value;
    }

}
