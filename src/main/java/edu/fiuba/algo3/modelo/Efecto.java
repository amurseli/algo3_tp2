package edu.fiuba.algo3.modelo;

public abstract class Efecto {
    private Camino posicion;

    protected Efecto(Camino c) {
        this.posicion = c;
    }

    public abstract boolean aplicarEfecto(Jugador j);
}
