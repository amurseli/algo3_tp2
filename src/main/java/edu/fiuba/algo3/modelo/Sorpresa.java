package edu.fiuba.algo3.modelo;

public class Sorpresa extends Efecto {
    protected Sorpresa(Camino c) {
        super(c);
    }

    @Override
    public boolean aplicarEfecto(Jugador j) {
        return false;
    }
}
