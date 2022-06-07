package edu.fiuba.algo3.modelo;

public class Pozo extends Efecto {

    protected Pozo(Camino c) {
        super(c);
    }

    @Override
    public boolean aplicarEfecto(Jugador j) {
        j.aplicarEfecto(this);
        return false;
    }
}
