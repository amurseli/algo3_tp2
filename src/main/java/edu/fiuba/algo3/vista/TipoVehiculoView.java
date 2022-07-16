package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.ObserverPersonalizado.ObservadorTipoVehiculo;
import edu.fiuba.algo3.modelo.vehiculos.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TipoVehiculoView implements ObservadorTipoVehiculo {

    public static final int VEHICULO_ANCHO = 20;
    public static final int VEHICULO_ALTO = 40;
    public static final int ROTACION = 270;
    Image imagen;
    VehiculoView paraAcceder;

    public TipoVehiculoView(Vehiculo vehiculo, VehiculoView view){
        TipoVehiculo estado = vehiculo.obtenerEstadoVehiculo();
        estado.observar(this);
        paraAcceder = view;
        imagen = new Image("/auto.png", VEHICULO_ANCHO, VEHICULO_ALTO,true,false);
        paraAcceder.vehiculoView = new ImageView(imagen);
        paraAcceder.vehiculoView.setRotate(ROTACION);
    }
    @Override
    public void actualizar(Moto unaMoto) {
        imagen = new Image("/moto.png", VEHICULO_ANCHO, VEHICULO_ALTO,true,false);
        unaMoto.observar(this);
        agregarAciew();
    }
    public void actualizar(Auto unAuto) {
        imagen = new Image("/auto.png", VEHICULO_ANCHO, VEHICULO_ALTO,true,false);
        unAuto.observar(this);
        agregarAciew();
    }
    public void actualizar(CuatroPorCuatro unCuatroPorCuatro) {
        imagen = new Image("/cuatroPorCuatro.png", VEHICULO_ANCHO, VEHICULO_ALTO,true,false);
        unCuatroPorCuatro.observar(this);
        agregarAciew();
    }

    public void agregarAciew(){
        paraAcceder.vehiculoView.setImage(imagen);
    }


}
