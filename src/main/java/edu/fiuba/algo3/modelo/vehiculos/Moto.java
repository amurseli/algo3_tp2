package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.efectos.Efecto;

public class Moto extends Vehiculo {
    public Moto(Esquina posicion) {
        super(posicion);
    }

    @Override
    public void aplicarEfecto(Jugador jugador, Efecto efecto) {
        efecto.aplicarEfecto(jugador, this);
    }

    public Moto(Esquina posicion, Esquina posicionAnterior, int movimientos) {
        super(posicion, posicionAnterior, movimientos);
    }

    public Vehiculo cambiarVehiculo(){
        return new Auto(posicion,posicionAnterior,movimientos);
    }

}
