/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp.data;

/**
 * Represents temperature details for different times of the day.
 *
 * @author ivanperov
 */
public class TempDetails {

    private double day;
    private double min;
    private double max;
    private double night;
    private double eve;
    private double morn;

    /**
     * Retrieves the daytime temperature.
     *
     * @return the daytime temperature
     */
    public double getDay() {
        return day;
    }

    /**
     * Sets the daytime temperature.
     *
     * @param day the daytime temperature to set
     */
    public void setDay(double day) {
        this.day = day;
    }

    /**
     * Retrieves the minimum temperature.
     *
     * @return the minimum temperature
     */
    public double getMin() {
        return min;
    }

    /**
     * Sets the minimum temperature.
     *
     * @param min the minimum temperature to set
     */
    public void setMin(double min) {
        this.min = min;
    }

    /**
     * Retrieves the maximum temperature.
     *
     * @return the maximum temperature
     */
    public double getMax() {
        return max;
    }

    /**
     * Sets the maximum temperature.
     *
     * @param max the maximum temperature to set
     */
    public void setMax(double max) {
        this.max = max;
    }

    /**
     * Retrieves the night temperature.
     *
     * @return the night temperature
     */
    public double getNight() {
        return night;
    }

    /**
     * Sets the night temperature.
     *
     * @param night the night temperature to set
     */
    public void setNight(double night) {
        this.night = night;
    }

    /**
     * Retrieves the evening temperature.
     *
     * @return the evening temperature
     */
    public double getEve() {
        return eve;
    }

    /**
     * Sets the evening temperature.
     *
     * @param eve the evening temperature to set
     */
    public void setEve(double eve) {
        this.eve = eve;
    }

    /**
     * Retrieves the morning temperature.
     *
     * @return the morning temperature
     */
    public double getMorn() {
        return morn;
    }

    /**
     * Sets the morning temperature.
     *
     * @param morn the morning temperature to set
     */
    public void setMorn(double morn) {
        this.morn = morn;
    }
}
