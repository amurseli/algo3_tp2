package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.efectos.Efecto;

public class Auto extends Vehiculo {
    public Auto(Esquina posicion) {
        super(posicion);
    }

    @Override
    public void aplicarEfecto(Jugador jugador, Efecto efecto) {
        efecto.aplicarEfecto(this);
    }

    //TODO: Para cuando tengamos las sorpresas hechas
    /*
    public Auto(Esquina posicion, Esquina posicionAnterior, int movimientos) {
        super(posicion, posicionAnterior, movimientos);
    }*/

}
