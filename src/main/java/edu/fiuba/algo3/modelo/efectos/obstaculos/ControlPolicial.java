package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
public class ControlPolicial extends Obstaculo {

    public void aplicarEfecto(Jugador jugador,  Auto auto) {
        if (generarRandom() <= 3){
            auto.sumarMovimientos(3);
        }
    }

    public void aplicarEfecto(Jugador jugador, Moto moto) {
        if (generarRandom() <= 8){
            moto.sumarMovimientos(3);
        }

    }

    public void aplicarEfecto(Jugador jugador, CuatroPorCuatro cuatroPorCuatro) {
        if (generarRandom() <= 5){
            cuatroPorCuatro.sumarMovimientos(3);
        }
    }
    public int generarRandom(){
        int maximo = 10;
        return ((int) (Math.random() * maximo +1));
    }

}

