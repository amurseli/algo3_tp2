package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.ObservadorPersonalizado.ObservadorEfectos;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public interface Sorpresa {

    public abstract void aplicarEfecto(Vehiculo vehiculo);

    void confirmarAgregacion();
    void observar(ObservadorEfectos observadorEfectos);

}
