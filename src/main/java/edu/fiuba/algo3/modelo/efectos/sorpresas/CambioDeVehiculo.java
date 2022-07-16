package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.ObserverPersonalizado.ManejadorDeObservablesSorpresa;
import edu.fiuba.algo3.modelo.ObserverPersonalizado.ObservadorSorpresa;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class CambioDeVehiculo extends ManejadorDeObservablesSorpresa implements Sorpresa {
    public void aplicarEfecto(Vehiculo vehiculo){
        vehiculo.cambiarTipo();
    }

    @Override
    public void observar(ObservadorSorpresa unObservador) {
        addObservador(unObservador);
    }
}
