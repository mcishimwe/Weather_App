/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.WeatherModel;
import fi.tuni.prog3.weatherapp.DateConverter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author ivanperov
 */
public class HourlyForecastController implements Initializable {

    @FXML
    private LineChart<String, Number> lineChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lineChart.setCreateSymbols(false);
        loadData();

    }

    /**
     * Function to update hourly forecast associated controls
     */
    public void loadData() {

          XYChart.Series<String, Number> series = new XYChart.Series<>();
            WeatherModel model = WeatherModel.getInstance();
            int counter = 0;
            for (var item : model.getHourlyWeatherItems()) {
                if (counter > 11) {
                    break;
                }
                var x = String.format("%02d:00", DateConverter.getHour(item.getDateTime()));
                series.getData().add(new XYChart.Data<>(x, item.getTemp()));
                counter++;
            }
            
            lineChart.getData().add(series);
    }
}
