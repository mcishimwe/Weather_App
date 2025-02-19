/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import fi.tuni.prog3.weatherapp.data.Coord;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ivanperov
 */
public class GeoAPITest {

    public GeoAPITest() {
    }

    /**
     * Test of getCoordinates method, of class GeoAPI.
     */
    @Test
    public void testGetCoordinates() {
        try {
            String location = "New York";
            GeoAPI instance = new GeoAPI(new HttpDataFetcher());
            Coord expResult = new Coord();
            expResult.setLat(40.7128);
            expResult.setLon(-74.006);
            Coord result = instance.getCoordinates(location);
            assertEquals(expResult.getLat(), result.getLat(), 0.01);
            assertEquals(expResult.getLon(), result.getLon(), 0.01);

        } catch (Exception ex) {
            fail("Exception should not be thrown: " + ex.getMessage());
        }
    }
    
    /**
     * Test of getCity method, of class GeoAPI.
     */
    @Test
    public void testGetCity() {
        try {
            String location = "City of Westminster";
            GeoAPI instance = new GeoAPI(new HttpDataFetcher());
            Coord coord = new Coord();
            coord.setLat(51.5098);
            coord.setLon(-0.1180);
            var result = instance.getCity(coord);
            assertEquals(location, result);

        } catch (Exception ex) {
            fail("Exception should not be thrown: " + ex.getMessage());
        }
    }
    
    
}
