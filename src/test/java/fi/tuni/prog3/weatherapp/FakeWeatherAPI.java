/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import com.google.gson.Gson;
import fi.tuni.prog3.weatherapp.data.CurrentWeather;
import fi.tuni.prog3.weatherapp.data.DailyWeather;
import fi.tuni.prog3.weatherapp.data.HourlyWeather;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author ivanperov
 */
public class FakeWeatherAPI implements IWeatherAPI {

    @Override
    public CurrentWeather getCurrentWeather(String location) throws IOException {
        try {
            URL url = getClass().getClassLoader().getResource("currentResponse.json");
            String json = JsonHandler.readFromFile(url.getPath());
            Gson gson = new Gson();
            return gson.fromJson(json, CurrentWeather.class);
        } catch (Exception ex) {
            throw new IOException();
        }
    }

    @Override
    public CurrentWeather getCurrentWeather(double lat, double lon) throws IOException {
        return this.getCurrentWeather("");
    }

    @Override
    public HourlyWeather getHourlyForecast(double lat, double lon) throws IOException {
        try {
            URL url = getClass().getClassLoader().getResource("hourlyResponse.json");
            String json = JsonHandler.readFromFile(url.getPath());
            Gson gson = new Gson();
            return gson.fromJson(json, HourlyWeather.class);
        } catch (Exception ex) {
            throw new IOException();
        }
    }

    @Override
    public DailyWeather getDailyForecast(double lat, double lon) throws IOException {
        try {
            URL url = getClass().getClassLoader().getResource("dailyResponse.json");
            String json = JsonHandler.readFromFile(url.getPath());
            Gson gson = new Gson();
            return gson.fromJson(json, DailyWeather.class);
        } catch (Exception ex) {
            throw new IOException();
        }
    }

}
