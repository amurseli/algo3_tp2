package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.vehiculos.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class VehiculoView implements Observer {

    public static final int MULTIPLICADOR = 50;
    public static final int ANCHO_PANTALLA = 1620;
    public static final int ALTO_PANTALLA = 720;
    public static final int FONDO_NEGRO_TAMANIO = 3000;
    Image estado;
    Image fondoNegro;
    double inicioX;
    double inicioY;
    public ImageView vehiculoView;
    ImageView fondoNegroView;
    Vehiculo vehiculo;


    public VehiculoView(Vehiculo vehiculo, Group layout, Rectangle mapa){

        TipoVehiculoView estadoVehiculo = new TipoVehiculoView(vehiculo,this);

        fondoNegro = new Image("/fondoNegro.png",FONDO_NEGRO_TAMANIO,FONDO_NEGRO_TAMANIO,true,false);
        fondoNegroView = new ImageView(fondoNegro);
        this.vehiculo = vehiculo;
        vehiculo.addObserver(this);

        inicioX = ANCHO_PANTALLA/2 - mapa.getWidth()/2;
        inicioY = ALTO_PANTALLA /2 - mapa.getHeight()/2;

        vehiculoView.setX(inicioX + vehiculo.obtenerPosicion().columna * MULTIPLICADOR);
        vehiculoView.setY(inicioY + vehiculo.obtenerPosicion().fila * MULTIPLICADOR - 10);
        fondoNegroView.setX(inicioX + vehiculo.obtenerPosicion().columna * MULTIPLICADOR - FONDO_NEGRO_TAMANIO/2);
        fondoNegroView.setY(inicioY + vehiculo.obtenerPosicion().fila * MULTIPLICADOR - FONDO_NEGRO_TAMANIO/2);
        layout.getChildren().add(vehiculoView);
        layout.getChildren().add(fondoNegroView);

    }

    public void actualizarPosicion(){
        vehiculoView.setX(inicioX + vehiculo.obtenerPosicion().getColumna() * MULTIPLICADOR);
        vehiculoView.setY(inicioY + vehiculo.obtenerPosicion().getFila() * MULTIPLICADOR -10);
        //vehiculoView.setRotate(orientation);
        fondoNegroView.setX(inicioX + vehiculo.obtenerPosicion().columna * MULTIPLICADOR - FONDO_NEGRO_TAMANIO/2);
        fondoNegroView.setY(inicioY + vehiculo.obtenerPosicion().fila * MULTIPLICADOR - FONDO_NEGRO_TAMANIO/2);
    }

    @Override
    public void update(Observable o, Object arg) {
        actualizarPosicion();
    }



}
