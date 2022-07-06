package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;

import java.util.Observable;
import java.util.Observer;

public interface TipoVehiculo {
    TipoVehiculo cambiarVehiculo();
    void aplicarEfecto(Vehiculo vehiculo, Sorpresa sospresas);

    void aplicarEfecto(Vehiculo vehiculo, Obstaculo obtaculos);

    void observar(Observador unObservador);
}
