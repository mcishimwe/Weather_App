/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

/**
 *
 * @author ivanperov
 */
public class FakeDataFetcher implements IHttpDataFetcher {

    private String fakeResponse;

    public FakeDataFetcher(String fakeResponse) {
        this.fakeResponse = fakeResponse;
    }

    @Override
    public String fetchData(String urlString) {
        return fakeResponse;
    }
}

