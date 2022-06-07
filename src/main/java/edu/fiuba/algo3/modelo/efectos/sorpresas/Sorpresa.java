package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.Jugador;

public class Sorpresa extends Efecto {
    protected Sorpresa(Camino c) {
        super(c);
    }

    @Override
    public boolean aplicarEfecto(Jugador j) {
        return false;
    }
}
