package fi.tuni.prog3.weatherapp;

import fi.tuni.prog3.weatherapp.data.*;
import java.net.URL;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherAPITest {

    public WeatherAPITest() {
    }

    @Test
    public void testGetCurrentWeather() {
        String json = "{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10n\"}],\"base\":\"stations\",\"main\":{\"temp\":281.12,\"feels_like\":278.87,\"temp_min\":279.64,\"temp_max\":282.19,\"pressure\":1005,\"humidity\":91},\"visibility\":10000,\"wind\":{\"speed\":3.6,\"deg\":160},\"rain\":{\"1h\":1.71},\"clouds\":{\"all\":75},\"dt\":1701639073,\"sys\":{\"type\":2,\"id\":2075535,\"country\":\"GB\",\"sunrise\":1701589572,\"sunset\":1701618868},\"timezone\":0,\"id\":2643743,\"name\":\"London\",\"cod\":200}";

        try {
            IHttpDataFetcher fakeFetcher = new FakeDataFetcher(json);

            WeatherAPI model = new WeatherAPI(fakeFetcher);
            CurrentWeather weather = model.getCurrentWeather("London");

            assertNotNull(weather);
            assertEquals(-0.1257, weather.getCoord().getLon());
            assertEquals(51.5085, weather.getCoord().getLat());
            assertEquals(281.12, weather.getMain().getTemp());
            assertEquals(1005, weather.getMain().getPressure());
            assertEquals(91, weather.getMain().getHumidity());
            assertEquals("London", weather.getName());
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testGetHourlyForecast() {
        try {
            URL url = getClass().getClassLoader().getResource("hourlyResponse.json");
            String json = JsonHandler.readFromFile(url.getPath());
            
            IHttpDataFetcher fakeFetcher = new FakeDataFetcher(json);

            WeatherAPI model = new WeatherAPI(fakeFetcher);
            HourlyWeather weather = model.getHourlyForecast(-0.1257, 51.5085);

            assertNotNull(weather);
            assertEquals(96, weather.getList().size());
            assertEquals(304.2, weather.getList().get(8).getMain().getFeels_like());
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }
}
