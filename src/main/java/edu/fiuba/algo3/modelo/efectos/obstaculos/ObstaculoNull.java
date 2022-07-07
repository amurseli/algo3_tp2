package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.ObserverPersonalizado.ManejadorDeObservablesObstaculos;
import edu.fiuba.algo3.modelo.ObserverPersonalizado.ObservadorObstaculo;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class ObstaculoNull extends ManejadorDeObservablesObstaculos implements Obstaculo{
    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Auto auto) {

    }

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Moto moto) {

    }

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, CuatroPorCuatro cuatroPorCuatro) {

    }

    @Override
    public void observar(ObservadorObstaculo unObservador) {addObservador(unObservador);

    }


}
