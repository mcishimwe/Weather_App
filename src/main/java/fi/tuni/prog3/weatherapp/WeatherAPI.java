package fi.tuni.prog3.weatherapp;

import fi.tuni.prog3.weatherapp.data.CurrentWeather;
import fi.tuni.prog3.weatherapp.data.DailyWeather;
import fi.tuni.prog3.weatherapp.data.HourlyWeather;
import com.google.gson.Gson;
import java.io.IOException;

/**
 * Class responsible for fetching weather data from the OpenWeatherMap API.
 */
public class WeatherAPI implements IWeatherAPI {

    private static final String API_KEY = "ec9607257c4c34431eb093cae9cb9588";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
    private static final String HOURLY_URL = "https://pro.openweathermap.org/data/2.5/forecast/hourly";
    private static final String DAILY_URL = "https://pro.openweathermap.org/data/2.5/forecast/daily";
    
    private IHttpDataFetcher dataFetcher;
    
    /**
     * Constructs a WeatherAPI with the specified data fetcher.
     *
     * @param dataFetcher The data fetcher to be used for HTTP requests.
     */
    public WeatherAPI(IHttpDataFetcher dataFetcher) {
        this.dataFetcher = dataFetcher;
    }

    /**
     * Retrieves the current weather for a specified location.
     *
     * @param location The location for which to retrieve weather data.
     * @return CurrentWeather object containing weather details.
     * @throws IOException if there is a problem fetching data.
     */
    @Override
    public CurrentWeather getCurrentWeather(String location) throws IOException {
        String urlString = BASE_URL + "?q=" + location + "&appid=" + API_KEY;
        String response = dataFetcher.fetchData(urlString);

        Gson gson = new Gson();
        return gson.fromJson(response, CurrentWeather.class);
    }
    
    /**
     * Retrieves the current weather for specified latitude and longitude.
     *
     * @param lat The latitude of the location.
     * @param lon The longitude of the location.
     * @return CurrentWeather object containing weather details.
     * @throws IOException if there is a problem fetching data.
     */
    @Override
    public CurrentWeather getCurrentWeather(double lat, double lon) throws IOException {
        String urlString = BASE_URL + "?lat=" + lat + "&lon=" + lon + "&appid=" + API_KEY;
        String response = dataFetcher.fetchData(urlString);

        Gson gson = new Gson();
        return gson.fromJson(response, CurrentWeather.class);
    }

    /**
     * Retrieves the hourly weather forecast for specified latitude and longitude.
     *
     * @param lat The latitude of the location.
     * @param lon The longitude of the location.
     * @return HourlyWeather object containing the hourly weather forecast.
     * @throws IOException if there is a problem fetching data.
     */
    @Override
    public HourlyWeather getHourlyForecast(double lat, double lon) throws IOException {
        String urlString = HOURLY_URL + "?lat=" + lat + "&lon=" + lon + "&appid=" + API_KEY;
        String response = dataFetcher.fetchData(urlString);

        Gson gson = new Gson();
        return gson.fromJson(response, HourlyWeather.class);
    }
    
    /**
     * Retrieves the daily weather forecast for specified latitude and longitude.
     *
     * @param lat The latitude of the location.
     * @param lon The longitude of the location.
     * @return DailyWeather object containing the daily weather forecast.
     * @throws IOException if there is a problem fetching data.
     */
    @Override
    public DailyWeather getDailyForecast(double lat, double lon) throws IOException {
        String urlString = DAILY_URL + "?lat=" + lat + "&lon=" + lon + "&cnt=7" + "&appid=" + API_KEY;
        String response = dataFetcher.fetchData(urlString);

        Gson gson = new Gson();
        return gson.fromJson(response, DailyWeather.class);
    }
}
