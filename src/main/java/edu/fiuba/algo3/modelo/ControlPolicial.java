package edu.fiuba.algo3.modelo;

public class ControlPolicial extends Efecto {

    protected ControlPolicial(Camino c) {
        super(c);
    }

    @Override
    public boolean aplicarEfecto(Jugador j) {
        return false;
    }
}
