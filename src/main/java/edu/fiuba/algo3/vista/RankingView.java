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
        Rectangle fondoRanking = new Rectangle(100,100,200,500);
        fondoRanking.setFill(Color.WHITE);
        fondoRanking.setStroke(Color.SALMON);
        fondoRanking.setStrokeWidth(5);
        layout.getChildren().add(fondoRanking);

        Text titulo = new Text(110,150,"Highscores: ");
        titulo.setFont(Font.font(30));
        layout.getChildren().add(titulo);
    }
    private void actualizarRanking(Group layout){
        int i = 20;

        for (Puntaje puntaje : ranking.puntajes){
            Text nuevoPuntajeTexto = new Text(110,160 + i,puntaje.getNombre()+": " + puntaje.getMovimientos() + "\n");
            nuevoPuntajeTexto.setFont(Font.font(20));
            nuevoPuntajeTexto.setFill(Color.BLACK);
            layout.getChildren().add(nuevoPuntajeTexto);
            i+= 20;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        actualizarRanking(layout);
    }
}
