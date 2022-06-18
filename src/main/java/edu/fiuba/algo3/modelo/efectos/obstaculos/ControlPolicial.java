package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.GeneradorNumeros;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
public class ControlPolicial extends Obstaculo {
    GeneradorNumeros generadorNumeros;

    public ControlPolicial(GeneradorNumeros generadorNumeros) {
        this.generadorNumeros = generadorNumeros;
    }

    public void aplicarEfecto(Jugador jugador,  Auto auto) {
        if (this.generadorNumeros.generarRandom() <= 3){
            auto.sumarMovimientos(3);
        }
    }

    public void aplicarEfecto(Jugador jugador, Moto moto) {
        if (this.generadorNumeros.generarRandom() <= 8){
            moto.sumarMovimientos(3);
        }

    }

    public void aplicarEfecto(Jugador jugador, CuatroPorCuatro cuatroPorCuatro) {
        if (this.generadorNumeros.generarRandom() <= 5){
            cuatroPorCuatro.sumarMovimientos(3);
        }
    }

}

