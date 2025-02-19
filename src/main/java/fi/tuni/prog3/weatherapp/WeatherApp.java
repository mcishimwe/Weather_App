package fi.tuni.prog3.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main application class for the WeatherApp. This class is responsible for
 * initializing and displaying the primary stage and scene of the application.
 */
public class WeatherApp extends Application {

    private static Scene scene;

    /**
     * Starts the JavaFX application. This method is called by the main method.
     * It initializes the primary stage of the application, loads the initial
     * scene, and shows the stage.
     *
     * @param stage The primary stage for this application.
     * @throws IOException if there is an error loading the FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        SettingsManager.getInstance().loadSettings();
        scene = new Scene(loadFXML("main"), 800, 800);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Sets the root of the scene to a new layout defined by the FXML file.
     *
     * @param fxml The name of the FXML file to load.
     * @throws IOException if there is an error loading the FXML.
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Loads an FXML file and returns the root node of the scene graph.
     *
     * @param fxml The name of the FXML file to load.
     * @return The root node of the loaded FXML file.
     * @throws IOException if there is an error loading the FXML.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WeatherApp.class.getResource("/fi/tuni/prog3/weatherapp/fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * The main entry point for all JavaFX applications. The start method is called
     * after the application has been initialized.
     *
     * @param args Command line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Called when the application should stop, and provides a convenient place to
     * prepare for application exit and save any persistent state.
     */
    @Override
    public void stop() {
        SettingsManager.getInstance().saveSettings();
    }
}
