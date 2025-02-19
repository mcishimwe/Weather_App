/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp.data;

import java.util.List;

/**
 * Represents the current weather conditions. This class includes information
 * about geographical coordinates, weather conditions, main weather data, wind
 * speed, rain volume, cloudiness, and other relevant data like timezone and
 * location name.
 *
 * @author ivanperov
 */
public class CurrentWeather {

    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;
    
    
    /**
     * Retrieves the main weather condition as a string.
     *
     * @return the main weather condition
     */
    public String getCurrentTemperatureString() {
        return this.weather.get(0).getMain();
    }

    /**
     * Retrieves the icon identifier for the weather condition.
     *
     * @return the icon identifier
     */
    public String getIcon() {
        return this.weather.get(0).getIcon();
    }
    
    /**
     * Retrieves the humidity.
     *
     * @return humidity
     */
    public double getHumidity() {
        return this.main.getHumidity();
    }

    /**
     * Retrieves the wind speed.
     *
     * @return the wind speed
     */
    public double getWindSpeed() {
        return this.wind.getSpeed();
    }
    
    
    
    
    /**
     * Retrieves the rain volume for the last hour.
     *
     * @return the rain volume in millimeters
     */
    public double getRainmm() {
        return this.rain.get1h();
    }

    /**
     * Retrieves the current temperature.
     *
     * @return the current temperature
     */
    public double getCurrentTemperature() {
        return this.main.getTemp();
    }

    /**
     * Retrieves the current feels-like temperature.
     *
     * @return the feels-like temperature
     */
    public double getCurrentTemperatureFeels() {
        return this.main.getFeels_like();
    }

    /**
     * Retrieves the geographical coordinates.
     *
     * @return the geographical coordinates
     */
    public Coord getCoord() {
        return coord;
    }

    /**
     * Sets the geographical coordinates.
     *
     * @param coord the geographical coordinates to set
     */
    public void setCoord(Coord coord) {
        this.coord = coord;
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
     * Retrieves the base parameter (internal parameter from API).
     *
     * @return the base parameter
     */
    public String getBase() {
        return base;
    }

    /**
     * Sets the base parameter (internal parameter from API).
     *
     * @param base the base parameter to set
     */
    public void setBase(String base) {
        this.base = base;
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
     * Retrieves the data calculation time in Unix format.
     *
     * @return the data calculation time
     */
    public long getDt() {
        return dt;
    }

    /**
     * Sets the data calculation time in Unix format.
     *
     * @param dt the data calculation time to set
     */
    public void setDt(long dt) {
        this.dt = dt;
    }

    /**
     * Retrieves the system data.
     *
     * @return the system data
     */
    public Sys getSys() {
        return sys;
    }

    /**
     * Sets the system data.
     *
     * @param sys the system data to set
     */
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    /**
     * Retrieves the timezone offset from UTC.
     *
     * @return the timezone offset
     */
    public int getTimezone() {
        return timezone;
    }

    /**
     * Sets the timezone offset from UTC.
     *
     * @param timezone the timezone offset to set
     */
    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    /**
     * Retrieves the city ID.
     *
     * @return the city ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the city ID.
     *
     * @param id the city ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the city name.
     *
     * @return the city name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the city name.
     *
     * @param name the city name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the response code.
     *
     * @return the response code
     */
    public int getCod() {
        return cod;
    }

    /**
     * Sets the response code.
     *
     * @param cod the response code to set
     */
    public void setCod(int cod) {
        this.cod = cod;
    }

}
