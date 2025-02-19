/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp.data;

/**
 * Represents the main meteorological data including temperature, pressure,
 * humidity, and other related attributes.
 *
 * @author ivanperov
 */
public class Main {

    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;
    private int sea_level;
    private int grnd_level;

    /**
     * Retrieves the current temperature.
     *
     * @return the current temperature
     */
    public double getTemp() {
        return temp;
    }

    /**
     * Sets the current temperature.
     *
     * @param temp the current temperature to set
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }

    /**
     * Retrieves the feels-like temperature.
     *
     * @return the feels-like temperature
     */
    public double getFeels_like() {
        return feels_like;
    }

    /**
     * Sets the feels-like temperature.
     *
     * @param feels_like the feels-like temperature to set
     */
    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    /**
     * Retrieves the minimum recorded temperature.
     *
     * @return the minimum recorded temperature
     */
    public double getTemp_min() {
        return temp_min;
    }

    /**
     * Sets the minimum recorded temperature.
     *
     * @param temp_min the minimum recorded temperature to set
     */
    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    /**
     * Retrieves the maximum recorded temperature.
     *
     * @return the maximum recorded temperature
     */
    public double getTemp_max() {
        return temp_max;
    }

    /**
     * Sets the maximum recorded temperature.
     *
     * @param temp_max the maximum recorded temperature to set
     */
    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    /**
     * Retrieves the atmospheric pressure.
     *
     * @return the atmospheric pressure
     */
    public int getPressure() {
        return pressure;
    }

    /**
     * Sets the atmospheric pressure.
     *
     * @param pressure the atmospheric pressure to set
     */
    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    /**
     * Retrieves the humidity percentage.
     *
     * @return the humidity percentage
     */
    public int getHumidity() {
        return humidity;
    }

    /**
     * Sets the humidity percentage.
     *
     * @param humidity the humidity percentage to set
     */
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    /**
     * Retrieves the sea-level pressure.
     *
     * @return the sea-level pressure
     */
    public int getSea_level() {
        return sea_level;
    }

    /**
     * Sets the sea-level pressure.
     *
     * @param sea_level the sea-level pressure to set
     */
    public void setSea_level(int sea_level) {
        this.sea_level = sea_level;
    }

    /**
     * Retrieves the ground-level pressure.
     *
     * @return the ground-level pressure
     */
    public int getGrnd_level() {
        return grnd_level;
    }

    /**
     * Sets the ground-level pressure.
     *
     * @param grnd_level the ground-level pressure to set
     */
    public void setGrnd_level(int grnd_level) {
        this.grnd_level = grnd_level;
    }
}
