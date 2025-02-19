/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Implements the IHttpDataFetcher interface to fetch data over HTTP. This class
 * is responsible for making HTTP GET requests to a specified URL and returning
 * the response as a string.
 */
public class HttpDataFetcher implements IHttpDataFetcher {

    /**
     * Fetches data from the specified URL using an HTTP GET request.
     *
     * @param urlString The URL from which data is to be fetched.
     * @return A string containing the response from the URL.
     * @throws IOException If an input or output exception occurred.
     */
    @Override
    public String fetchData(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (Scanner scanner = new Scanner(conn.getInputStream())) {
            return scanner.useDelimiter("\\A").next();
        }
    }
}
