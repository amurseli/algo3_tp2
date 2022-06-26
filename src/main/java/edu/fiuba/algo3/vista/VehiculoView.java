package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.vehiculos.TipoVehiculo;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VehiculoView extends Node {


    Image estado;

    ImageView vehiculoView;

    public VehiculoView(Vehiculo vehiculo){

        estado = new Image("/auto.png", 20, 40,true,false);
        vehiculoView = new ImageView(estado);
        vehiculoView.setRotate(270);
        vehiculoView.setX(vehiculo.obtenerPosicion().columna);
        vehiculoView.setY(vehiculo.obtenerPosicion().fila);


    }

    public void ActualizarPosicion(int x,int y, int orientation){
        vehiculoView.setX(x);
        vehiculoView.setY(y);
        vehiculoView.setRotate(orientation);
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
