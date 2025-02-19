/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ivanperov
 */
public class DateConverterTest {

    public DateConverterTest() {
    }

    @Test
    public void testFromUnix() {
        long timestamp = 1610236800L;
        String expResult = "Jan 10, 00:00";
        String result = DateConverter.fromUnix(timestamp);
        assertEquals(expResult, result, "The converted date should match the expected format.");
    }

    @Test
    public void testFromUnixExtremelyLargeTimestamp() {
        long timestamp = Long.MAX_VALUE;
        String expResult = "Error: Invalid timestamp: " + Long.MAX_VALUE + ".";
        String result = DateConverter.fromUnix(timestamp);
        assertEquals(expResult, result, "Extremely large timestamp should return an error message.");
    }
    
    @Test
    public void testGetHourValidDate() {
        String date = "Mar 15, 14:00";
        int expResult = 14;
        int result = DateConverter.getHour(date);
        assertEquals(expResult, result,"Hour should match for valid date string.");
    }

    @Test
    public void testGetHourInvalidDate() {
        String date = "Invalid date";
        int expResult = -1;
        int result = DateConverter.getHour(date);
        assertEquals(expResult, result, "Should return -1 for invalid date format.");
    }

    @Test
    public void testGetHourEmptyString() {
        String date = "";
        int expResult = -1;
        int result = DateConverter.getHour(date);
        assertEquals(expResult, result, "Should return -1 for empty string.");
    }

    @Test
    public void testGetHourNullString() {
        String date = null;
        int expResult = -1;
        int result = DateConverter.getHour(date);
        assertEquals(expResult, result, "Should return -1 for null string.");
    }

}
