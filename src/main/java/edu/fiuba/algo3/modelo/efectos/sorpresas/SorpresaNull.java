package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.ObserverPersonalizado.ManejadorDeObservablesSorpresa;
import edu.fiuba.algo3.modelo.ObserverPersonalizado.ObservadorSorpresa;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class SorpresaNull extends ManejadorDeObservablesSorpresa implements Sorpresa {
    @Override
    public void aplicarEfecto(Vehiculo vehiculo) {}

    @Override
    public void observar(ObservadorSorpresa unObservador) {
        addObservador(unObservador);
    }
}
