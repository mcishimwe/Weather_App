/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp.data;

/**
 * Represents cloudiness information, encapsulating the cloudiness percentage.
 * 
 * @author ivanperov
 */
public class Clouds {
    private int all;

    /**
     * Retrieves the cloudiness percentage.
     * 
     * @return the cloudiness percentage
     */
    public int getAll() {
        return all;
    }

    /**
     * Sets the cloudiness percentage.
     * 
     * @param all the cloudiness percentage to set
     */
    public void setAll(int all) {
        this.all = all;
    }
}

