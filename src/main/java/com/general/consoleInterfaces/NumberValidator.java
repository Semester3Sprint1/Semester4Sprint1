package com.general.consoleInterfaces;

public interface NumberValidator {

    boolean isValid(double value, int min, int max);
    boolean isValid(double value, int min);
}
