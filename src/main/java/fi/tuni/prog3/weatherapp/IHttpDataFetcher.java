/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import java.io.IOException;

/**
 * Defines an interface for fetching data from a specified URL.
 * This interface can be implemented by any class that needs to retrieve data over HTTP.
 */
public interface IHttpDataFetcher {
    
    /**
     * Fetches data from the specified URL.
     * 
     * @param urlString The URL from which data is to be fetched.
     * @return A string containing the response data from the URL.
     * @throws IOException If an input or output exception occurs while fetching the data.
     */
    String fetchData(String urlString) throws IOException;
}

