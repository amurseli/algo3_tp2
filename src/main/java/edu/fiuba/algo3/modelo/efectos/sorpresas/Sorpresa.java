package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.ObservadorSorpresa;
import edu.fiuba.algo3.modelo.ObservadorTipoVehiculo;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public interface Sorpresa {

    public abstract void aplicarEfecto(Vehiculo vehiculo);

    void observar(ObservadorSorpresa unObservador);

}
