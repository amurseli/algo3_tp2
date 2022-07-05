package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Observable;

public class Ranking extends Observable {

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

        setChanged();
        notifyObservers();
    }

    public boolean compararPuntaje(Puntaje puntaje, int index) {
        return puntajes.get(index).equals(puntaje);
    }

}
