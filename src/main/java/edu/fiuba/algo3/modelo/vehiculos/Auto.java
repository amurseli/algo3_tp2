package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.ObserverPersonalizado.ManejadorDeObservablesTipoVehiculo;
import edu.fiuba.algo3.modelo.ObserverPersonalizado.ObservadorTipoVehiculo;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;

public class Auto extends ManejadorDeObservablesTipoVehiculo implements TipoVehiculo {
    @Override
    public TipoVehiculo cambiarVehiculo(){
        CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
        notificar(cuatroPorCuatro);
        return cuatroPorCuatro;
    }

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Sorpresa sorpresas) {
        sorpresas.aplicarEfecto(vehiculo);
    }

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Obstaculo obstaculos) {
        obstaculos.aplicarEfecto(vehiculo, this);
    }

    @Override
    public void observar(ObservadorTipoVehiculo unObservador) {
        addObservador(unObservador);
    }

}
