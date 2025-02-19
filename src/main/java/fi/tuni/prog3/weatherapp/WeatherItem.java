/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

/**
 * Represents a weather item, encapsulating various weather-related attributes.
 */
public class WeatherItem {

    private double temp;
    private String feelsLike;
    private String descr;
    private String minTemp;
    private String maxTemp;
    private String dateTime;
    private String icon;
    private String probabilityOfRain;
    private String windSpeed;
    private String humidity;
    private String country;

    /**
     * Constructs an empty WeatherItem.
     */
    public WeatherItem() {
    }

    /**
     * Retrieves the current temperature.
     *
     * @return the current temperature
     */
    public double getTemp() {
        return temp;
    }
    
    public String getCountry(){
        return country;
    }
    
    public void setCountry(String country){
        this.country = country;
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
    public String getFeelsLike() {
        return feelsLike;
    }

    /**
     * Sets the feels-like temperature.
     *
     * @param feelsLike the feels-like temperature to set
     */
    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    /**
     * Retrieves the weather description.
     *
     * @return the weather description
     */
    public String getDescr() {
        return descr;
    }

    /**
     * Sets the weather description.
     *
     * @param descr the weather description to set
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }

    /**
     * Retrieves the minimum temperature.
     *
     * @return the minimum temperature
     */
    public String getMinTemp() {
        return minTemp;
    }

    /**
     * Sets the minimum temperature.
     *
     * @param minTemp the minimum temperature to set
     */
    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    /**
     * Retrieves the maximum temperature.
     *
     * @return the maximum temperature
     */
    public String getMaxTemp() {
        return maxTemp;
    }

    /**
     * Sets the maximum temperature.
     *
     * @param maxTemp the maximum temperature to set
     */
    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    /**
     * Retrieves the date and time of the weather data.
     *
     * @return the date and time
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Sets the date and time of the weather data.
     *
     * @param dateTime the date and time to set
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Retrieves the icon identifier for the weather condition.
     *
     * @return the icon identifier
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Sets the icon identifier for the weather condition.
     *
     * @param icon the icon identifier to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Retrieves the probability of rain.
     *
     * @return the probability of rain
     */
    public String getProbabilityOfRain() {
        return probabilityOfRain;
    }

    /**
     * Sets the probability of rain.
     *
     * @param probabilityOfRain the probability of rain to set
     */
    public void setProbabilityOfRain(String probabilityOfRain) {
        this.probabilityOfRain = probabilityOfRain;
    }

    /**
     * Retrieves the wind speed.
     *
     * @return the wind speed
     */
    public String getWindSpeed() {
        return windSpeed;
    }

    /**
     * Sets the wind speed.
     *
     * @param windSpeed the wind speed to set
     */
    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
    
    /**
     * Retrieves the humidity.
     *
     * @return humidity
     */
    public String getHumidity() {
        return humidity;
    }

    /**
     * Sets the humidity.
     *
     * @param humidity to set
     */
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
    
    @Override
    public String toString() {
        return String.format("Max Temp: %s, Min Temp: %s, Icon: %s, DateTime: %s", maxTemp, minTemp, icon, dateTime);
    }
}
