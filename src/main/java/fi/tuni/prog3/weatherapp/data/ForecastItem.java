/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp.data;

import java.util.List;

/**
 * Represents an item in a weather forecast, encapsulating various details such
 * as date and time, main weather conditions, clouds, wind, visibility, and
 * more. Provides methods to access and modify these weather attributes.
 *
 * @author ivanperov
 */
public class ForecastItem {

    private long dt;
    private Main main;
    private List<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private int visibility;
    private double pop;
    private Rain rain;
    private Sys sys;
    private String dt_txt;

    /**
     * Retrieves the temperature from the main weather details.
     *
     * @return the temperature
     */
    public double getTemp() {
        return this.main.getTemp();
    }

    /**
     * Retrieves the wind speed from the wind information.
     *
     * @return the wind speed
     */
    public double getWindSpeed() {
        return this.wind.getSpeed();
    }

    /**
     * Retrieves the probability of precipitation.
     *
     * @return the probability of precipitation
     */
    public double getProbabilityOfRain() {
        return this.pop;
    }

    /**
     * Retrieves the date and time in Unix format.
     *
     * @return the date and time
     */
    public long getDt() {
        return dt;
    }

    /**
     * Sets the date and time in Unix format.
     *
     * @param dt the date and time to set
     */
    public void setDt(long dt) {
        this.dt = dt;
    }

    /**
     * Retrieves the main weather details.
     *
     * @return the main weather details
     */
    public Main getMain() {
        return main;
    }

    /**
     * Sets the main weather details.
     *
     * @param main the main weather details to set
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * Retrieves the list of weather conditions.
     *
     * @return the list of weather conditions
     */
    public List<Weather> getWeather() {
        return weather;
    }

    /**
     * Sets the list of weather conditions.
     *
     * @param weather the list of weather conditions to set
     */
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    /**
     * Retrieves the cloud information.
     *
     * @return the cloud information
     */
    public Clouds getClouds() {
        return clouds;
    }

    /**
     * Sets the cloud information.
     *
     * @param clouds the cloud information to set
     */
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    /**
     * Retrieves the wind information.
     *
     * @return the wind information
     */
    public Wind getWind() {
        return wind;
    }

    /**
     * Sets the wind information.
     *
     * @param wind the wind information to set
     */
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    /**
     * Retrieves the visibility distance.
     *
     * @return the visibility distance
     */
    public int getVisibility() {
        return visibility;
    }

    /**
     * Sets the visibility distance.
     *
     * @param visibility the visibility distance to set
     */
    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    /**
     * Retrieves the probability of precipitation.
     *
     * @return the probability of precipitation
     */
    public double getPop() {
        return pop;
    }

    /**
     * Sets the probability of precipitation.
     *
     * @param pop the probability of precipitation to set
     */
    public void setPop(double pop) {
        this.pop = pop;
    }

    /**
     * Retrieves the rain information.
     *
     * @return the rain information
     */
    public Rain getRain() {
        return rain;
    }

    /**
     * Sets the rain information.
     *
     * @param rain the rain information to set
     */
    public void setRain(Rain rain) {
        this.rain = rain;
    }

    /**
     * Retrieves the system parameters.
     *
     * @return the system parameters
     */
    public Sys getSys() {
        return sys;
    }

    /**
     * Sets the system parameters.
     *
     * @param sys the system parameters to set
     */
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    /**
     * Retrieves the date and time in text format.
     *
     * @return the date and time in text format
     */
    public String getDt_txt() {
        return dt_txt;
    }

    /**
     * Sets the date and time in text format.
     *
     * @param dt_txt the date and time in text format to set
     */
    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
