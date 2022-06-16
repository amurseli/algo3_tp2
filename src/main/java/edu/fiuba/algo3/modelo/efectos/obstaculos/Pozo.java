package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;

public class Pozo extends Obstaculo {

    public void aplicarEfecto(Jugador jugador,  Auto auto) {
        auto.sumarMovimientos(3);
    }

    public void aplicarEfecto(Jugador jugador, Moto moto) {
        moto.sumarMovimientos(3);
    }


    public void aplicarEfecto(Jugador jugador, CuatroPorCuatro cuatroPorCuatro) {
        cuatroPorCuatro.sumarPozoPisado();
        if(cuatroPorCuatro.elProximoPozoEsPenalizable()){
            cuatroPorCuatro.sumarMovimientos(2);
            cuatroPorCuatro.reinciarPozosPizados();
        }
    }


}
