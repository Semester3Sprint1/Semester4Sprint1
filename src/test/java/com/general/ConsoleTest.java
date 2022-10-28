package com.general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
public class ConsoleTest {

    @Mock
    private Scanner mockScanner;

    @Test
    public void readStringTest() {

        Mockito.when(mockScanner.next()).thenReturn("Open");


    }

    @Test
    public void readNumberWithMinTestCorrectInputTest(){

      Mockito.when(mockScanner.nextDouble()).thenReturn(5.0);
      int res = (int) Console.readNumber("Input Number", 0,mockScanner);
      Assertions.assertEquals(5, res);

    }

    @Test
    public void readNumberWithMixMaxCorrectInputTest(){
        Mockito.when(mockScanner.nextDouble()).thenReturn(10.0);
        int res = (int) Console.readNumber("Input Number", 0,100,mockScanner);
        Assertions.assertEquals(10, res);
    }

    @Test
    public void readStringWithMinMaxCorrectInputTest(){
        Mockito.when(mockScanner.next()).thenReturn("Mike");
        String res = Console.readString("Input String", 1, 150, mockScanner );
        Assertions.assertEquals("Mike", res);

    }


    @Test
    public void readLineWithMinMaxCorrectInputTest(){
        Mockito.when(mockScanner.nextLine()).thenReturn("Mike Open");
        String res = Console.readLine("Input String", 1, 150, mockScanner );
        Assertions.assertEquals("Mike Open", res);
    }
}
