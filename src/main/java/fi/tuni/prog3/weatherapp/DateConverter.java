/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for converting dates. Contains methods for handling and
 * formatting date-related data. This class provides a static method for
 * converting Unix timestamp to a human-readable date format.
 */
public class DateConverter {

    /**
     * Converts a Unix timestamp to a human-readable date format. The conversion
     * takes into account the system's default time zone. In case of any error
     * during conversion (like invalid timestamp), an appropriate error message
     * is returned.
     *
     * @param timestamp the Unix timestamp to be converted.
     * @return a formatted date string in the format "MMM d, HH:mm", or an error
     * message if conversion fails.
     */
    public static String fromUnix(long timestamp) {
        try {
            Instant instant = Instant.ofEpochSecond(timestamp);
            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, HH:mm");
            return dateTime.format(formatter);
        } catch (DateTimeException e) {
            return "Error: Invalid timestamp: " + timestamp + ".";
        } catch (Exception e) {
            return "Error converting timestamp.";
        }
    }

    /**
     * Gets the hour-of-day field.
     *
     * @param date as a string (MMM d, HH:mm)
     * @return the hour-of-day, from 0 to 23 or -1 if error occur
     */
    public static int getHour(String date) {
        try {
            String year = String.valueOf(Year.now().getValue());
            String fullDate = year + " " + date;

            DateTimeFormatter fullFormatter = DateTimeFormatter.ofPattern("yyyy MMM d, HH:mm")
                    .withZone(ZoneId.systemDefault());

            LocalDateTime dateTime = LocalDateTime.parse(fullDate, fullFormatter);
            return dateTime.getHour();
        } catch (Exception e) {
            return -1;
        }
    }
}
