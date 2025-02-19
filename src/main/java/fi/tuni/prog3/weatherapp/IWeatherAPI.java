/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import fi.tuni.prog3.weatherapp.data.CurrentWeather;
import fi.tuni.prog3.weatherapp.data.DailyWeather;
import fi.tuni.prog3.weatherapp.data.HourlyWeather;
import java.io.IOException;

/**
 * Interface for extracting data from the OpenWeatherMap API.
 */
public interface IWeatherAPI {
    
    /**
     * Returns the current weather for the given coordinates.
     * @param location.
     * @return String.
     * @throws java.io.IOException
     */
    public CurrentWeather getCurrentWeather(String location) throws IOException;
    
    /**
     * Returns the current weather for the given coordinates.
     * @param lat The latitude of the location.
     * @param lon The longitude of the location.
     * @return String.
     * @throws java.io.IOException
     */
    public CurrentWeather getCurrentWeather(double lat, double lon) throws IOException;

    /**
     * Returns an hourly forecast for the given coordinates.
     * @param lat The latitude of the location.
     * @param lon The longitude of the location.
     * @return HourlyWeather.
     * @throws java.io.IOException
     */
    public HourlyWeather getHourlyForecast(double lat, double lon) throws IOException;
    
    /**
     * Returns a daily forecast for the given coordinates.
     * @param lat The latitude of the location.
     * @param lon The longitude of the location.
     * @return DailyWeather.
     * @throws java.io.IOException
     */
    public DailyWeather getDailyForecast(double lat, double lon) throws IOException;
}
