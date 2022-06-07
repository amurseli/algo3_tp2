package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Efecto;

public class Obstaculo extends Efecto {

    protected Obstaculo(Camino c) {
        super(c);
    }

    @Override
    public boolean aplicarEfecto(Jugador j) {
        return false;
    }
}
