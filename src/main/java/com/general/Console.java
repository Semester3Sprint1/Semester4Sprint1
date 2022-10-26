package com.general;

import java.util.Scanner;

public class Console {
    private static final Scanner input = new Scanner(System.in);

    // For number inputs - method overloaded to allow for min & max values if needed
    public static double readNumber(String prompt, double min) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = input.nextDouble();
            if (value >= min) {
                break;
            } else System.out.println("Enter a value greater than " + min);
        }
        return value;
    }

    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = input.nextDouble();
            if (value >= min && value <= max) {
                break;
            } else System.out.println("Enter a value between " + min + " and " + max);
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
                System.out.println("Invalid Entry: Input must be greater than " + min + " and less than " +  max);
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
                System.out.println("Invalid Entry: Input must be greater than " + min + " and less than " +  max);
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
            choice = input.next().trim();
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
            value = input.nextLine().trim();
           check =  validator.isValid(value);
            if(check)
                break;
            else System.out.println("Invalid Entry. Use the format mm/dd/yyyy");
        }
        return value;
    }
}
