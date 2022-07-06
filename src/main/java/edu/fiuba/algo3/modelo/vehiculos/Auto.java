package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.vehiculos.singletons.CuatroPorCuatroSingleton;

import java.util.Observable;

public class Auto extends Observable implements TipoVehiculo {
    @Override
    public TipoVehiculo cambiarVehiculo(){
        setChanged();
        notifyObservers();
        return CuatroPorCuatroSingleton.obtenerInstancia();
    }

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Sorpresa sorpresas) {
        sorpresas.aplicarEfecto(vehiculo);
    }

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Obstaculo obstaculos) {
        obstaculos.aplicarEfecto(vehiculo, this);
    }
}
