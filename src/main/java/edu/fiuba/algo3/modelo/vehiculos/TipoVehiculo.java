package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.efectos.Efecto;

public interface TipoVehiculo {
    TipoVehiculo cambiarVehiculo();
    void aplicarEfecto(Vehiculo vehiculo, Efecto efecto);
}
