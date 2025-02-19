/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fi.tuni.prog3.weatherapp.data.Coord;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * This class provides functionality for accessing geographical data via the OpenWeatherMap Geo API.
 * It uses an HTTP data fetcher to make requests to the API and retrieve location data.
 */
public class GeoAPI {
    private static final String API_KEY = "ec9607257c4c34431eb093cae9cb9588";
    private static final String BASE_URL = "http://api.openweathermap.org/geo/1.0/direct";
    private static final String REVERSE_URL = "http://api.openweathermap.org/geo/1.0/reverse";

    private IHttpDataFetcher dataFetcher;

    /**
     * Constructs a new GeoAPI instance with the specified HTTP data fetcher.
     * 
     * @param dataFetcher the HTTP data fetcher to be used for making API requests
     */
    public GeoAPI(IHttpDataFetcher dataFetcher) {
        this.dataFetcher = dataFetcher;
    }

    /**
     * Retrieves the geographic coordinates (latitude and longitude) for a given location.
     * The location is specified by a string, which is used to query the OpenWeatherMap Geo API.
     * 
     * @param location the name of the location for which coordinates are to be retrieved
     * @return the coordinates of the specified location
     * @throws IOException if there is an issue fetching data from the API
     */
    public Coord getCoordinates(String location) throws Exception {
        String urlString = BASE_URL + "?q=" + location + "&appid=" + API_KEY;
        String response = dataFetcher.fetchData(urlString);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Coord>>(){}.getType();
        List<Coord> locations = gson.fromJson(response, listType);
        return locations.get(0);
    }
    
    /**
     * Retrieves the area name for a given coordinates.
     * The coordinates are specified by a class with parameters (double) lat and lon,
     * which are used to query the OpenWeatherMap Geo API.
     * 
     * @param coord the coordinates of the location for which name is to be retrieved
     * @return the name of the specified location
     * @throws IOException if there is an issue fetching data from the API
     */
    public String getCity(Coord coord) throws Exception {
        String urlString = REVERSE_URL + "?lat=" + coord.getLat() + "&lon=" + coord.getLon() + "&limit=1" + "&appid=" + API_KEY;
        String response = dataFetcher.fetchData(urlString);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<City>>(){}.getType();
        List<City> locations = gson.fromJson(response, listType);
        return locations.get(0).name;
    }
    
    class City {
        public String name;
    }
}

