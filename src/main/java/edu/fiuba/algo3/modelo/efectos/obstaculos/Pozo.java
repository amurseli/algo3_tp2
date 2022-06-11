package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;

public class Pozo extends Obstaculo {

    public void aplicarEfecto(Auto auto) {
        auto.sumarMovimientos(3);
    }

    public void aplicarEfecto(Moto moto) {
        moto.sumarMovimientos(3);
    }


    public void aplicarEfecto(CuatroPorCuatro cuatroPorCuatro) {
        cuatroPorCuatro.sumarPozoPisado();
        if(cuatroPorCuatro.getPozosPisados() == 3){ //violo el tell dont ask pidiendole cuantos pozos piso?si. simplifico las cosas? si
            cuatroPorCuatro.sumarMovimientos(2);
            cuatroPorCuatro.reinciarPozosPizados();
        }
    }


}
