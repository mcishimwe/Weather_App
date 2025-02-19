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
public class WeatherItemTest {
    
    public WeatherItemTest() {
    }
    
    @Test
    public void testWeatherItemSettersAndGetters() {
        WeatherItem weatherItem = new WeatherItem();

        weatherItem.setTemp(20.0); //dreams when you are in Finland at winter
        weatherItem.setFeelsLike("18.0");
        weatherItem.setDescr("Clear sky");
        weatherItem.setMinTemp("15.0");
        weatherItem.setMaxTemp("25.0");
        weatherItem.setDateTime("2023-04-01 12:00:00");
        weatherItem.setIcon("01d");
        weatherItem.setProbabilityOfRain("10");
        weatherItem.setWindSpeed("5");

        assertEquals(20.0, weatherItem.getTemp());
        assertEquals("18.0", weatherItem.getFeelsLike());
        assertEquals("Clear sky", weatherItem.getDescr());
        assertEquals("15.0", weatherItem.getMinTemp());
        assertEquals("25.0", weatherItem.getMaxTemp());
        assertEquals("2023-04-01 12:00:00", weatherItem.getDateTime());
        assertEquals("01d", weatherItem.getIcon());
        assertEquals("10", weatherItem.getProbabilityOfRain());
        assertEquals("5", weatherItem.getWindSpeed());
    }
    
    
}
