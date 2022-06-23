package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.vehiculos.*;

public class CambioDeVehiculo implements Sorpresa {

    public void aplicarEfecto(Vehiculo vehiculo, Auto auto) {
        vehiculo.cambiarTipo();
    }

    public void aplicarEfecto(Vehiculo vehiculo, Moto moto) {
        vehiculo.cambiarTipo();
    }

    public void aplicarEfecto(Vehiculo vehiculo){
        vehiculo.cambiarTipo();
    }
}
