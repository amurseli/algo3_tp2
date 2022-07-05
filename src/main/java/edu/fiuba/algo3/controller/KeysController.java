package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.Direcciones.Abajo;
import edu.fiuba.algo3.modelo.Direcciones.Arriba;
import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Direcciones.Izquierda;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VehiculoView;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeysController implements EventHandler<KeyEvent> {
    @Override
    public void handle(KeyEvent keyEvent) {
    }

    public void leerInputs(Scene scene, Juego juego) {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
                juego.mover(new Arriba());
            }
            if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
                juego.mover(new Abajo());
            }
            if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
                juego.mover(new Izquierda());
            }
            if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
                juego.mover(new Derecha());
            }

        });
    }
}
