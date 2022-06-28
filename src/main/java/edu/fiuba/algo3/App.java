package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.Esquina;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.ListadoCaminos;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.VehiculoView;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application implements EventHandler<KeyEvent> {
    public static final int MULTIPLICADOR = 50;
    @Override
    public void start(Stage stage) {

        Group layout = new Group();
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10,10),new Esquina(1,9),new Vehiculo(new Auto(), new Esquina(5,5)));

        Esquina limite = juego.obtenerLimite();
        Esquina posicionMeta = juego.obtenerMeta();

        //agregar los efectos. Aca tendria que haber un for que agregue ponele 15 efectos random en el mapa
        Camino camino1 = new Camino(new Esquina(2,2),new Derecha());
        camino1.agregrarEfecto(new Pozo());
        juego.agregarCamino(camino1);

        Camino camino2 = new Camino(new Esquina(5,1),new Derecha());
        camino2.agregrarEfecto(new Piquete());
        juego.agregarCamino(camino2);

        Camino camino3 = new Camino(new Esquina(4,4),new Derecha());
        camino3.agregrarEfecto(new CambioDeVehiculo());
        juego.agregarCamino(camino3);

        Camino camino4 = new Camino(new Esquina(5,4),new Derecha());
        camino4.agregrarEfecto(new CambioDeVehiculo());
        juego.agregarCamino(camino4);



        //creo el mapa
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


        mostrarEfectos(juego,layout,mapa);

        VehiculoView vehiculoView = new VehiculoView(juego.obtenerVehiculo(), layout, mapa);

        var scene = new Scene(layout, 1620, 720);

        stage.setScene(scene);
        stage.show();

        leerInputs(scene,juego,vehiculoView,stage);


    }

    @Override
    public void handle(KeyEvent event){
        System.out.println(event.getCode().isArrowKey());
    }

    public static void main(String[] args) {
        launch();
    }

    private void leerInputs(Scene scene, Juego juego, VehiculoView vehiculoView, Stage stage){
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.W){

                juego.mover(new Arriba());
                vehiculoView.actualizarPosicion(juego.obtenerVehiculo(),180);
            }
            if(event.getCode() == KeyCode.S){
                juego.mover(new Abajo());
                vehiculoView.actualizarPosicion(juego.obtenerVehiculo(),0);

            }
            if(event.getCode() == KeyCode.A){
                juego.mover(new Izquierda());
                vehiculoView.actualizarPosicion(juego.obtenerVehiculo(),90);

            }
            if(event.getCode() == KeyCode.D){
                juego.mover(new Derecha());
                vehiculoView.actualizarPosicion(juego.obtenerVehiculo(),270);

            }
        });
        stage.setScene(scene);
        stage.show();
    }

    private void mostrarEfectos(Juego juego, Group layout, Rectangle mapa){
        ListadoCaminos caminosConEfectos = juego.obtenerCaminos();
        for (Camino camino : caminosConEfectos.caminosConEfectos) {

            Image efecto = new Image("/piquete.png",30,30,true,false);
            ImageView efectoView = new ImageView(efecto);
            efectoView.setX(1620/2 - mapa.getWidth()/2 - 5 +  (camino.esquinaInicial.columna * MULTIPLICADOR + camino.esquinaFinal.columna*MULTIPLICADOR) / 2);
            efectoView.setY(720/2 - mapa.getHeight()/2 - 5 + (camino.esquinaInicial.fila * MULTIPLICADOR + camino.esquinaFinal.fila*MULTIPLICADOR) / 2);
            layout.getChildren().add(efectoView);
        }
    }

}