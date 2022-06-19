package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.efectos.Efecto;

public class Moto implements TipoVehiculo {
    @Override
    public TipoVehiculo cambiarVehiculo(){
        return new Auto();
    }

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Efecto efecto) {
        efecto.aplicarEfecto(vehiculo, this);
    }
}
