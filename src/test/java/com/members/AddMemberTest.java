package com.members;


import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;



public class AddMemberTest {

    @Test

    public void addTestMember() {

        Member testMember = AddMember.createDefaultMember();

        Assertions.assertTrue(testMember.toString().contains("Alex"));
        Assertions.assertFalse(testMember.toString().contains("Cody"));
    }

    @Test

    public void testGetAddress() {
        Address testAddress = AddMember.getDefaultAddress();

        Assertions.assertTrue(testAddress.toString().contains("NL"));
        Assertions.assertFalse(testAddress.toString().contains("AB"));
    }
}