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

    Image sorpresaImage;
    Image obstaculoImage;

    ImageView sorpresaImageView;

    ImageView obstaculoImageView;

    public CaminoView(Camino camino, Group layout, Rectangle mapa){
        this.layout = layout;
        this.mapa = mapa;
        this.camino = camino;
        this.camino.addObserver(this);

        sorpresaImage = new Image("/vacio.png", 20, 40,true,false);
        sorpresaImageView = new ImageView(sorpresaImage);
        sorpresaImageView.setX(1620/2 - mapa.getWidth()/2 - 5 +  (camino.esquinaInicial.columna * MULTIPLICADOR + camino.esquinaFinal.columna*MULTIPLICADOR) / 2);
        sorpresaImageView.setY(720/2 - mapa.getHeight()/2 - 5 + (camino.esquinaInicial.fila * MULTIPLICADOR + camino.esquinaFinal.fila*MULTIPLICADOR) / 2);
        layout.getChildren().add(sorpresaImageView);

        obstaculoImage =  new Image("/vacio.png", 20, 40,true,false);
        obstaculoImageView = new ImageView(obstaculoImage);
        obstaculoImageView.setX(1620/2 - mapa.getWidth()/2 - 5 +  (camino.esquinaInicial.columna * MULTIPLICADOR + camino.esquinaFinal.columna*MULTIPLICADOR) / 2);
        obstaculoImageView.setY(720/2 - mapa.getHeight()/2 - 5 + (camino.esquinaInicial.fila * MULTIPLICADOR + camino.esquinaFinal.fila*MULTIPLICADOR) / 2);
        layout.getChildren().add(obstaculoImageView);

        actualizarObstaculo(camino.obstaculo);
        actualizarSorpresa(camino.sorpresa);


    }

    @Override
    public void update(Observable o, Object arg) {
        actualizarObstaculo(camino.obstaculo);
        actualizarSorpresa(camino.sorpresa);
    }

    private void actualizarSorpresa(Sorpresa sorpresa){

        if (sorpresa.getClass() == SorpresaFavorable.class){
            sorpresaImage =  new Image("/sorpresa.png", 20, 40,true,false);
        }
        if (sorpresa.getClass() == SorpresaFavorable.class){
            sorpresaImage =  new Image("/sorpresa.png", 20, 40,true,false);
        }
        if (sorpresa.getClass() == CambioDeVehiculo.class){
            sorpresaImage =  new Image("/sorpresa.png", 20, 40,true,false);
        }
        if (sorpresa.getClass() == SorpresaNull.class){
            sorpresaImage =  new Image("/vacio.png", 20, 40,true,false);
        }

        sorpresaImageView.setImage(sorpresaImage);
    }

    private void actualizarObstaculo(Obstaculo obstaculo){


        if (obstaculo.getClass() == Pozo.class){
            obstaculoImage =  new Image("/pozo.png", 20, 40,true,false);
        }
        if (obstaculo.getClass() == Piquete.class){
            obstaculoImage =  new Image("/piquete.png", 20, 40,true,false);
        }

        if (obstaculo.getClass() == ControlPolicial.class){
            obstaculoImage =  new Image("/policia.png", 20, 40,true,false);
        }
        if (obstaculo.getClass() == ObstaculoNull.class){
            obstaculoImage =  new Image("/vacio.png", 20, 40,true,false);
        }

        obstaculoImageView.setImage(obstaculoImage);
    }


    void crearImageView(Image efecto){
        ImageView efectoView = new ImageView(efecto);
        efectoView.setX(1620/2 - mapa.getWidth()/2 - 5 +  (camino.esquinaInicial.columna * MULTIPLICADOR + camino.esquinaFinal.columna*MULTIPLICADOR) / 2);
        efectoView.setY(720/2 - mapa.getHeight()/2 - 5 + (camino.esquinaInicial.fila * MULTIPLICADOR + camino.esquinaFinal.fila*MULTIPLICADOR) / 2);
        layout.getChildren().add(efectoView);
    }
}

