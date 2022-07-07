package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Ranking;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Observable;
import java.util.Observer;

public class RankingView implements Observer {

    public static final int FONDO_RANKING_X = 100;
    public static final int FONDO_RANKING_Y = 100;
    public static final int FONDO_RANKING_ANCHO = 210;
    public static final int FONDO_RANKING_ALTO = 320;
    public static final int STROKE_WIDTH = 5;
    public static final int TITULO_X = 110;
    public static final int TITULO_Y = 140;
    public static final int SIZE_FONT = 30;
    public static final int SIZE_FONT_PUNTAJE = 20;
    public static final int PUNTAJE_X = 110;
    public static final int PUNTAJE_Y = 160;
    public static final int SEPARACION = 20;
    Ranking ranking;
    Group layout;

    RankingView(Ranking ranking, Group layout){
        this.ranking = ranking;
        this.layout = layout;
        this.ranking.addObserver(this);
        dibujarFondoRanking(layout);
        actualizarRanking(layout);
    }

    private void dibujarFondoRanking(Group layout){
        Rectangle fondoRanking = new Rectangle(FONDO_RANKING_X, FONDO_RANKING_Y, FONDO_RANKING_ANCHO, FONDO_RANKING_ALTO);
        fondoRanking.setFill(Color.WHITE);
        fondoRanking.setStroke(Color.SALMON);
        fondoRanking.setStrokeWidth(STROKE_WIDTH);
        layout.getChildren().add(fondoRanking);

        Text titulo = new Text(TITULO_X, TITULO_Y,"Highscores: ");
        titulo.setFont(Font.font(SIZE_FONT));
        layout.getChildren().add(titulo);
    }
    private void actualizarRanking(Group layout){
        int i = SEPARACION;

        for (Puntaje puntaje : ranking.puntajes){
            Text nuevoPuntajeTexto = new Text(PUNTAJE_X, PUNTAJE_Y + i,puntaje.getNombre()+": " + puntaje.getMovimientos() + "\n");
            nuevoPuntajeTexto.setFont(Font.font(SIZE_FONT_PUNTAJE));
            nuevoPuntajeTexto.setFill(Color.BLACK);
            layout.getChildren().add(nuevoPuntajeTexto);
            i+= SEPARACION;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        actualizarRanking(layout);
    }
}
