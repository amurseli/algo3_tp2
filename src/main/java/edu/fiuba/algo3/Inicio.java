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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Group layout = new Group();
        Button button = new Button("COMIENZA EL JUEGO");
        button.setLayoutX(1620/2);
        button.setLayoutY(720/2);

        layout.getChildren().add(button);

        var scene = new Scene(layout, 1620, 720);
        primaryStage.setScene(scene);
        primaryStage.show();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                App.launch();
            }
        });

    }

    @Override
    public void handle(ActionEvent actionEvent) {
    }
}
