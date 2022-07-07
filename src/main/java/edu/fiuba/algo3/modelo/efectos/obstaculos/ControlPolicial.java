package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.GeneradoresRandom.GeneradorRandom;
import edu.fiuba.algo3.modelo.ObserverPersonalizado.ManejadorDeObservablesObstaculos;
import edu.fiuba.algo3.modelo.ObserverPersonalizado.ObservadorObstaculo;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class ControlPolicial extends ManejadorDeObservablesObstaculos implements Obstaculo {
    public static final int MIN = 1;
    public static final int MAX = 10;
    public static final int PENALIZACION = 3;
    public static final int AUTO_PORCENTAJE = 3;
    public static final int MOTO_PORCENTAJE = 8;
    public static final int CUATRO_POR_CUATRO_PORCENTAJE = 5;
    GeneradorRandom generadorRandom;

    public ControlPolicial(GeneradorRandom generadorRandom) {
        this.generadorRandom = generadorRandom;
    }

    public void aplicarEfecto(Vehiculo vehiculo, Auto auto) {
        if (this.generadorRandom.generarRandomInt(MIN, MAX) <= AUTO_PORCENTAJE){
            vehiculo.sumarMovimientos(PENALIZACION);
        }
    }

    public void aplicarEfecto(Vehiculo vehiculo, Moto moto) {
        if (this.generadorRandom.generarRandomInt(MIN,MAX) <= MOTO_PORCENTAJE){
            vehiculo.sumarMovimientos(PENALIZACION);
        }

    }

    public void aplicarEfecto(Vehiculo vehiculo, CuatroPorCuatro cuatroPorCuatro) {
        if (this.generadorRandom.generarRandomInt(MIN,MAX) <= CUATRO_POR_CUATRO_PORCENTAJE){
            vehiculo.sumarMovimientos(PENALIZACION);
        }
    }

    @Override
    public void observar(ObservadorObstaculo unObservador) {
        addObservador(unObservador);
    }


}

