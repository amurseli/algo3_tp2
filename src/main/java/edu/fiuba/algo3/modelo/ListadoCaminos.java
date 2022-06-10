package edu.fiuba.algo3.modelo;

import java.util.List;

public class ListadoCaminos {
    List<Camino> todosLosCaminos;

    public Camino obtenerCaminoRecorrido(Camino caminoRecorrido){
        Camino caminoConEfecto = null;
        for (Camino camino : todosLosCaminos) {
            if (caminoRecorrido.equals(camino)) {
                caminoConEfecto = camino;
            }
        }
        return caminoConEfecto;
    }
}
