package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.vehiculos.*;


public class SorpresaFavorable implements Sorpresa {
    final double porcentaje = -0.2;
    public void aplicarEfecto(Vehiculo vehiculo){
        vehiculo.aplicarPorcentaje(porcentaje);
    }

}
