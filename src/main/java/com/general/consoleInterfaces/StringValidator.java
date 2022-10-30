package com.general.consoleInterfaces;

public interface StringValidator {

    boolean isValid(String value, int min, int max);
    boolean isValid(String value, String opt1, String opt2);
}
