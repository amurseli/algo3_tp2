package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.ObtaculoView;
import edu.fiuba.algo3.vista.SorpresaView;
import edu.fiuba.algo3.vista.VehiculoView;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application implements EventHandler<KeyEvent> {
    public static final int MULTIPLICADOR = 50;
    public static final int SCREEN_WIDTH = 1620;
    public static final int SCREEN_HEIGHT = 720;

    @Override
    public void start(Stage stage) {

        Group layout = new Group();
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10,10),new Esquina(1,9),new Vehiculo(new Auto(), new Esquina(5,1)));

        Esquina limite = juego.obtenerLimite();
        Esquina posicionMeta = juego.obtenerMeta();


        //creo el mapa
        Rectangle mapa = new Rectangle(limite.columna * MULTIPLICADOR, limite.fila* MULTIPLICADOR);
        mapa.setX(SCREEN_WIDTH/2 - mapa.getWidth()/2); //los pongo en el centro
        mapa.setY(SCREEN_HEIGHT/2 - mapa.getHeight()/2);
        layout.getChildren().add(mapa);


        //aca se crean los caminos blancos
        for (int i = 0; i < 30 ; i++){
            Rectangle caminitoHorizontal = new Rectangle(SCREEN_WIDTH, 20);
            Rectangle caminitoVertical = new Rectangle(20, SCREEN_HEIGHT);
            caminitoHorizontal.setFill(Paint.valueOf("white"));
            caminitoVertical.setFill(Paint.valueOf("white"));
            caminitoHorizontal.setY(i * MULTIPLICADOR + 10);
            caminitoVertical.setX(i* MULTIPLICADOR + 10);
            layout.getChildren().add(caminitoHorizontal);
            layout.getChildren().add(caminitoVertical);
        }

        Image meta = new Image("/meta.png",30,30,true,true);
        ImageView metaView = new ImageView(meta);
        metaView.setX(SCREEN_WIDTH / 2 - mapa.getWidth()/2 +  (posicionMeta.columna)* MULTIPLICADOR);
        metaView.setY(SCREEN_HEIGHT / 2 - mapa.getHeight()/2 + (posicionMeta.fila)* MULTIPLICADOR);
        layout.getChildren().add(metaView);



        //agregar los obtaculo

        for (int i = 0; i < 20; i++){

            GeneradorRandom generadorRandom = new GeneradorRandom();
            Camino camino = new Camino(generadorRandom.generarEsquina(limite), generadorRandom.generarDireccion());
            Obstaculo obtaculo = generadorRandom.generarObstaculo();
            camino.agregrarEfecto(obtaculo);
            juego.agregarCamino(camino);
            ObtaculoView obtaculoView = new ObtaculoView(layout,mapa,camino);
            obtaculo.mostrarImagen(obtaculoView);

        }

        //agregar las sorpresas

        for (int i = 0; i < 20 ; i++){
            GeneradorRandom generadorRandom = new GeneradorRandom();
            Camino camino = new Camino(generadorRandom.generarEsquina(limite), generadorRandom.generarDireccion());
            Sorpresa sorpresa = generadorRandom.generarSorpresa();
            camino.agregrarEfecto(sorpresa);
            juego.agregarCamino(camino);
        }

        mostrarSorpresas(juego,layout,mapa);


        VehiculoView vehiculoView = new VehiculoView(juego.obtenerVehiculo(), layout, mapa);

        Text movimientos = new Text(100,100,"Movimientos: " + juego.obtenerMovimientosRealizados());
        movimientos.setFont(Font.font(20));
        movimientos.setFill(Color.BLACK);
        layout.getChildren().add(movimientos);




        var scene = new Scene(layout, SCREEN_WIDTH, SCREEN_HEIGHT);


        stage.setScene(scene);
        stage.show();

        leerInputs(scene,juego,vehiculoView,stage,movimientos);
    }


    @Override
    public void handle(KeyEvent event){
        System.out.println(event.getCode().isArrowKey());
    }

    public static void main(String[] args) {
        launch();
    }

    private void leerInputs(Scene scene, Juego juego, VehiculoView vehiculoView, Stage stage, Text movimientos){
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

            movimientos.setText("Movimientos: " + juego.obtenerMovimientosRealizados());
        });

    }

    private void mostrarSorpresas(Juego juego, Group layout, Rectangle mapa){

        ListadoCaminos caminosConEfectos = juego.obtenerCaminos();

        for (Camino camino : caminosConEfectos.caminosConEfectos) {

            for(Sorpresa sorpresa : camino.sospresas) {
                SorpresaView sorpresaView = new SorpresaView(layout,mapa,camino);
                sorpresaView.mostrarImagen();
            }
        }
    }


}