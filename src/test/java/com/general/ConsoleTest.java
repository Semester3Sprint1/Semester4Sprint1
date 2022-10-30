package com.general;

import com.general.consoleInterfaces.StringUserInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ConsoleTest {

    @Mock
    private Scanner mockScanner;



    @Test
    public void readStringWithMinTestCorrectInputTest(){
        StringUserInput input = new StringInput(mockScanner,  0, 100);
        Mockito.when(mockScanner.next()).thenReturn("Mike");
        String res = input.readString("Enter String");
        Assertions.assertEquals("Mike", res);

    }




}
