package edu.fiuba.algo3.vista.tipoDeVehiculoView;

import edu.fiuba.algo3.modelo.vehiculos.singletons.CuatroPorCuatroSingleton;
import edu.fiuba.algo3.vista.VehiculoView;
import javafx.scene.image.Image;

import java.util.Observable;
import java.util.Observer;

public class CuatroPorCuatroView implements Observer {

    VehiculoView vehiculoView;
    public CuatroPorCuatroView(VehiculoView vehiculoView){
        this.vehiculoView = vehiculoView;
        CuatroPorCuatroSingleton.obtenerInstancia().addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Image image = new Image("/moto.png", 20, 40,true,false);
        vehiculoView.vehiculoView.setImage(image);
    }


}
