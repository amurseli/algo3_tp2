package edu.fiuba.algo3.modelo.efectos;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.Jugador;

public abstract class Efecto {
    private Camino posicion;

    protected Efecto(Camino c) {
        this.posicion = c;
    }

    public abstract boolean aplicarEfecto(Jugador j);

    public Camino obtenerPosicion(){
        return posicion;
    }
}
