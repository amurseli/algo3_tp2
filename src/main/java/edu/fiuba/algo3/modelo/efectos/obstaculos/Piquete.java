package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;

public class Piquete extends Obstaculo {

    @Override
    public void aplicarEfecto(Jugador jugador, Auto auto) {
        auto.darLaVuelta();
    }
    @Override
    public void aplicarEfecto(Jugador jugador, Moto moto) {
        moto.sumarMovimientos(2);
    }
    @Override
    public void aplicarEfecto(Jugador jugador, CuatroPorCuatro cuatroPorCuatro) {
        cuatroPorCuatro.darLaVuelta();
    }

}




