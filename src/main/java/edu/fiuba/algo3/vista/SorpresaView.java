package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import static edu.fiuba.algo3.App.MULTIPLICADOR;

public class SorpresaView {
    Group layout;
    Rectangle mapa;
    Camino camino;

    public SorpresaView(Group layout, Rectangle mapa, Camino camino){
        this.layout = layout;
        this.mapa = mapa;
        this.camino = camino;
    }
    public void mostrarImagen(){
        Image efecto = new Image("/sorpresa.png",30,30,true,false);
        crearImageView(efecto);
    }

    void crearImageView(Image efecto){
        ImageView efectoView = new ImageView(efecto);
        efectoView.setX(1620/2 - mapa.getWidth()/2 - 5 +  (camino.esquinaInicial.columna * MULTIPLICADOR + camino.esquinaFinal.columna*MULTIPLICADOR) / 2);
        efectoView.setY(720/2 - mapa.getHeight()/2 - 5 + (camino.esquinaInicial.fila * MULTIPLICADOR + camino.esquinaFinal.fila*MULTIPLICADOR) / 2);
        layout.getChildren().add(efectoView);
    }
}
