package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.efectos.obstaculos.*;
import edu.fiuba.algo3.modelo.efectos.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaFavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaNull;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.Observable;
import java.util.Observer;

import static edu.fiuba.algo3.App.MULTIPLICADOR;

public class CaminoView implements Observer {

    Camino camino;
    Group layout;
    Rectangle mapa;

    SorpresaView sorpresaView;

    ObstaculoView obstaculoView;


    public CaminoView(Camino camino, Group layout, Rectangle mapa){
        this.layout = layout;
        this.mapa = mapa;
        this.camino = camino;
        this.camino.addObserver(this);

        obstaculoView = new ObstaculoView(camino,layout,mapa);
        sorpresaView = new SorpresaView(camino,layout,mapa);

    }

    @Override
    public void update(Observable o, Object arg) {
        sorpresaView.sorpresaUsada();
    }

}

