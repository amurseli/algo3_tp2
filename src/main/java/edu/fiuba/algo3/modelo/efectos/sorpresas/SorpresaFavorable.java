package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.ObservadorPersonalizado.ManejadorDeObservablesEfectos;
import edu.fiuba.algo3.modelo.ObservadorPersonalizado.ObservadorEfectos;
import edu.fiuba.algo3.modelo.vehiculos.*;


public class SorpresaFavorable extends ManejadorDeObservablesEfectos implements Sorpresa {
    final double porcentaje = -0.2;

    public void aplicarEfecto(Vehiculo vehiculo){
        vehiculo.aplicarPorcentaje(porcentaje);
    }

    @Override
    public void confirmarAgregacion() {
        notificar(this);

    }

    @Override
    public void observar(ObservadorEfectos observadorEfectos) {
        addObservador(observadorEfectos);

    }

}
