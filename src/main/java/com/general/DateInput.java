package com.general;

import com.general.consoleInterfaces.DateUserInput;

import java.util.Scanner;


public class DateInput extends Console implements DateUserInput {

    private DateValidator validator;

    public DateInput(Scanner scanner, DateValidator validator) {
        super(scanner);
        this.validator = validator;
    }

    public DateValidator getValidator() {
        return validator;
    }

    public void setValidator(DateValidator validator) {
        this.validator = validator;
    }

    @Override
    public String readStringDate(String prompt) {
        String value = null;
        boolean inputIsValid = false;
        while(!inputIsValid){
            System.out.print(prompt);
            value = getScanner().next().trim();
            inputIsValid =  getValidator().isValid(value);
        }
        return value;
    }


}
