package com.general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
public class DateValidatorTest {
    @Test
    public void dateValidatorIsValidTest(){
      DateValidator validator = new DateCheck("MM/dd/yyyy");

        assertTrue(validator.isValid("01/20/2022"));
        assertFalse(validator.isValid("01/40/2022"));

    }

    @Test
    public void dateValidatorCompareTest(){
        Date date =  new Date("03/23/2022");
        Date date1 = new Date("03/23/2022");
        Date date2 = new Date("12/01/2022");
        // returns 1 if the date is before the current date
        DateValidator validator = new DateCheck(date, new Date());
        Assertions.assertEquals(1, validator.dateCheck() );
        // returns 0 if the dates are the same
        DateValidator validator2 = new DateCheck(date1, date);
        Assertions.assertEquals(0, validator2.dateCheck() );
        DateValidator validator3 = new DateCheck(date2, new Date());
        Assertions.assertEquals(-1, validator3.dateCheck() );
    }
}
