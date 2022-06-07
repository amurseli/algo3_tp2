package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.Jugador;

public class Obstaculo extends Efecto {

    protected Obstaculo(Camino c) {
        super(c);
    }

    @Override
    public boolean aplicarEfecto(Jugador j) {
        return false;
    }
}
