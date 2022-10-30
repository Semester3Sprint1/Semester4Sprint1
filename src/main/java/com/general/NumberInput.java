package com.general;

import com.general.consoleInterfaces.NumberUserInput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberInput extends Console implements NumberUserInput {

    public NumberInput(Scanner scanner,  int min, int max) {
        super(scanner,  min, max);
    }

    public NumberInput(Scanner scanner, int min) {
        super(scanner, min);
    }

    public NumberInput(Scanner scanner) {
        super(scanner);
    }

    @Override
    public double readNumber(String prompt, int min, int max) {
        double value = 0;
        boolean isValid = false;
        while (!isValid) {
                System.out.print(prompt);
                value = getScanner().nextDouble();
                isValid = isValid(value, min, max);
            }
        return value;
        }


    @Override
    public double readNumber(String prompt, int min) {
        double value = 0;
        boolean inputIsValid = false;
        while (!inputIsValid) {
            System.out.print(prompt);
            value = getScanner().nextDouble();
            inputIsValid = isValid(value, min);
        }
        return value;
    }

    @Override
    public boolean isValid(double value, int min, int max) {
        boolean inputIsValid = false;
        try {
            if (value >= min && value <= max) {
                inputIsValid = true;
            } else {
                System.out.println("Enter a value between " + min + " and " + max);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid entry. Please enter a number.");

            getScanner().nextLine();
        }
        return inputIsValid;
    }

    @Override
    public boolean isValid(double value, int min) {
        boolean isValid = false;
        try {
            if (value >= min) {
                isValid = true;
            } else {
                System.out.println("Enter a greater than " + min );
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid entry. Please enter a number.");
            getScanner().nextLine();
        }
        return isValid;
    }
}
