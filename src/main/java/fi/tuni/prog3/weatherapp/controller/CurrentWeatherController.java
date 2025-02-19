/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.AutoLocation;

import fi.tuni.prog3.weatherapp.WeatherIcons;

import fi.tuni.prog3.weatherapp.WeatherModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentWeatherController implements Initializable {

    @FXML
    private Label dateTimeLabel;
    @FXML
    private Label currentWeatherLocationLabel;
    @FXML
    private Label currentWeatherTempLabel;
    @FXML
    private Label currentWeatherStringLabel;
    @FXML
    private ImageView weatherIcon;
    @FXML
    private Label currentWeatherHumidityLabel;
    @FXML
    private Label currentWeatherWindLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }

    /**
     * Function to update current weather associated controls
     */
    public void loadData() {
        WeatherModel model = WeatherModel.getInstance();
        var weatherItem = model.getCurrentWeatherItem();
        dateTimeLabel.setText(getCurrentTime());
        currentWeatherLocationLabel.setText(String.format("%s, %s", WeatherModel.getInstance().getLocation(), weatherItem.getCountry()));
        currentWeatherWindLabel.setText("Wind: " + weatherItem.getWindSpeed());
        currentWeatherHumidityLabel.setText("Humidity: " + weatherItem.getHumidity() + "%");
        currentWeatherTempLabel.setText(String.format("%.1f °C", weatherItem.getTemp()));
        currentWeatherStringLabel.setText(weatherItem.getDescr());

        var iconFile = WeatherIcons.getIconPath(weatherItem.getIcon());

        if (!"".equals(iconFile)) {
            Image image = new Image(getClass().getResource("/fi/tuni/prog3/weatherapp/icons/" + iconFile).toString());
            weatherIcon.setImage(image);
        } else {
            Image image = new Image("https://openweathermap.org/img/wn/" + weatherItem.getIcon() + "@2x.png");
            weatherIcon.setImage(image);
        }

    }

    private String getCurrentTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, HH:mm");
        String formattedDateTime = currentDateTime.format(formatter);
        return formattedDateTime;
    }

}
