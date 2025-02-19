/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp.data;

import java.util.List;

/**
 * Represents hourly weather data, including the response code, message, count
 * of data points, a list of forecast items, and city information.
 *
 * @author ivanperov
 */
public class HourlyWeather {

    private String cod;
    private int message;
    private int cnt;  
    private List<ForecastItem> list; 
    private City city;

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
    public int getMessage() {
        return message;
    }

    /**
     * Sets the system message.
     *
     * @param message the system message to set
     */
    public void setMessage(int message) {
        this.message = message;
    }

    /**
     * Retrieves the count of data points returned.
     *
     * @return the count of data points
     */
    public int getCnt() {
        return cnt;
    }

    /**
     * Sets the count of data points returned.
     *
     * @param cnt the count of data points to set
     */
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    /**
     * Retrieves the list of forecast data items.
     *
     * @return the list of forecast items
     */
    public List<ForecastItem> getList() {
        return list;
    }

    /**
     * Sets the list of forecast data items.
     *
     * @param list the list of forecast items to set
     */
    public void setList(List<ForecastItem> list) {
        this.list = list;
    }

    /**
     * Retrieves the information about the city.
     *
     * @return the city information
     */
    public City getCity() {
        return city;
    }

    /**
     * Sets the information about the city.
     *
     * @param city the city information to set
     */
    public void setCity(City city) {
        this.city = city;
    }
}
