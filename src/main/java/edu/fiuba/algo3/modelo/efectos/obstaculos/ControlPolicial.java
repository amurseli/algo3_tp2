package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
public class ControlPolicial extends Obstaculo {

    public void aplicarEfecto(Jugador jugador,  Auto auto) {
        int maximo = 10;
        int numero = (int) (Math.random() * maximo +1);

        if (numero <= 3){
            auto.sumarMovimientos(3);
        }
    }

    public void aplicarEfecto(Jugador jugador, Moto moto) {
        int maximo = 10;
        int numero = (int) (Math.random() * maximo +1);

        if (numero <= 8){
            moto.sumarMovimientos(3);
        }


    }

    public void aplicarEfecto(Jugador jugador, CuatroPorCuatro cuatroPorCuatro) {
        int maximo = 10;
        int numero = (int) (Math.random() * maximo +1);

        if (numero <= 5){
            cuatroPorCuatro.sumarMovimientos(3);
        }

    }

}

