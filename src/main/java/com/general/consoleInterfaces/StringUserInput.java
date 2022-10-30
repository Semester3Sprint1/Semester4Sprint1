package com.general.consoleInterfaces;

import java.util.Scanner;

public interface StringUserInput extends  StringValidator{

    String readString(String prompt);
    String readLine(String prompt);

    String readChar(String prompt, String opt1, String opt2);
    void nextLine();
}
