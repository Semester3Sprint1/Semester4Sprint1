package com.members;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {
    Address address = new Address("120 Anywhere St.", "Anywhere", "A0K 0U0", "NL","Canada");
    Person person = new Person("Cody", "Barrett", address, "codybarrett@email.com");

    @Test

    public void getNameTest() {
        String result = person.getName();
        String expectedResult = "Cody Barrett";
        Assertions.assertEquals(result, expectedResult);
    }

}
