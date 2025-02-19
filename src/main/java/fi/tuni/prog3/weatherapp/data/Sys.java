/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp.data;

/**
 * Represents system-related data for a weather report, including information
 * such as type, ID, country, sunrise, and sunset times.
 *
 * @author ivanperov
 */
public class Sys {

    private int type;
    private int id;
    private String country;
    private long sunrise;
    private long sunset;

    /**
     * Retrieves the system parameter type.
     *
     * @return the system parameter type
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the system parameter type.
     *
     * @param type the system parameter type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Retrieves the system ID.
     *
     * @return the system ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the system ID.
     *
     * @param id the system ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the country code.
     *
     * @return the country code
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country code.
     *
     * @param country the country code to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Retrieves the sunrise time in Unix time.
     *
     * @return the sunrise time
     */
    public long getSunrise() {
        return sunrise;
    }

    /**
     * Sets the sunrise time in Unix time.
     *
     * @param sunrise the sunrise time to set
     */
    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    /**
     * Retrieves the sunset time in Unix time.
     *
     * @return the sunset time
     */
    public long getSunset() {
        return sunset;
    }

    /**
     * Sets the sunset time in Unix time.
     *
     * @param sunset the sunset time to set
     */
    public void setSunset(long sunset) {
        this.sunset = sunset;
    }
}
