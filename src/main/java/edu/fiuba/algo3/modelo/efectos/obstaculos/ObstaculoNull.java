package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class ObstaculoNull implements Obstaculo{
    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Auto auto) {

    }

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Moto moto) {

    }

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, CuatroPorCuatro cuatroPorCuatro) {

    }


}
