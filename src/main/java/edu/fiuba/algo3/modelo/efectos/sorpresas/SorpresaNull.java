package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.ManejadorDeObservables;
import edu.fiuba.algo3.modelo.ManejadorDeObservablesSorpresa;
import edu.fiuba.algo3.modelo.ObservadorSorpresa;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class SorpresaNull extends ManejadorDeObservablesSorpresa implements Sorpresa {
    @Override
    public void aplicarEfecto(Vehiculo vehiculo) {}

    @Override
    public void observar(ObservadorSorpresa unObservador) {
        addObservador(unObservador);
    }
}
