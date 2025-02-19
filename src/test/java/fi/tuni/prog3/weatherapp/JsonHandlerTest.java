/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ivanperov
 */
public class JsonHandlerTest {

    public JsonHandlerTest() {
    }

    /**
     * Test of readFromFile method, of class JsonHandler.
     */
    @Test
    public void testReadAndWriteFromFile() throws Exception {
        try {
            URL url = getClass().getClassLoader().getResource("hourlyResponse.json");
            URL urlCopy = getClass().getClassLoader().getResource("hourlyResponseCopy.json");
            String jsonFromFileOriginal = JsonHandler.readFromFile(url.getPath());
            JsonHandler.writeToFile(urlCopy.getPath(), jsonFromFileOriginal);
            String jsonFromFileCopy = JsonHandler.readFromFile(urlCopy.getPath());

            assertEquals(jsonFromFileOriginal, jsonFromFileCopy);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }
}
