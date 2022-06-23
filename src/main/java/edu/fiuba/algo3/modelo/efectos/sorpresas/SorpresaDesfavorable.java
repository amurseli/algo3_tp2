package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.vehiculos.*;

public class SorpresaDesfavorable implements Sorpresa {
    final double porcentaje = 0.25;
    public void aplicarEfecto(Vehiculo vehiculo) {
        vehiculo.aplicarPorcentaje(porcentaje);
    }
}
