package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.efectos.Efecto;

public class Auto implements TipoVehiculo {
    @Override
    public TipoVehiculo cambiarVehiculo(){
        return new CuatroPorCuatro();
    }

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Efecto efecto) {
        efecto.aplicarEfecto(vehiculo, this);
    }
}
