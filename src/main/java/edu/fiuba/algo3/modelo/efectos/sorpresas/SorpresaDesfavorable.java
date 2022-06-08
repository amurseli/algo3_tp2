package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class SorpresaDesfavorable extends Sorpresa {
    protected SorpresaDesfavorable(Camino c) {
        super(c);
    }

    public void aplicarEfecto(Camino caminoRecorrido, Jugador jugador, Vehiculo vehiculo) {
        int estoEsParaSalirDelPaso = 5;
    }
}
