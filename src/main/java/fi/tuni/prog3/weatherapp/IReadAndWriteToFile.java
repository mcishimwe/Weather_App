/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

/**
 * Interface with methods to read from a file and write to a file.
 */
public interface IReadAndWriteToFile {
    
    /**
     * Reads JSON from the given file.
     * @param fileName name of the file to read from.
     * @return true if the read was successful, otherwise false.
     * @throws java.lang.Exception
     */
    public String readFromFile(String fileName) throws Exception; 

    /**
     * Write the current state of object as JSON into the given file.
     * @param fileName name of the file to write to.
     * @return true if the write was successful, otherwise false.
     */
    public boolean writeToFile(String fileName);
}
