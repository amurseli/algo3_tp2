package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.ObserverPersonalizado.ObservadorTipoVehiculo;
import edu.fiuba.algo3.modelo.vehiculos.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TipoVehiculoView implements ObservadorTipoVehiculo {

    Image imagen;
    VehiculoView paraAcceder;

    public TipoVehiculoView(Vehiculo vehiculo, VehiculoView view){
        TipoVehiculo estado = vehiculo.obtenerEstadoVehiculo();
        estado.observar(this);
        paraAcceder = view;
        imagen = new Image("/auto.png", 20, 40,true,false);
        paraAcceder.vehiculoView = new ImageView(imagen);
        paraAcceder.vehiculoView.setRotate(270);
    }
    @Override
    public void actualizar(Moto unaMoto) {
        imagen = new Image("/moto.png", 20, 40,true,false);
        unaMoto.observar(this);
        agregarAciew();
    }
    public void actualizar(Auto unAuto) {
        imagen = new Image("/auto.png", 20, 40,true,false);
        unAuto.observar(this);
        agregarAciew();
    }
    public void actualizar(CuatroPorCuatro unCuatroPorCuatro) {
        imagen = new Image("/cuatroPorCuatro.png", 20, 40,true,false);
        unCuatroPorCuatro.observar(this);
        agregarAciew();
    }

    public void agregarAciew(){
        paraAcceder.vehiculoView.setImage(imagen);
    }


}
