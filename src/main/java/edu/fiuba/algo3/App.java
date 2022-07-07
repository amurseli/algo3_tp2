package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.JuegoView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    public static final int MULTIPLICADOR = 50;
    public static final int SCREEN_WIDTH = 1620;
    public static final int SCREEN_HEIGHT = 720;

    @Override
    public void start(Stage stage) {

        new JuegoView(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}