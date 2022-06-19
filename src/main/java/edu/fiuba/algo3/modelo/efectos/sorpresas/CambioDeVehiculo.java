package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class CambioDeVehiculo extends Sorpresa {

    public void aplicarEfecto(Vehiculo vehiculo, Auto auto) {
        vehiculo.cambiarTipo();
    }

    public void aplicarEfecto(Vehiculo vehiculo, Moto moto) {
        vehiculo.cambiarTipo();
    }

    public void aplicarEfecto(Vehiculo vehiculo, CuatroPorCuatro cuatroPorCuatro){
        vehiculo.cambiarTipo();
    }
}
