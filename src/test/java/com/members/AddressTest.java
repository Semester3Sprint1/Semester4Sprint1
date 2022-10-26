package com.members;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {

    Address address = new Address("120 Anywhere St.", "Anywhere", "A0K 0U0", "NL","Canada");

    @Test

    public void testGetStreetAddress() {
        String result = address.getStreetAddress();
        String expectedResult = "120 Anywhere St.";
        Assertions.assertEquals(result, expectedResult);
    }

    @Test

    public void testGetCity() {
        String result = address.getCity();
        String expectedResult = "Anywhere";
        Assertions.assertEquals(result, expectedResult);
    }

    @Test

    public void testGetPostalCode() {
        String result = address.getPostalCode();
        String expectedResult = "A0K 0U0";
        Assertions.assertEquals(result, expectedResult);
    }

    @Test

    public void testGetProvince() {
        String result = address.getProvince();
        String expectedResult = "NL";
        Assertions.assertEquals(result, expectedResult);
    }

    @Test

    public void testGetCountry() {
        String result = address.getCountry();
        String expectedResult = "Canada";
        Assertions.assertEquals(result, expectedResult);
    }
}
