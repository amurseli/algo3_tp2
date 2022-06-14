package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.efectos.Efecto;

import java.util.ArrayList;

public class ListadoCaminos {

    //creo que seria mas apropiado que se llame listado de camions CON EFECTOS
    private ArrayList<Camino> caminos;

    public ListadoCaminos(){
        caminos = new ArrayList<>();
    }

    public void agregarCaminoConEfecto(Camino nuevoCamino, Efecto nuevoEfecto){
        boolean esNuevo = true;
        Camino camino = nuevoCamino;
        for (Camino c : caminos) {
            if (c.equals(nuevoCamino)) {
                esNuevo = false;
                camino = c;
            }
        }
        camino.agregrarEfecto(nuevoEfecto);
        if (esNuevo) caminos.add(camino);
    }
    public Camino obtenerCaminoRecorrido(Camino caminoRecorrido){
        Camino caminoConEfecto = null;
        for (Camino camino : caminos) {
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
