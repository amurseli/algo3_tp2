package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.GeneradoresRandom.GeneradorRandomObstaculos;
import edu.fiuba.algo3.modelo.ObserverPersonalizado.ObservadorObstaculo;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ObstaculoNull;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import static edu.fiuba.algo3.App.MULTIPLICADOR;

public class ObstaculoView implements ObservadorObstaculo {


    public static final int ANCHO_PANTALLA = 1620;
    public static final int ALTO_PANTALLA = 720;
    public static final int DESFASE = 5;
    public static final int ANCHO_OBSTACULO = 20;
    public static final int ALTO_OBSTACULO = 40;
    Image imagen;

    ImageView obstaculoImageView;

    ObstaculoView(Camino unCamino, Group layout, Rectangle mapa){
        GeneradorRandomObstaculos generadorRandomObstaculos = unCamino.obtenerGeneradorRandomObstaculos();
        generadorRandomObstaculos.addObservador(this);
        imagen = new Image("/vacio.png", ANCHO_OBSTACULO, ALTO_OBSTACULO,true,false);
        obstaculoImageView = new ImageView(imagen);
        obstaculoImageView.setX(ANCHO_PANTALLA /2 - mapa.getWidth()/2 - DESFASE +  (unCamino.esquinaInicial.columna * MULTIPLICADOR + unCamino.esquinaFinal.columna*MULTIPLICADOR) / 2);
        obstaculoImageView.setY(ALTO_PANTALLA /2 - mapa.getHeight()/2 - DESFASE + (unCamino.esquinaInicial.fila * MULTIPLICADOR + unCamino.esquinaFinal.fila*MULTIPLICADOR) / 2);
        layout.getChildren().add(obstaculoImageView);
        unCamino.agregrarObstaculo();

    }
    @Override
    public void actualizar(Piquete piquete) {
        imagen =  new Image("/piquete.png", ANCHO_OBSTACULO, ALTO_OBSTACULO,true,false);
        setImagen();
    }

    @Override
    public void actualizar(ControlPolicial controlPolicial) {
        imagen =  new Image("/policia.png", ANCHO_OBSTACULO, ALTO_OBSTACULO,true,false);
        setImagen();
    }

    @Override
    public void actualizar(Pozo pozo) {
        imagen =  new Image("/pozo.png", ANCHO_OBSTACULO, ALTO_OBSTACULO,true,false);
        setImagen();
    }

    @Override
    public void actualizar(ObstaculoNull obstaculoNull) {
        imagen =  new Image("/vacio.png", ANCHO_OBSTACULO, ALTO_OBSTACULO,true,false);
        setImagen();
    }

    public void setImagen(){
        obstaculoImageView.setImage(imagen);
    }

}
