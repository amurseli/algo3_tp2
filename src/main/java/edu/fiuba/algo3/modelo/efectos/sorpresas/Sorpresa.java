package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Sorpresa extends Efecto {
    protected Sorpresa(Camino c) {
        super(c);
    }

    public void aplicarEfecto(Camino caminoRecorrido, Jugador jugador, Vehiculo vehiculo) {
        int estoEsParaSalirDelPaso = 5;
    }

}
