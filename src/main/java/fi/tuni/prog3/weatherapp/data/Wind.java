/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp.data;

/**
 * Represents wind-related data with attributes for speed, direction (degrees), and gust speed.
 * 
 * @author ivanperov
 */
public class Wind {
    private double speed;
    private int deg;
    private double gust;

    /**
     * Retrieves the wind speed.
     * 
     * @return the wind speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the wind speed.
     * 
     * @param speed the wind speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Retrieves the wind direction in degrees.
     * 
     * @return the wind direction in degrees
     */
    public int getDeg() {
        return deg;
    }

    /**
     * Sets the wind direction in degrees.
     * 
     * @param deg the wind direction in degrees to set
     */
    public void setDeg(int deg) {
        this.deg = deg;
    }

    /**
     * Retrieves the wind gust speed.
     * 
     * @return the wind gust speed
     */
    public double getGust() {
        return gust;
    }

    /**
     * Sets the wind gust speed.
     * 
     * @param gust the wind gust speed to set
     */
    public void setGust(double gust) {
        this.gust = gust;
    }
}

