/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp.data;

import java.util.List;

/**
 * Represents an individual item in a daily weather forecast. This class includes detailed weather information such as
 * date and time, sunrise and sunset times, temperature details, weather conditions, wind speed and direction, cloudiness,
 * probability of precipitation, and amounts of rain and snow.
 * 
 * @author ivanperov
 */
public class DailyForecastItem {

    private long dt;
    private long sunrise;
    private long sunset;
    private TempDetails temp;
    private TempDetails feels_like;
    private int pressure;
    private int humidity;
    private List<Weather> weather;
    private double speed;
    private int deg;
    private double gust;
    private int clouds;
    private double pop;
    private double rain;
    private double snow;

    /**
     * Retrieves a string representation of the main weather condition.
     *
     * @return the main weather condition as a string
     */
    public String getTemperatureString() {
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
     * Retrieves the daytime temperature.
     *
     * @return the daytime temperature
     */
    public double getDayTemp() {
        return this.temp.getDay();
    }

    /**
     * Retrieves the nighttime temperature.
     *
     * @return the nighttime temperature
     */
    public double getNightTemp() {
        return this.temp.getNight();
    }

    /**
     * Retrieves the maximum temperature.
     *
     * @return the maximum temperature
     */
    public double getMaxTemp() {
        return this.temp.getMax();
    }

    /**
     * Retrieves the minimum temperature.
     *
     * @return the minimum temperature
     */
    public double getMinTemp() {
        return this.temp.getMin();
    }

    /**
     * Retrieves the date and time of the forecast item in Unix format.
     *
     * @return the date and time
     */
    public long getDt() {
        return dt;
    }

    /**
     * Sets the date and time of the forecast item in Unix format.
     *
     * @param dt the date and time to set
     */
    public void setDt(long dt) {
        this.dt = dt;
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

    /**
     * Retrieves the temperature details.
     *
     * @return the temperature details
     */
    public TempDetails getTemp() {
        return temp;
    }

    /**
     * Sets the temperature details.
     *
     * @param temp the temperature details to set
     */
    public void setTemp(TempDetails temp) {
        this.temp = temp;
    }

    /**
     * Retrieves the feels-like temperature details.
     *
     * @return the feels-like temperature details
     */
    public TempDetails getFeels_like() {
        return feels_like;
    }

    /**
     * Sets the feels-like temperature details.
     *
     * @param feels_like the feels-like temperature details to set
     */
    public void setFeels_like(TempDetails feels_like) {
        this.feels_like = feels_like;
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
     * @return the wind direction
     */
    public int getDeg() {
        return deg;
    }

    /**
     * Sets the wind direction in degrees.
     *
     * @param deg the wind direction to set
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

    /**
     * Retrieves the cloudiness percentage.
     *
     * @return the cloudiness percentage
     */
    public int getClouds() {
        return clouds;
    }

    /**
     * Sets the cloudiness percentage.
     *
     * @param clouds the cloudiness percentage to set
     */
    public void setClouds(int clouds) {
        this.clouds = clouds;
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
     * Retrieves the amount of rain.
     *
     * @return the amount of rain
     */
    public double getRain() {
        return rain;
    }

    /**
     * Sets the amount of rain.
     *
     * @param rain the amount of rain to set
     */
    public void setRain(double rain) {
        this.rain = rain;
    }

    /**
     * Retrieves the amount of snow.
     *
     * @return the amount of snow
     */
    public double getSnow() {
        return snow;
    }

    /**
     * Sets the amount of snow.
     *
     * @param snow the amount of snow to set
     */
    public void setSnow(double snow) {
        this.snow = snow;
    }

}
