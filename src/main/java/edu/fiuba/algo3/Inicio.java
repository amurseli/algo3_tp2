package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Inicio extends Application implements EventHandler<ActionEvent> {
    public static final int HALF_WIDTH = 1620 / 2;
    public static final int HALF_HEIGHT = 720 / 2;
    public static final int SCREEN_WIDTH = 1620;
    public static final int SCREEN_HEIGHT = 720;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Group layout = new Group();
        button = new Button("COMIENZA EL JUEGO");
        button.setLayoutX(HALF_WIDTH);
        button.setLayoutY(HALF_HEIGHT);

        layout.getChildren().add(button);

        var scene = new Scene(layout, SCREEN_WIDTH, SCREEN_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource() == button){
            Application.launch(App.class);
        }
    }
}
