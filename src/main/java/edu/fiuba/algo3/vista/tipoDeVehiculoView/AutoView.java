package edu.fiuba.algo3.vista.tipoDeVehiculoView;

import edu.fiuba.algo3.modelo.vehiculos.singletons.AutoSingleton;
import edu.fiuba.algo3.vista.VehiculoView;
import javafx.scene.image.Image;

import java.util.Observable;
import java.util.Observer;

public class AutoView implements Observer {

    VehiculoView vehiculoView;
    public AutoView(VehiculoView vehiculoView){
        this.vehiculoView = vehiculoView;
        AutoSingleton.obtenerInstancia().addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Image image = new Image("/cuatroPorCuatro.png", 50, 40,true,false);
        vehiculoView.vehiculoView.setImage(image);
    }

}
