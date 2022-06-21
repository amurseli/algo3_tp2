package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.Esquina;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.ListadoCaminos;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application implements EventHandler<KeyEvent> {
    Button button;
    @Override
    public void start(Stage stage) {

        Group layout = new Group();
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10,10),new Esquina(1,9),new Vehiculo(new Auto(), new Esquina(5,5)));
        juego.agregarCaminoConEfecto(new Camino(new Esquina(2,2),new Derecha()), new Pozo());
        juego.agregarCaminoConEfecto(new Camino(new Esquina(2,7),new Abajo()), new Piquete());
        Esquina limite = juego.devolverLimite();
        Esquina posicionJugador = juego.obtenerVehiculo().posicion;
        Esquina posicionMeta = juego.obtenerMeta();


        Rectangle mapa = new Rectangle(limite.columna * 50, limite.fila* 50);
        mapa.setX(1620/2 - mapa.getWidth()/2); //los pongo en el centro
        mapa.setY(720/2 - mapa.getHeight()/2);
        layout.getChildren().add(mapa);


        //aca se crean los caminos blancos
        for (int i = 0; i < 30 ; i++){
            Rectangle caminitoHorizontal = new Rectangle(1620, 20);
            Rectangle caminitoVertical = new Rectangle(20, 720);
            caminitoHorizontal.setFill(Paint.valueOf("white"));
            caminitoVertical.setFill(Paint.valueOf("white"));
            caminitoHorizontal.setY(i * 50 + 10);
            caminitoVertical.setX(i* 50 + 10);
            layout.getChildren().add(caminitoHorizontal);
            layout.getChildren().add(caminitoVertical);
        }

        Rectangle meta = new Rectangle(20,20);
        meta.setFill(Paint.valueOf("blue"));
        meta.setX(1620/2 - mapa.getWidth()/2 +  (posicionMeta.columna)* 50);
        meta.setY(720/2 - mapa.getHeight()/2 + (posicionMeta.fila)* 50);
        layout.getChildren().add(meta);

        ListadoCaminos caminosConEfectos = juego.obtenerEfectos();
        for (Camino camino : caminosConEfectos.caminosConEfectos) {
            Rectangle efecto = new Rectangle(20,20);
            efecto.setFill(Paint.valueOf("green"));
            efecto.setX(1620/2 - mapa.getWidth()/2 +  (camino.esquinaInicial.columna * 50 + camino.esquinaFinal.columna*50) / 2);
            efecto.setY(720/2 - mapa.getHeight()/2 + (camino.esquinaInicial.fila * 50 + camino.esquinaFinal.fila*50) / 2);
            layout.getChildren().add(efecto);
        }


        Rectangle vehicle = new Rectangle(20, 15);
        vehicle.setFill(Paint.valueOf("red"));
        vehicle.setX(1620/2 - mapa.getWidth()/2 + posicionJugador.columna * 50);
        vehicle.setY(720/2 - mapa.getHeight()/2 + posicionJugador.fila * 50);
        layout.getChildren().add(vehicle);

        var scene = new Scene(layout, 1620, 720);

        stage.setScene(scene);
        stage.show();

        leerInputs(scene,juego,vehicle,mapa,stage);


    }

    @Override
    public void handle(KeyEvent event){
        System.out.println(event.getCode().isArrowKey());
    }

    public static void main(String[] args) {
        launch();
    }

    private void leerInputs(Scene scene, Juego juego, Rectangle vehicle, Rectangle mapa, Stage stage){
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.W){

                juego.mover(new Arriba());
                Esquina posicionActual = juego.obtenerVehiculo().posicion;
                vehicle.setY(720/2 - mapa.getHeight()/2 + posicionActual.fila * 50);

                System.out.println("W");
                stage.setScene(scene);
                stage.show();
            }
            if(event.getCode() == KeyCode.S){
                juego.mover(new Abajo());
                Esquina posicionActual = juego.obtenerVehiculo().posicion;
                vehicle.setY(720/2 - mapa.getHeight()/2 + posicionActual.fila * 50);
                stage.setScene(scene);

                System.out.println("S");
                stage.show();
            }
            if(event.getCode() == KeyCode.A){
                juego.mover(new Izquierda());
                Esquina posicionActual = juego.obtenerVehiculo().posicion;
                stage.setScene(scene);
                vehicle.setX(1620/2 - mapa.getWidth()/2 + posicionActual.columna * 50);
                System.out.println("A");
                stage.show();
            }
            if(event.getCode() == KeyCode.D){
                juego.mover(new Derecha());
                Esquina posicionActual = juego.obtenerVehiculo().posicion;
                vehicle.setX(1620/2 - mapa.getWidth()/2 + posicionActual.columna * 50);
                stage.setScene(scene);
                System.out.println("D");
                stage.show();
            }
        });

    }

}