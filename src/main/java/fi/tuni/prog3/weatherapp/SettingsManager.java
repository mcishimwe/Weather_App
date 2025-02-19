/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import com.google.gson.Gson;
import fi.tuni.prog3.weatherapp.AppSettings.LimitedMap;
import fi.tuni.prog3.weatherapp.data.Coord;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;

/**
 * Manages the application settings by reading from and writing to a file.
 *
 * @author Ivan Perov
 */
public class SettingsManager implements IReadAndWriteToFile {

    private AppSettings settings;
    private Gson gson = new Gson();
    private String defaultFileName = "WeatherAppSettings.json";
    private static SettingsManager instance;

    private SettingsManager() {
    }

    /**
     * Provides access to the singleton instance of the SettingsManager.
     *
     * @return The singleton instance of the SettingsManager.
     */
    public static SettingsManager getInstance() {
        if (instance == null) {
            instance = new SettingsManager();
        }
        return instance;
    }

    /**
     * Reads the contents of a file and returns it as a string.
     *
     * @param fileName The name of the file to be read.
     * @return The contents of the file as a string.
     * @throws Exception if there is an error reading the file.
     */
    @Override
    public String readFromFile(String fileName) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        return content;
    }

    /**
     * Writes the current settings to a file in JSON format.
     *
     * @param fileName The name of the file to which the settings will be
     * written.
     * @return true if the writing is successful, false if an error occurs.
     */
    @Override
    public boolean writeToFile(String fileName) {
        try {
            String json = gson.toJson(settings);
            Files.write(Paths.get(fileName), json.getBytes());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Loads the application settings from the default file. If the file does
     * not exist or an error occurs, it returns a new instance with default
     * values.
     *
     * @return The loaded or default application settings.
     */
    public AppSettings loadSettings() {
        try {
            String content = readFromFile(defaultFileName);
            settings = gson.fromJson(content, AppSettings.class);
            LinkedHashMap<String, Coord> map = new LimitedMap<>();
            map.putAll(settings.getFavoriteLocations());
            settings.setFavoriteLocations(map);
            settings.setValid(true);
        } catch (Exception e) {
            settings = new AppSettings();
            settings.setValid(false);
        }
        return settings;
    }
    
    /**
     * Saves settings to default file.
     * @return true if success
     */
    public boolean saveSettings() {
        return writeToFile(defaultFileName);
    }

    /**
     * Retrieves the current application settings.
     *
     * @return The current settings.
     */
    public AppSettings getSettings() {
        return settings;
    }

    /**
     * Sets the application settings.
     *
     * @param settings The settings to be used by the application.
     */
    public void setSettings(AppSettings settings) {
        this.settings = settings;
    }

    /**
     * Sets the default file name used for saving settings.
     *
     * @param defaultFileName The default file name to be used.
     */
    public void setDefaultFileName(String defaultFileName) {
        this.defaultFileName = defaultFileName;
    }

}
