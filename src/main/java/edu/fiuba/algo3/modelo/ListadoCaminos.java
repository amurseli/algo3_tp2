package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ListadoCaminos {

    //creo que seria mas apropiado que se llame listado de camions CON EFECTOS
    public ArrayList<Camino> caminosConEfectos;

    public ListadoCaminos(){

        caminosConEfectos = new ArrayList<>();
    }

    public void agregarCamino(Camino nuevoCamino){

        if (!caminoExiste(nuevoCamino)){
            caminosConEfectos.add(nuevoCamino);
        }
    }


    // publico para testeo
    public boolean caminoExiste(Camino nuevoCamino){

        for (Camino camino:caminosConEfectos) {
            if(camino.equals(nuevoCamino)){
                return true;
            }
        }
        return false;

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
