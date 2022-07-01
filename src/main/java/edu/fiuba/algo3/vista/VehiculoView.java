package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Esquina;
import edu.fiuba.algo3.modelo.vehiculos.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class VehiculoView {


    public static final int MULTIPLICADOR = 50;
    public static final int ANCHO_PANTALLA = 1620;
    public static final int ALTO_PANTALLA = 720;
    Image estado;

    Image fondoNegro;

    double inicioX;
    double inicioY;

    ImageView vehiculoView;

    ImageView fondoNegroView;



    public VehiculoView(Vehiculo vehiculo, Group layout, Rectangle mapa){


        estado = new Image("/auto.png", 20, 40,true,false);
        fondoNegro = new Image("/fondoNegro.png",1800,1800,true,false);
        fondoNegroView = new ImageView(fondoNegro);

        vehiculoView = new ImageView(estado);
        vehiculoView.setRotate(270);

        inicioX = ANCHO_PANTALLA/2 - mapa.getWidth()/2;
        inicioY = ALTO_PANTALLA /2 - mapa.getHeight()/2;

        vehiculoView.setX(inicioX + vehiculo.obtenerPosicion().columna * MULTIPLICADOR);
        vehiculoView.setY(inicioY + vehiculo.obtenerPosicion().fila * MULTIPLICADOR);
        fondoNegroView.setX(inicioX + vehiculo.obtenerPosicion().columna * MULTIPLICADOR - 1800/2);
        fondoNegroView.setY(inicioY + vehiculo.obtenerPosicion().fila * MULTIPLICADOR - 1800/2);
        layout.getChildren().add(vehiculoView);
        layout.getChildren().add(fondoNegroView);

    }

    public void actualizarPosicion(Vehiculo vehiculo, int orientation){
        vehiculoView.setX(inicioX + vehiculo.obtenerPosicion().getColumna() * MULTIPLICADOR);
        vehiculoView.setY(inicioY + vehiculo.obtenerPosicion().getFila() * MULTIPLICADOR);
        vehiculoView.setRotate(orientation);
        fondoNegroView.setX(inicioX + vehiculo.obtenerPosicion().columna * MULTIPLICADOR - 1800/2);
        fondoNegroView.setY(inicioY + vehiculo.obtenerPosicion().fila * MULTIPLICADOR - 1800/2);
        actualizarImagen(vehiculo.obtenerTipoVehiculo());
    }

    public void actualizarImagen(Object tipoVehiculo){
        //TODO: CAMBIAAAAAR, HICE ESTO SOLO PARA PROBAR SI ANDABAN BIEN ACTUALIZAR LAS IMAGENES

        System.out.println(tipoVehiculo);

        if (tipoVehiculo == Moto.class){
            estado =  new Image("/moto.png", 20, 40,true,false);
        }
        if (tipoVehiculo == Auto.class){
            estado =  new Image("/auto.png", 20, 40,true,false);
        }
        if (tipoVehiculo == CuatroPorCuatro.class){
            estado =  new Image("/cuatroPorCuatro.png", 20, 40,true,false);
        }

        vehiculoView.setImage(estado);

    }


}
