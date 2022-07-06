package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.ObservadorPersonalizado.ManejadorDeObservablesEfectos;
import edu.fiuba.algo3.modelo.ObservadorPersonalizado.ObservadorEfectos;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class CambioDeVehiculo extends ManejadorDeObservablesEfectos implements Sorpresa {

    public void aplicarEfecto(Vehiculo vehiculo){
        vehiculo.cambiarTipo();
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
