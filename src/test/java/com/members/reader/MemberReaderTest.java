package com.members.reader;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class MemberReaderTest {

    MemberReader memberReader = new MemberReader();

    @Test

    public void testReadFromExcel() {
            String file = "src/main/java/com/members/reader/memberList.xlsx";
        try {
            String result = MemberReader.readFromExcel(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
        String expectedResult = "Member ID: 1\n" +
                "Name: Alex Ridgeley\n" +
                "Street Address: 51A Amherst Heights\n" +
                "Email: aridgeley@msn.com\n" +
                "Start Date: 10/10/1991\n" +
                "Membership Type: Normal\n" +
                "\n" +
                "Member ID: 2\n" +
                "Name: Mike Wadden\n" +
                "Street Address: 22 Town ave\n" +
                "Email: mike@email.com\n" +
                "Start Date: 10/10/1992\n" +
                "Membership Type: Other\n" +
                "\n" +
                "Member ID: 3\n" +
                "Name: Cody Barrett\n" +
                "Street Address: 23 Town ave\n" +
                "Email: cody@email.com\n" +
                "Start Date: 10/10/1993\n" +
                "Membership Type: Trial\n" +
                "\n" +
                "Member ID: 4\n" +
                "Name: John Smith\n" +
                "Street Address: 24 Town ave\n" +
                "Email: john@email.com\n" +
                "Start Date: 10/10/1994\n" +
                "Membership Type: Special Offer\n";
    }
}
