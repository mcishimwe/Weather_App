/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp.data;

/**
 * Represents weather data with attributes for weather conditions.
 *
 * @author ivanperov
 */
public class Weather {

    private int id;
    private String main;
    private String description;
    private String icon;

    /**
     * Retrieves the weather condition's unique identifier.
     *
     * @return the weather condition's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the weather condition's unique identifier.
     *
     * @param id the unique identifier for the weather condition
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the main group of weather parameters.
     *
     * @return the main weather condition
     */
    public String getMain() {
        return main;
    }

    /**
     * Sets the main group of weather parameters.
     *
     * @param main the main weather condition to set
     */
    public void setMain(String main) {
        this.main = main;
    }

    /**
     * Retrieves the detailed description of the weather condition.
     *
     * @return the weather condition description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the detailed description of the weather condition.
     *
     * @param description the description of the weather condition
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @param icon the icon identifier for the weather condition
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

}
