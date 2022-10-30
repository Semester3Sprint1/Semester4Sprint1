package com.general.consoleInterfaces;

import java.util.Scanner;

public interface NumberUserInput extends NumberValidator {

    double  readNumber(String prompt, int min, int max);
    double readNumber(String prompt, int min);
    void nextLine();
}
