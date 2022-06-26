package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.Esquina;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.ListadoCaminos;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.VehiculoView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    public static final int MULTIPLICADOR = 50;
    Button button;
    @Override
    public void start(Stage stage) {

        Group layout = new Group();
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10,10),new Esquina(1,9),new Vehiculo(new Auto(), new Esquina(5,5)));

        Camino camino1 = new Camino(new Esquina(2,2),new Derecha());
        camino1.agregrarEfecto(new Pozo());
        juego.agregarCamino(camino1);

        Camino camino2 = new Camino(new Esquina(5,1),new Derecha());
        camino2.agregrarEfecto(new Piquete());
        juego.agregarCamino(camino2);

        Esquina limite = juego.devolverLimite();
        Esquina posicionJugador = juego.obtenerPosicionVehiculo();
        Esquina posicionMeta = juego.obtenerMeta();


        Rectangle mapa = new Rectangle(limite.columna * MULTIPLICADOR, limite.fila* MULTIPLICADOR);
        mapa.setX(1620/2 - mapa.getWidth()/2); //los pongo en el centro
        mapa.setY(720/2 - mapa.getHeight()/2);
        layout.getChildren().add(mapa);


        //aca se crean los caminos blancos
        for (int i = 0; i < 30 ; i++){
            Rectangle caminitoHorizontal = new Rectangle(1620, 20);
            Rectangle caminitoVertical = new Rectangle(20, 720);
            caminitoHorizontal.setFill(Paint.valueOf("white"));
            caminitoVertical.setFill(Paint.valueOf("white"));
            caminitoHorizontal.setY(i * MULTIPLICADOR + 10);
            caminitoVertical.setX(i* MULTIPLICADOR + 10);
            layout.getChildren().add(caminitoHorizontal);
            layout.getChildren().add(caminitoVertical);
        }

        Image meta = new Image("/meta.png",30,30,true,true);
        ImageView metaView = new ImageView(meta);
        metaView.setX(1620/2 - mapa.getWidth()/2 +  (posicionMeta.columna)* MULTIPLICADOR);
        metaView.setY(720/2 - mapa.getHeight()/2 + (posicionMeta.fila)* MULTIPLICADOR);
        layout.getChildren().add(metaView);

        ListadoCaminos caminosConEfectos = juego.obtenerEfectos();
        for (Camino camino : caminosConEfectos.caminosConEfectos) {

            Image efecto = new Image("/piquete.png",30,30,true,false);
            ImageView efectoView = new ImageView(efecto);
            efectoView.setX(1620/2 - mapa.getWidth()/2 - 5 +  (camino.esquinaInicial.columna * MULTIPLICADOR + camino.esquinaFinal.columna*MULTIPLICADOR) / 2);
            efectoView.setY(720/2 - mapa.getHeight()/2 - 5 + (camino.esquinaInicial.fila * MULTIPLICADOR + camino.esquinaFinal.fila*MULTIPLICADOR) / 2);
            layout.getChildren().add(efectoView);
        }


        Image image1 = new Image("/auto.png", 20, 40,true,false);
        ImageView imageView1 = new ImageView(image1);
        imageView1.setX(MULTIPLICADOR);
        imageView1.setY(MULTIPLICADOR);

        layout.getChildren().add(imageView1);



        Image vehicle = new Image("/auto.png", 20, 40,true,false);
        ImageView imageVehicle = new ImageView(vehicle);

        imageVehicle.setX(1620/2 - mapa.getWidth()/2 + posicionJugador.columna * MULTIPLICADOR);
        imageVehicle.setY(720/2 - mapa.getHeight()/2 + posicionJugador.fila * MULTIPLICADOR);
        imageView1.setRotate(270);
        layout.getChildren().add(imageVehicle);

        var scene = new Scene(layout, 1620, 720);

        stage.setScene(scene);
        stage.show();

        leerInputs(scene,juego,imageVehicle,mapa,stage);


    }

    @Override
    public void handle(KeyEvent event){
        System.out.println(event.getCode().isArrowKey());
    }

    public static void main(String[] args) {
        launch();
    }

    private void leerInputs(Scene scene, Juego juego, ImageView vehicle, Rectangle mapa, Stage stage){
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.W){

                juego.mover(new Arriba());
                Esquina posicionActual = juego.obtenerPosicionVehiculo();
                vehicle.setY(720/2 - mapa.getHeight()/2 + posicionActual.fila * MULTIPLICADOR);
                vehicle.setRotate(180);

                System.out.println("W");
                stage.setScene(scene);
                stage.show();
            }
            if(event.getCode() == KeyCode.S){
                juego.mover(new Abajo());
                Esquina posicionActual = juego.obtenerPosicionVehiculo();
                vehicle.setY(720/2 - mapa.getHeight()/2 + posicionActual.fila * MULTIPLICADOR);
                vehicle.setRotate(0);
                stage.setScene(scene);



                System.out.println("S");
                stage.show();
            }
            if(event.getCode() == KeyCode.A){
                juego.mover(new Izquierda());
                Esquina posicionActual = juego.obtenerPosicionVehiculo();
                stage.setScene(scene);
                vehicle.setX(1620/2 - mapa.getWidth()/2 + posicionActual.columna * MULTIPLICADOR);
                vehicle.setRotate(90);
                System.out.println("A");
                stage.show();
            }
            if(event.getCode() == KeyCode.D){
                juego.mover(new Derecha());
                Esquina posicionActual = juego.obtenerPosicionVehiculo();
                vehicle.setX(1620/2 - mapa.getWidth()/2 + posicionActual.columna * MULTIPLICADOR);
                vehicle.setRotate(270);
                stage.setScene(scene);
                System.out.println("D");
                stage.show();
            }
        });

    }

}