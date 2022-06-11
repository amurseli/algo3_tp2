package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.efectos.Efecto;

import java.util.ArrayList;

public class ListadoCaminos {

    //creo que seria mas apropiado que se llame listado de camions CON EFECTOS
    private ArrayList<Camino> todosLosCaminos;

    public ListadoCaminos(){
        todosLosCaminos = new ArrayList<>();
    }

    public void agregarCaminoConEfecto(Camino nuevoCamino, Efecto nuevoEfecto){
        nuevoCamino.agregrarEfecto(nuevoEfecto);
        todosLosCaminos.add(nuevoCamino);
    }
    public Camino obtenerCaminoRecorrido(Camino caminoRecorrido){
        Camino caminoConEfecto = null;
        for (Camino camino : todosLosCaminos) {
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
