/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.WeatherIcons;
import fi.tuni.prog3.weatherapp.WeatherItem;
import fi.tuni.prog3.weatherapp.WeatherModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ivanperov
 */
public class DailyForecastController implements Initializable {

    @FXML
    private VBox weatherItemsVBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        weatherItemsVBox.getChildren().add(new Label(""));
        loadData();
    }

    /**
     * Function to update daily forecasts associated controls
     */
    public void loadData() {
        WeatherModel model = WeatherModel.getInstance();
        var dailyForecast = model.getDailyWeatherItems();
        weatherItemsVBox.getChildren().clear();

        for (WeatherItem weatherItem : dailyForecast) {

            HBox weatherItemHBox = new HBox(10);
            Label dateLabel = new Label(weatherItem.getDateTime());
            ImageView iconImageView = new ImageView();
            var iconFile = WeatherIcons.getIconPath(weatherItem.getIcon());

            if (!"".equals(iconFile)) {
                Image image = new Image(getClass().getResource("/fi/tuni/prog3/weatherapp/icons/" + iconFile).toString());
                iconImageView = new ImageView(image);
            } else {
                Image image = new Image("https://openweathermap.org/img/wn/" + weatherItem.getIcon() + "@2x.png");
                iconImageView = new ImageView(image);
            }

            iconImageView.setFitWidth(30);
            iconImageView.setFitHeight(30);
            Label maxTempLabel = new Label(weatherItem.getMaxTemp());
            Label minTempLabel = new Label(" / " + weatherItem.getMinTemp());

            weatherItemHBox.getChildren().addAll(dateLabel, iconImageView, maxTempLabel, minTempLabel);

            weatherItemsVBox.getChildren().add(weatherItemHBox);
        }

    }

}
