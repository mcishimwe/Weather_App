/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import fi.tuni.prog3.weatherapp.data.Coord;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class representing application settings, including user's favorite locations
 * and search history.
 */
public class AppSettings {

    private LinkedHashMap<String, Coord> favoriteLocations;
    private Set<String> history;
    private Boolean valid;

    /**
     * Constructs an AppSettings object with empty favorite locations and
     * history lists.
     */
    public AppSettings() {
        this.favoriteLocations = new LimitedMap<>();
        this.history = new HashSet<>();
    }

    /**
     * Adds a location to the list of favorite locations.
     *
     * @param location The location to be added to favorites.
     * @param coord coordinates of location
     */
    public void addFavorite(String location, Coord coord) {
        if (favoriteLocations.containsKey(location)) {
            return;
        }
        favoriteLocations.put(location, coord);
        WeatherModel.getInstance().setFavs();
    }

    /**
     * Removes a location from the list of favorite locations.
     *
     * @param location The location to be removed from favorites.
     */
    public void removeFavorite(String location) {
        favoriteLocations.remove(location);
    }

    /**
     * Adds a location to the search history.
     *
     * @param location The location to be added to the history.
     */
    public void addToHistory(String location) {
        history.add(location);
    }

    /**
     * Clears the search history.
     */
    public void clearHistory() {
        history.clear();
    }

    /**
     * Gets the list of favorite locations.
     *
     * @return The list of favorite locations.
     */
    public LinkedHashMap<String, Coord> getFavoriteLocations() {
        return favoriteLocations;
    }

    /**
     * Sets the list of favorite locations.
     *
     * @param favoriteLocations The list of locations to set as favorites.
     */
    public void setFavoriteLocations(LinkedHashMap<String, Coord> favoriteLocations) {
        this.favoriteLocations = favoriteLocations;
    }

    /**
     * Gets the search history.
     *
     * @return The list of locations in the search history.
     */
    public Set<String> getHistory() {
        return history;
    }

    /**
     * Sets the search history.
     *
     * @param history The list of locations to set as the search history.
     */
    public void setHistory(Set<String> history) {
        this.history = history;
    }

    /**
     * Gets the validity status of the settings.
     *
     * @return The validity status.
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * Sets the validity status of the settings.
     *
     * @param valid The validity status to set.
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public static class LimitedMap<K, V> extends LinkedHashMap<K, V> {

        private static final int MAX_ENTRIES = 3;

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > MAX_ENTRIES;
        }

    }
}
