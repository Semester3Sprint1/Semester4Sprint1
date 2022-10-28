package com.general;

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
    public void readNumberWithMinTestCorrectInputTest(){

        Mockito.when(mockScanner.nextDouble()).thenReturn(5.0);
        int res = (int) Console.readNumber("Input Number", 0,mockScanner);
        Assertions.assertEquals(5, res);

    }

    @Test
    public void readNumberWithMinIncorrectInput(){

        Mockito.when(mockScanner.nextDouble()).thenReturn(-5.0).thenReturn(5.0);
        int res = (int) Console.readNumber("Input Number", 0,mockScanner);
        Assertions.assertEquals(5, res);

    }

    @Test
    public void readNumberException(){
        Mockito.when(mockScanner.nextDouble()).thenReturn(-1.0).thenThrow(InputMismatchException.class).thenReturn(5.0);
        int res = (int) Console.readNumber("Input Number", 0,mockScanner);
        Assertions.assertEquals(5, res);
    }
    @Test
    public void readNumberMinMaxException(){
        Mockito.when(mockScanner.nextDouble()).thenReturn(-1.0).thenThrow(InputMismatchException.class).thenReturn(5.0);
        int res = (int) Console.readNumber("Input Number", 0,100,mockScanner);
        Assertions.assertEquals(5, res);
    }

    @Test
    public void readNumberWithMixMaxCorrectInputTest(){
        Mockito.when(mockScanner.nextDouble()).thenReturn(10.0);
        int res = (int) Console.readNumber("Input Number", 0,100,mockScanner);
        Assertions.assertEquals(10, res);
    }

    @Test
    public void readNumberWithMixMaxNotCorrectInputTest(){
        Mockito.when(mockScanner.nextDouble()).thenReturn(110.00).thenReturn(50.00);
        int res = (int) Console.readNumber("Input Number", 0,100,mockScanner);
        Assertions.assertEquals(50, res);
    }

    @Test
    public void readStringWithMinMaxCorrectInputTest(){
        Mockito.when(mockScanner.next()).thenReturn("Mike");
        String res = Console.readString("Input String", 1, 150, mockScanner );
        Assertions.assertEquals("Mike", res);

    }

    @Test
    public void readStringBlankTest(){
        Mockito.when(mockScanner.next()).thenReturn("").thenReturn("Mike");
        String res = Console.readString("Input String", 1, 150, mockScanner );
        Assertions.assertEquals("Mike", res);

    }

    @Test
    public void readStringMaxCharTest(){
        Mockito.when(mockScanner.next()).thenReturn("MikeWadden").thenReturn("Mike");
        String res = Console.readString("Input String", 1, 6, mockScanner );
        Assertions.assertEquals("Mike", res);

    }



    @Test
    public void readLineWithMinMaxCorrectInputTest(){
        Mockito.when(mockScanner.nextLine()).thenReturn("Mike Open");
        String res = Console.readLine("Input String", 1, 150, mockScanner );
        Assertions.assertEquals("Mike Open", res);
    }

    @Test
    public void readLineBlankTest(){
        Mockito.when(mockScanner.nextLine()).thenReturn("").thenReturn(" Mike Open");
        String res = Console.readLine("Input String", 1, 150, mockScanner );
        Assertions.assertEquals("Mike Open", res);
    }

    @Test
    public void readLineMaxTest(){
        Mockito.when(mockScanner.nextLine()).thenReturn("The Mike Open Classic").thenReturn(" Mike Open");
        String res = Console.readLine("Input String", 1, 20, mockScanner );
        Assertions.assertEquals("Mike Open", res);
    }

    @Test

    public void readCharWithCapitalCaseInput(){
        Mockito.when(mockScanner.next()).thenReturn("A");
        String res = Console.readChar("Input Letter", "A", "B", mockScanner);
        Assertions.assertEquals("A", res);

        Mockito.when(mockScanner.next()).thenReturn("B");
        String res1 = Console.readChar("Input Letter", "A", "B", mockScanner);
        Assertions.assertEquals("B", res1);
    }

    @Test
    public void readCharWithLowerCaseInput(){
        Mockito.when(mockScanner.next()).thenReturn("a");
        String res = Console.readChar("Input Letter", "A", "B", mockScanner);
        Assertions.assertEquals("A", res);

        Mockito.when(mockScanner.next()).thenReturn("b");
        String res1 = Console.readChar("Input Letter", "A", "B", mockScanner);
        Assertions.assertEquals("B", res1);
    }

    @Test

    public void readCharWrongAnswerTest(){
        Mockito.when(mockScanner.next()).thenReturn("C").thenReturn("A");
        String res = Console.readChar("Input Letter", "A", "B", mockScanner);
        Assertions.assertEquals("A", res);
    }


    @Test

    public void readDateCheckCorrectTest(){
        DateValidator validator = new DateCheck("MM/dd/yyyy");
        Mockito.when(mockScanner.next()).thenReturn("03/23/2022");
        Assertions.assertEquals("03/23/2022",Console.readStringDate("Enter Date", mockScanner, validator));
    }
    @Test
    public void readDateCheckIncorrectTest(){
        DateValidator validator = new DateCheck("MM/dd/yyyy");
        Mockito.when(mockScanner.next()).thenReturn("03/40/2022").thenReturn("03/23/2022");
        Assertions.assertEquals("03/23/2022",Console.readStringDate("Enter Date", mockScanner, validator));
    }






}
