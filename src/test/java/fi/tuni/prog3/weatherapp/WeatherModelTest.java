/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherModelTest {

    private WeatherModel model;
    private SettingsManager settingsManager;
    
    public WeatherModelTest() {
        var api = new FakeWeatherAPI();
        
        settingsManager = SettingsManager.getInstance();
        settingsManager.loadSettings();
        model = WeatherModel.getInstance();
        model.setApi(api);
        
    }

    @Test
    public void testUpdateWeatherData() {
        String result = model.updateWeatherData("Helsinki");

        try {
            assertTrue(result.isEmpty(), "Result should be empty on successful update");
            assertNotNull(model.getCurrentWeatherItem(), "Current weather item should not be null");
            assertFalse(model.getHourlyWeatherItems().isEmpty(), "Hourly weather items should not be empty");
            assertFalse(model.getDailyWeatherItems().isEmpty(), "Daily weather items should not be empty");
            
            assertEquals(96, model.getHourlyWeatherItems().size());
            assertEquals(7, model.getDailyWeatherItems().size());
            
            assertEquals(7.97, model.getCurrentWeatherItem().getTemp(), 0.01);
            assertEquals("5,7 °C", model.getCurrentWeatherItem().getFeelsLike());
            assertEquals(27.78, model.getHourlyWeatherItems().get(0).getTemp(), 0.01);
            assertEquals("-5,8 °C", model.getDailyWeatherItems().get(0).getMinTemp());
            assertEquals("-3,4 °C", model.getDailyWeatherItems().get(0).getMaxTemp());

        } catch (Exception ex) {
            fail("Exception should not be thrown: " + ex.getMessage());
        }
    }

    @AfterAll
    public void tearDown() {
        model.setApi(new WeatherAPI(new HttpDataFetcher()));
    }
}
