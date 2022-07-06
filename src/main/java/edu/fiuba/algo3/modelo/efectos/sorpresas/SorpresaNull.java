package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.ObservadorPersonalizado.ManejadorDeObservablesEfectos;
import edu.fiuba.algo3.modelo.ObservadorPersonalizado.ObservadorEfectos;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class SorpresaNull extends ManejadorDeObservablesEfectos implements Sorpresa {


    @Override
    public void aplicarEfecto(Vehiculo vehiculo) {}

    @Override
    public void confirmarAgregacion() {
        notificar(this);

    }

    @Override
    public void observar(ObservadorEfectos observadorEfectos) {
        addObservador(observadorEfectos);

    }
}
