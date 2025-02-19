/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import com.google.gson.Gson;
import fi.tuni.prog3.weatherapp.data.Coord;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import org.apache.commons.lang3.StringUtils;

/**
 * Utility class providing methods for guessing geographical location names.
 *
 * @author Ivan Perov
 */
public class GeoAutocomplete {

    /**
     * Fetches city suggestions from a remote API based on a given prefix. This
     * method is asynchronous and returns a CompletableFuture.
     *
     * @param prefix The prefix string to search for city names.
     * @return A CompletableFuture that, when completed, returns a JSON string
     * of city suggestions.
     */
    private static CompletableFuture<String> fetchCities(String prefix) {
        return CompletableFuture.supplyAsync(() -> {
            HttpURLConnection conn = null;
            StringBuilder response = new StringBuilder();
            try {
                String urlString = "https://wft-geo-db.p.rapidapi.com/v1/geo/places?limit=5&offset=0&types=CITY&namePrefix=" + prefix + "&sort=-population";
                URL url = new URL(urlString);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("X-RapidAPI-Key", "29284839f8mshc49cc84806c84d3p1b2a27jsnefb4c0a203b5");
                conn.setRequestProperty("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com");

                try (Scanner scanner = new Scanner(conn.getInputStream())) {
                    while (scanner.hasNextLine()) {
                        response.append(scanner.nextLine());
                        response.append("\n");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
            }
            return response.toString();
        });
    }

    /**
     * Fetches city suggestions from a remote API based on a given coordinates.
     * This method is asynchronous and returns a CompletableFuture.
     *
     * @param coord Coordinates to search for city names.
     * @return A CompletableFuture that, when completed, returns a JSON string
     * of city suggestions.
     */
    private static CompletableFuture<String> fetchCityByCoordinates(Coord coord) {
        return CompletableFuture.supplyAsync(() -> {
            HttpURLConnection conn = null;
            StringBuilder response = new StringBuilder();
            try {
                String formattedLat = String.format(Locale.ROOT,"%.4f", coord.getLat());
                String formattedLon = String.format(Locale.ROOT, "%.4f", coord.getLon());
                formattedLon = coord.getLon() >= 0 ? "%2B" + formattedLon : formattedLon;

                String urlString = "https://wft-geo-db.p.rapidapi.com/v1/geo/places?limit=5&offset=0&types=CITY&location=" + formattedLat + formattedLon + "&sort=-population";
                URL url = new URL(urlString);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("X-RapidAPI-Key", "29284839f8mshc49cc84806c84d3p1b2a27jsnefb4c0a203b5");
                conn.setRequestProperty("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com");

                try (Scanner scanner = new Scanner(conn.getInputStream())) {
                    while (scanner.hasNextLine()) {
                        response.append(scanner.nextLine());
                        response.append("\n");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
            }
            return response.toString();
        });
    }

    /**
     * Provides a city name suggestion based on the given prefix. It fetches
     * city suggestions and returns the first city name. If no cities are found,
     * it progressively shortens the prefix and tries again.
     *
     * @param prefix The prefix string to search for city names.
     * @return A CompletableFuture that, when completed, returns the suggested
     * city name.
     */
    public static CompletableFuture<String> getCitySuggestion(String prefix) {
        return CompletableFuture.supplyAsync(() -> {
            String newPrefix = prefix;
            String jsonString;
            try {
                jsonString = fetchCities(newPrefix).join();
                while (jsonString.contains("\"totalCount\":0")) {
                    newPrefix = StringUtils.chop(newPrefix);
                    jsonString = fetchCities(newPrefix).join();
                }
                Gson gson = new Gson();
                Root response = gson.fromJson(jsonString, Root.class);
                return response.data.get(0).name;
            } catch (Exception e) {
                return "Error: " + e.getMessage();
            }
        });
    }

    public static CompletableFuture<String> getCityByCoordinates(Coord coord) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                var jsonString = fetchCityByCoordinates(coord).join();
                Gson gson = new Gson();
                Root response = gson.fromJson(jsonString, Root.class);
                return response.data.get(0).name;
            } catch (Exception e) {
                return "Error: " + e.getMessage();
            }
        });
    }

    static class Datum {

        public int id;
        public String wikiDataId;
        public String type;
        public String city;
        public String name;
        public String country;
        public String countryCode;
        public String region;
        public String regionCode;
        public double latitude;
        public double longitude;
        public int population;
    }

    static class Link {

        public String rel;
        public String href;
    }

    static class Metadata {

        public int currentOffset;
        public int totalCount;
    }

    static class Root {

        public ArrayList<Datum> data;
        public ArrayList<Link> links;
        public Metadata metadata;
    }
}
