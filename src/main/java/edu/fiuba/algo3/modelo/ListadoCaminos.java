package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Observable;

public class ListadoCaminos {

    //creo que seria mas apropiado que se llame listado de camions CON EFECTOS
    public ArrayList<Camino> caminosConEfectos;

    public ListadoCaminos(){
        caminosConEfectos = new ArrayList<>();
    }

    public void agregarCamino(Camino nuevoCamino){

        if (comprobarSiCaminoExiste(nuevoCamino)){
            caminosConEfectos.add(nuevoCamino);
        }
    }

    private boolean comprobarSiCaminoExiste(Camino nuevoCamino){

        for (Camino camino:caminosConEfectos) {
            if(camino.equals(nuevoCamino)){
                return false;
            }
        }
        return true;

    }
    public Camino obtenerCaminoRecorrido(Camino caminoRecorrido){
        Camino caminoConEfecto = null;
        for (Camino camino : caminosConEfectos) {
            if (caminoRecorrido.equals(camino)) {
                caminoConEfecto = camino;
            }
        }
        if (caminoConEfecto != null) {
            return caminoConEfecto;
        }
        return caminoRecorrido;
    }
}
