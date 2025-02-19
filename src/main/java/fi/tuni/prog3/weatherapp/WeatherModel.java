/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import fi.tuni.prog3.weatherapp.data.Coord;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Singleton class representing the weather data model. It encapsulates the
 * logic for fetching and updating weather data.
 */
public class WeatherModel {

    private static WeatherModel instance;

    private String location;
    private String country;
    private IWeatherAPI api;
    private WeatherItem currentWeatherItem;
    private List<WeatherItem> hourlyWeatherItems;
    private List<WeatherItem> dailyWeatherItems;
    private Hashtable<String, WeatherItem> favs;
    private Coord coordinates;

    // Private constructor to enforce singleton pattern
    private WeatherModel() {
        api = new WeatherAPI(new HttpDataFetcher());
        currentWeatherItem = new WeatherItem();
        hourlyWeatherItems = new ArrayList<>();
        dailyWeatherItems = new ArrayList<>();
        favs = new Hashtable<>();
    }

    /**
     * Gets the singleton instance of the WeatherModel.
     *
     * @return the singleton instance of WeatherModel
     */
    public static WeatherModel getInstance() {
        if (instance == null) {
            instance = new WeatherModel();
        }
        return instance;
    }

    /**
     * Updates the weather data for a specified location.Fetches the current,
     * hourly, and daily weather data from the API.
     *
     * @param location the name of the location to fetch weather data for
     * @return result string
     */
    public String updateWeatherData(String location) {
        Coord coord;
        try {
            coord = new GeoAPI(new HttpDataFetcher()).getCoordinates(location);
            this.coordinates = coord;
        } catch (Exception ex) {
            return "Error finding location";
        }

        try {
            setCurrentWeather(coord);
            setHourlyWeather(coord);
            setDailyWeather(coord);
            setFavs();
            return "";

        } catch (Exception e) {
            return "Error fetching weather";
        }
    }

    /**
     * Sets the current weather data. Fetches and processes the current weather
     * data based on the provided coordinates.
     *
     * @param coord the coordinates of the location
     */
    private void setCurrentWeather(Coord coord) {
        try {
            currentWeatherItem = getWeatherItem(coord);
            country = currentWeatherItem.getCountry();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Fetches and returns the weather data based on the provided coordinates.
     *
     * @param coord the coordinates of the location
     * @return weatherItem
     */
    private WeatherItem getWeatherItem(Coord coord) {
        try {
            var currentWeather = api.getCurrentWeather(coord.getLat(), coord.getLon());
            var weatherItem = new WeatherItem();
            weatherItem.setCountry(currentWeather.getSys().getCountry());
            weatherItem.setTemp(currentWeather.getCurrentTemperature() - 273.15);
            weatherItem.setFeelsLike(String.format("%.1f °C", currentWeather.getCurrentTemperatureFeels() - 273.15));
            weatherItem.setDescr(currentWeather.getCurrentTemperatureString());

            weatherItem.setHumidity(String.format("%.1f", currentWeather.getHumidity()));

            var date = DateConverter.fromUnix(currentWeather.getDt());
            weatherItem.setDateTime(date);
            weatherItem.setIcon(currentWeather.getIcon());
            weatherItem.setWindSpeed(String.format("%.1f m/s", currentWeather.getWindSpeed()));

            return weatherItem;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Sets the hourly weather data. Fetches and processes the hourly weather
     * forecast based on the provided coordinates.
     *
     * @param coord the coordinates of the location
     */
    private void setHourlyWeather(Coord coord) {
        try {
            var hourlyForecast = api.getHourlyForecast(coord.getLat(), coord.getLon());
            hourlyWeatherItems.clear();
            this.location = GeoAutocomplete.getCityByCoordinates(coord).get();
            this.country = hourlyForecast.getCity().getCountry();
            for (var item : hourlyForecast.getList()) {
                var weatherItem = new WeatherItem();
                weatherItem.setTemp(item.getTemp() - 273.15);
                weatherItem.setWindSpeed(String.format("%.1f", item.getWindSpeed()));
                weatherItem.setProbabilityOfRain(String.format("%.1f", item.getProbabilityOfRain()));
                var date = DateConverter.fromUnix(item.getDt());
                weatherItem.setDateTime(date);
                hourlyWeatherItems.add(weatherItem);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Sets the daily weather data. Fetches and processes the daily weather
     * forecast based on the provided coordinates.
     *
     * @param coord the coordinates of the location
     */
    private void setDailyWeather(Coord coord) {
        try {
            var dailyForecast = api.getDailyForecast(coord.getLat(), coord.getLon());
            dailyWeatherItems.clear();
            for (var item : dailyForecast.getList()) {
                var weatherItem = new WeatherItem();
                weatherItem.setMaxTemp(String.format("%.1f °C", item.getMaxTemp() - 273.15));
                weatherItem.setMinTemp(String.format("%.1f °C", item.getMinTemp() - 273.15));
                weatherItem.setIcon(item.getIcon());
                var date = DateConverter.fromUnix(item.getDt());
                weatherItem.setDateTime(date);
                dailyWeatherItems.add(weatherItem);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Fills favorite weather items.
     */
    public void setFavs() {
        try {
            favs.clear();
            for (var entry : SettingsManager.getInstance().getSettings().getFavoriteLocations().entrySet()) {
                favs.put(entry.getKey(),getWeatherItem(entry.getValue()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Gets the favorite location weather.
     *
     * @return list of weather items
     */
    public Hashtable<String, WeatherItem> getFavs() {
        return this.favs;
    }

    /**
     * Gets the current location for which weather data is being fetched.
     *
     * @return the current location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the current country for which weather data is being fetched.
     *
     * @return the current country.
     */
    public String getCountry() {
        return country;
    }
    
    /**
     * Gets the current coordinates for which weather data is being fetched.
     *
     * @return the current coordinates.
     */
    public Coord getCoord() {
        return coordinates;
    }

    /**
     * Sets the location for which to fetch weather data.
     *
     * @param location the location to set.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the current weather item containing weather data.
     *
     * @return the current weather item.
     */
    public WeatherItem getCurrentWeatherItem() {
        return currentWeatherItem;
    }

    /**
     * Gets the list of hourly weather items.
     *
     * @return the list of hourly weather items.
     */
    public List<WeatherItem> getHourlyWeatherItems() {
        return hourlyWeatherItems;
    }

    /**
     * Gets the list of daily weather items.
     *
     * @return the list of daily weather items.
     */
    public List<WeatherItem> getDailyWeatherItems() {
        return dailyWeatherItems;
    }

    /**
     * Sets the list of daily weather items.
     *
     * @param dailyWeatherItems the list of daily weather items to set.
     */
    public void setDailyWeatherItems(List<WeatherItem> dailyWeatherItems) {
        this.dailyWeatherItems = dailyWeatherItems;
    }

    /**
     * Sets the weather API instance to be used for fetching weather data.
     *
     * @param api the weather API instance to set.
     */
    public void setApi(IWeatherAPI api) {
        this.api = api;
    }

}
