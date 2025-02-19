module fi.tuni.prog3.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires commons.lang3;

    opens fi.tuni.prog3.weatherapp to javafx.fxml, com.google.gson;
    opens fi.tuni.prog3.weatherapp.data to com.google.gson, fi.tuni.prog3.weatherapp;
    opens fi.tuni.prog3.weatherapp.controller to javafx.fxml;
    exports fi.tuni.prog3.weatherapp;
    exports fi.tuni.prog3.weatherapp.data;    
    exports fi.tuni.prog3.weatherapp.controller;
    requires com.google.gson; 
    requires java.base;
}
