package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.GeneradoresRandom.GeneradorRandomSorpresas;
import edu.fiuba.algo3.modelo.ObserverPersonalizado.ObservadorSorpresa;
import edu.fiuba.algo3.modelo.efectos.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaFavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaNull;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import static edu.fiuba.algo3.App.MULTIPLICADOR;

public class SorpresaView implements ObservadorSorpresa {

    public static final int ANCHO_PANTALLA = 1620;
    public static final int ALTO_PANTALLA = 720;
    public static final int DESFASE = 5;
    public static final int ANCHO_SORPRESA = 20;
    public static final int ALTO_SORPRESA = 40;
    Image imagen;

    ImageView sorpresaImageView;
    SorpresaView(Camino unCamino, Group layout, Rectangle mapa){
        GeneradorRandomSorpresas generadorRandomObservar = unCamino.obtenerGeneradorDeRandomSorpresas();
        generadorRandomObservar.addObservador(this);
        imagen = new Image("/vacio.png", ANCHO_SORPRESA, ALTO_SORPRESA,true,false);
        sorpresaImageView = new ImageView(imagen);
        sorpresaImageView.setX(ANCHO_PANTALLA /2 - mapa.getWidth()/2 - DESFASE +  (unCamino.esquinaInicial.columna * MULTIPLICADOR + unCamino.esquinaFinal.columna*MULTIPLICADOR) / 2);
        sorpresaImageView.setY(ALTO_PANTALLA /2 - mapa.getHeight()/2 - DESFASE + (unCamino.esquinaInicial.fila * MULTIPLICADOR + unCamino.esquinaFinal.fila*MULTIPLICADOR) / 2);
        layout.getChildren().add(sorpresaImageView);
        unCamino.agregrarSorpresa();

    }
    @Override
    public void actualizar(SorpresaFavorable unSorpresaFavorable) {
        imagen =  new Image("/sorpresa.png", ANCHO_SORPRESA, ALTO_SORPRESA,true,false);
        setImagen();
    }

    @Override
    public void actualizar(SorpresaDesfavorable unSorpresaDesfavorable) {
        imagen =  new Image("/sorpresa.png", ANCHO_SORPRESA, ALTO_SORPRESA,true,false);
        setImagen();
    }

    @Override
    public void actualizar(CambioDeVehiculo unCambioDeVehiculo) {
        imagen =  new Image("/sorpresa.png", ANCHO_SORPRESA, ALTO_SORPRESA,true,false);
        setImagen();
    }

    @Override
    public void actualizar(SorpresaNull unSorpresaNull) {
        imagen =  new Image("/vacio.png", ANCHO_SORPRESA, ALTO_SORPRESA,true,false);
        setImagen();
    }

    public void setImagen(){
        sorpresaImageView.setImage(imagen);
    }

    public void sorpresaUsada(){
        imagen =  new Image("/vacio.png", ANCHO_SORPRESA, ALTO_SORPRESA,true,false);
        setImagen();
    }
}
