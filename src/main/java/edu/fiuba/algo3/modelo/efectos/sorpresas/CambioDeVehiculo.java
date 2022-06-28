package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.vehiculos.*;

public class CambioDeVehiculo implements Sorpresa {
    public void aplicarEfecto(Vehiculo vehiculo){
        vehiculo.cambiarTipo();
    }
}
