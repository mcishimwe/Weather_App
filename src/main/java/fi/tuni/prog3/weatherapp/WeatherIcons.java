/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author ivanperov
 */
public class WeatherIcons {

    private static Dictionary<String, String> codes = new Hashtable<>();

    static {
        codes.put("01d", "day_clear");
        codes.put("01n", "night_half_moon_clear");
        codes.put("02d", "day_partial_cloud");
        codes.put("02n", "night_half_moon_partial_cloud");
        codes.put("03d", "cloudy");
        codes.put("03n", "cloudy");
        codes.put("04d", "overcast");
        codes.put("04n", "angry_clouds");
        codes.put("09d", "rain");
        codes.put("09n", "rain");
        codes.put("10d", "day_rain");
        codes.put("10n", "night_half_moon_rain");
        codes.put("11d", "day_rain_thunder");
        codes.put("11n", "night_half_moon_rain_thunder");
        codes.put("13d", "day_snow");
        codes.put("13n", "night_half_moon_snow");
        codes.put("50d", "mist");
        codes.put("50n", "fog");

    }

    public static String getIconPath(String code) {
        try {
            return codes.get(code) + ".png";
        } catch (Exception ex) {
            return "";
        }
    }

}
