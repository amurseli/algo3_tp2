package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Observable;

public class Ranking extends Observable {

    public static final int MAXIMA_CANTIDAD_DE_JUGADORES_EN_EL_RANKING = 10;
    public ArrayList<Puntaje> puntajes;

    Ranking(){
        puntajes = new ArrayList<>();
    }

    public void agregarPuntaje(Puntaje nuevoPuntaje){
        int i = 0;
        while (i < puntajes.size() && puntajes.get(i).comparar(nuevoPuntaje) < 0) {
            i++;
        }
        if (i < puntajes.size()) {
            puntajes.add(i, nuevoPuntaje);
            return;
        }
        puntajes.add(nuevoPuntaje);

        if (puntajes.size() > MAXIMA_CANTIDAD_DE_JUGADORES_EN_EL_RANKING){
            puntajes.remove(puntajes.size()-1);
        }

        setChanged();
        notifyObservers();
    }

    public boolean compararPuntaje(Puntaje puntaje, int index) {
        return puntajes.get(index).equals(puntaje);
    }

}
