/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp.data;

/**
 * Represents rainfall data, specifically capturing the amount of rain in a
 * given hour.
 *
 * @author ivanperov
 */
public class Rain {

    private double _1h;

    /**
     * Retrieves the amount of rain in the past 1 hour.
     *
     * @return the amount of rain in millimeters
     */
    public double get1h() {
        return _1h;
    }

    /**
     * Sets the amount of rain in the past 1 hour.
     *
     * @param _1h the amount of rain in millimeters to set
     */
    public void set1h(double _1h) {
        this._1h = _1h;
    }
}
