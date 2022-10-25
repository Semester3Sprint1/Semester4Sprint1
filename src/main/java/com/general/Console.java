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
    public static String readString(String prompt) {
        String value;
        System.out.print(prompt);
        value = input.next();
        return value.toUpperCase();
    }


    public static String readLine(String prompt){
        String value;
        System.out.print(prompt);
        value = input.nextLine();
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
            choice = input.next();
            if (choice.toUpperCase().equals(opt1) || choice.toUpperCase().equals(opt2)) {
                break;
            } else {
                System.out.println("Invalid Entry! Enter (" + opt1 + " or " + opt2 + ")");
            }
        }
        return choice;


    }
}
