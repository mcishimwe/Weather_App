/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp.data;

import java.util.List;

/**
 * Represents daily weather data, including city details, response code,
 * message, count of forecast items, and a list of daily forecast items.
 * Provides methods to access and modify these attributes.
 *
 * @author ivanperov
 */
public class DailyWeather {

    private CityDetails city;
    private String cod;
    private double message;
    private int cnt;
    private List<DailyForecastItem> list;

    /**
     * Retrieves the city details.
     *
     * @return the city details
     */
    public CityDetails getCity() {
        return city;
    }

    /**
     * Sets the city details.
     *
     * @param city the city details to set
     */
    public void setCity(CityDetails city) {
        this.city = city;
    }

    /**
     * Retrieves the response code from the weather API.
     *
     * @return the response code
     */
    public String getCod() {
        return cod;
    }

    /**
     * Sets the response code from the weather API.
     *
     * @param cod the response code to set
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * Retrieves the system message.
     *
     * @return the system message
     */
    public double getMessage() {
        return message;
    }

    /**
     * Sets the system message.
     *
     * @param message the system message to set
     */
    public void setMessage(double message) {
        this.message = message;
    }

    /**
     * Retrieves the count of forecast items returned.
     *
     * @return the count of forecast items
     */
    public int getCnt() {
        return cnt;
    }

    /**
     * Sets the count of forecast items returned.
     *
     * @param cnt the count of forecast items to set
     */
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    /**
     * Retrieves the list of daily forecast data items.
     *
     * @return the list of daily forecast items
     */
    public List<DailyForecastItem> getList() {
        return list;
    }

    /**
     * Sets the list of daily forecast data items.
     *
     * @param list the list of daily forecast items to set
     */
    public void setList(List<DailyForecastItem> list) {
        this.list = list;
    }
}
