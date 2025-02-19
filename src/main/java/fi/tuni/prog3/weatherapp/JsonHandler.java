/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Handles reading from and writing to JSON files.
 * Provides functionality to read the contents of
 * a file and write text to a file.
 *
 */
public class JsonHandler {

    /**
     * Reads content from a file and returns it as a string.
     *
     * @param fileName the name of the file to be read
     * @return the content of the file as a string
     * @throws Exception if there is an error reading the file
     */
    public static String readFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\\Z");
        String content = scanner.next();
        scanner.close();
        return content;
    }

    /**
     * Writes text to a file. If the file does not exist, it will be created.
     *
     * @param fileName the name of the file to write to
     * @param text the text to be written to the file
     * @return true if the writing is successful, false if an error occurs
     * @throws IOException if there is an error in creating or writing to the
     * file
     */
    public static boolean writeToFile(String fileName, String text) throws IOException {
        File file = new File(fileName);
        file.createNewFile();
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
