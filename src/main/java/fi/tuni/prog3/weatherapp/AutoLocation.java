/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import com.google.gson.Gson;
import java.io.IOException;

/**
 * A utility class for automatically determining the user's city based on their IP address.
 * This class utilizes an external API to fetch the location data.
 * 
 * @author Ivan Perov
 */
public class AutoLocation {

    private static final String URL = "http://ip-api.com/json/?fields=city";

    /**
     * Retrieves the city location of the user based on their IP address.
     * 
     * @return The name of the city if successfully retrieved, or an empty string if an error occurs.
     */
    public static String getLocation() {
        try {
            var json = new HttpDataFetcher().fetchData(URL);
            Gson gson = new Gson();
            LocationResponse response = gson.fromJson(json, LocationResponse.class);

            return response.getCity();

        } catch (IOException ex) {
            return "";
        }
    }

    /**
     * Inner class to encapsulate the location response from the external API.
     */
    class LocationResponse {

        private String city;

        /**
         * Gets the city name from the location response.
         * 
         * @return The city name.
         */
        public String getCity() {
            return city;
        }

        /**
         * Sets the city name in the location response.
         * 
         * @param city The city name to set.
         */
        public void setCity(String city) {
            this.city = city;
        }
    }
}
