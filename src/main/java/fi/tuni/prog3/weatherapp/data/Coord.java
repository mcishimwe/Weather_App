/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp.data;

/**
 * Represents geographical coordinates with longitude and latitude values.
 * Provides methods to set and retrieve these coordinates.
 *
 * @author ivanperov
 */
public class Coord {

    private double lon;
    private double lat;

    /**
     * Retrieves the longitude value of the coordinates.
     *
     * @return the longitude
     */
    public double getLon() {
        return lon;
    }

    /**
     * Sets the longitude value of the coordinates.
     *
     * @param lon the longitude to set
     */
    public void setLon(double lon) {
        this.lon = lon;
    }

    /**
     * Retrieves the latitude value of the coordinates.
     *
     * @return the latitude
     */
    public double getLat() {
        return lat;
    }

    /**
     * Sets the latitude value of the coordinates.
     *
     * @param lat the latitude to set
     */
    public void setLat(double lat) {
        this.lat = lat;
    }
}
