package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.ManejadorDeObservables;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;

import java.util.Observable;

public class Auto extends ManejadorDeObservables implements TipoVehiculo {
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
    public void observar(Observador unObservador) {
        addObservador(unObservador);
    }

}
