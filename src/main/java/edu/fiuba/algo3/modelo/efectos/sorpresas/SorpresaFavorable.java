package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;


public class SorpresaFavorable extends Sorpresa {
    final double porcentaje = -0.2;
    public void aplicarEfecto(Vehiculo vehiculo, Auto auto) {
        vehiculo.aplicarPorcentaje(porcentaje);
    }

    public void aplicarEfecto(Vehiculo vehiculo, Moto moto) {
        vehiculo.aplicarPorcentaje(porcentaje);
    }

    public void aplicarEfecto(Vehiculo vehiculo, CuatroPorCuatro cuatroPorCuatro) {
        vehiculo.aplicarPorcentaje(porcentaje);
    }
}
