package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.ManejadorDeObservablesSorpresa;
import edu.fiuba.algo3.modelo.ObservadorSorpresa;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class SorpresaDesfavorable extends ManejadorDeObservablesSorpresa implements Sorpresa {
    final double porcentaje = 0.25;
    public void aplicarEfecto(Vehiculo vehiculo) {
        vehiculo.aplicarPorcentaje(porcentaje);
    }

    @Override
    public void observar(ObservadorSorpresa unObservador) {
        addObservador(unObservador);
    }
}
