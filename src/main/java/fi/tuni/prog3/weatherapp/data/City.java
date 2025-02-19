/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp.data;

/**
 * Represents a city with attributes like ID, name, geographical coordinates,
 * country, population, timezone, and sunrise and sunset times.
 *
 * @author ivanperov
 */
public class City {

    private int id;
    private String name;
    private Coord coord;
    private String country;
    private int population;
    private int timezone;
    private long sunrise;
    private long sunset;

    /**
     * Retrieves the unique identifier for the city.
     *
     * @return the city ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the city.
     *
     * @param id the city ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the city.
     *
     * @return the city name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the city.
     *
     * @param name the city name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the geographical coordinates of the city.
     *
     * @return the geographical coordinates
     */
    public Coord getCoord() {
        return coord;
    }

    /**
     * Sets the geographical coordinates of the city.
     *
     * @param coord the geographical coordinates to set
     */
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    /**
     * Retrieves the country code of the city.
     *
     * @return the country code
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country code of the city.
     *
     * @param country the country code to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Retrieves the population of the city.
     *
     * @return the population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Sets the population of the city.
     *
     * @param population the population to set
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Retrieves the timezone offset from UTC for the city.
     *
     * @return the timezone offset
     */
    public int getTimezone() {
        return timezone;
    }

    /**
     * Sets the timezone offset from UTC for the city.
     *
     * @param timezone the timezone offset to set
     */
    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    /**
     * Retrieves the sunrise time in Unix format.
     *
     * @return the sunrise time
     */
    public long getSunrise() {
        return sunrise;
    }

    /**
     * Sets the sunrise time in Unix format.
     *
     * @param sunrise the sunrise time to set
     */
    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    /**
     * Retrieves the sunset time in Unix format.
     *
     * @return the sunset time
     */
    public long getSunset() {
        return sunset;
    }

    /**
     * Sets the sunset time in Unix format.
     *
     * @param sunset the sunset time to set
     */
    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

}
