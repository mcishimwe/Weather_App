/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.GeoAutocomplete;
import fi.tuni.prog3.weatherapp.WeatherModel;
import fi.tuni.prog3.weatherapp.AutoLocation;
import fi.tuni.prog3.weatherapp.SettingsManager;
import fi.tuni.prog3.weatherapp.WeatherIcons;
import fi.tuni.prog3.weatherapp.WeatherItem;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

import javafx.scene.layout.HBox;

public class MainController implements Initializable {

    @FXML
    private AnchorPane currentWeather;

    @FXML
    private AnchorPane hourlyForecast;

    @FXML
    private HBox currentView;

    private CurrentWeatherController currentWeatherController;
    private HourlyForecastController hourlyForecastController;
    private DailyForecastController dailyWeatherController;

    @FXML
    private Button city1Button;
    @FXML
    private Button city2Button;
    @FXML
    private Button city3Button;

    @FXML
    private ImageView city1IconImageView;

    @FXML
    private ImageView city2IconImageView;

    @FXML
    private ImageView city3IconImageView;

    @FXML
    private Label city1Label;

    @FXML
    private Label city2Label;

    @FXML
    private Label city3Label;

    @FXML
    private Label warningsLabel;

    @FXML
    private AnchorPane dailyWeather;

    ObservableList<String> searchHistory;

    @FXML
    private ComboBox searchField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        var currentLocation = AutoLocation.getLocation();
        WeatherModel model = WeatherModel.getInstance();
        model.updateWeatherData(currentLocation);
        loadCurrentWeather();
        loadHourlyForecast();
        loadDailyForecast();
        searchHistory = FXCollections.observableArrayList(SettingsManager.getInstance().getSettings().getHistory());
        searchField.getItems().addAll(searchHistory);
        updateFavorites();
    }

    @FXML
    private void handleSearchAction(ActionEvent event) {
        clearWarning();
        String location = searchField.getEditor().getText();
        if (!searchField.getItems().contains(location)) {
            searchField.getItems().add(location);
        }
        updateWeather(location);
    }

    private void updateWeather(String location) {
        WeatherModel model = WeatherModel.getInstance();
        var error = model.updateWeatherData(location);
        if (!"".equals(error)) {
            GeoAutocomplete.getCitySuggestion(location).thenAccept(city -> {
                if ("".equals(city)) {
                    return;
                }
                
                Platform.runLater(() -> {
                    
                    SettingsManager.getInstance().getSettings().addToHistory(city);
                    model.updateWeatherData(city);
                    if (currentWeatherController != null) {
                        currentWeatherController.loadData();
                    }
                    if (dailyWeatherController != null) {
                        dailyWeatherController.loadData();
                    }

                    loadHourlyForecast();
                    setWarning("Check location!");

                });

            });
        } else {
            if (currentWeatherController != null) {
                currentWeatherController.loadData();
            }
            if (dailyWeatherController != null) {
                dailyWeatherController.loadData();
            }
            SettingsManager.getInstance().getSettings().addToHistory(location);
            loadHourlyForecast();
        }

    }

    @FXML
    private void handlefavoritesButton() {
        WeatherModel model = WeatherModel.getInstance();
        var location = model.getLocation();
        var coord = model.getCoord();
        SettingsManager.getInstance().getSettings().addFavorite(location, coord);
        updateFavorites();

    }

    private void updateFavorites() {
        WeatherModel model = WeatherModel.getInstance();
        var locations = model.getFavs();

        int counter = 1;
        for (var location : locations.keySet()) {
            switch (counter) {
                case 1:
                    updateFavButton(location, city1Label, city1IconImageView, city1Button, locations.get(location));
                    break;
                case 2:
                    updateFavButton(location, city2Label, city2IconImageView, city2Button, locations.get(location));
                    break;
                default:
                    updateFavButton(location, city3Label, city3IconImageView, city3Button, locations.get(location));
                    break;
            }

            counter++;
        }

    }

    private void updateFavButton(String location, Label cityLabel, ImageView cityIcon, Button cityButton, WeatherItem item) {

        cityLabel.setText(String.format("%s %.1f °C", location, item.getTemp()));
        var iconFile = WeatherIcons.getIconPath(item.getIcon());
        Image iconImage;

        if (!"".equals(iconFile)) {

            iconImage = new Image(getClass().getResource("/fi/tuni/prog3/weatherapp/icons/" + iconFile).toString());
        } else {

            iconImage = new Image("https://openweathermap.org/img/wn/" + item.getIcon() + "@2x.png");
        }
        cityIcon.setImage(iconImage);
        cityButton.setOnAction(event -> {
            updateWeather(location);
        });

        cityButton.setVisible(true);
    }

    @FXML
    private void handleHistoryButton() {
        SettingsManager.getInstance().getSettings().getHistory().clear();
        searchField.getItems().clear();
    }

    private void loadHourlyForecast() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fi/tuni/prog3/weatherapp/fxml/hourlyForecast.fxml"));
        try {
            hourlyForecast.getChildren().clear();
            hourlyForecast.getChildren().add(fxmlLoader.load());
            hourlyForecastController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCurrentWeather() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fi/tuni/prog3/weatherapp/fxml/currentWeather.fxml"));
        try {
            currentWeather.getChildren().clear();
            currentWeather.getChildren().add(fxmlLoader.load());
            currentWeatherController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadDailyForecast() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fi/tuni/prog3/weatherapp/fxml/dailyForecast.fxml"));
        try {
            dailyWeather.getChildren().clear();
            dailyWeather.getChildren().add(fxmlLoader.load());
            dailyWeatherController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void setWarning(String warning) {
        warningsLabel.setText(warning);
    }

    private void clearWarning() {
        warningsLabel.setText("");
    }
}
