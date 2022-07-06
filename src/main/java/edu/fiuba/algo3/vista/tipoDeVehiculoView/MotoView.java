package edu.fiuba.algo3.vista.tipoDeVehiculoView;

import edu.fiuba.algo3.modelo.vehiculos.singletons.MotoSingleton;
import edu.fiuba.algo3.vista.VehiculoView;
import javafx.scene.image.Image;

import java.util.Observable;
import java.util.Observer;

public class MotoView implements Observer {
    VehiculoView vehiculoView;
    public MotoView(VehiculoView vehiculoView){
        this.vehiculoView = vehiculoView;
        MotoSingleton.obtenerInstancia().addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Image image = new Image("/auto.png", 20, 40,true,false);
        vehiculoView.vehiculoView.setImage(image);
    }
}
