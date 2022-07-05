package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Pozo implements Obstaculo {

    public void aplicarEfecto(Vehiculo vehiculo, Auto auto) {
        vehiculo.sumarMovimientos(3);
    }

    public void aplicarEfecto(Vehiculo vehiculo, Moto moto) {
        vehiculo.sumarMovimientos(3);
    }


    public void aplicarEfecto(Vehiculo vehiculo, CuatroPorCuatro cuatroPorCuatro) {
        cuatroPorCuatro.sumarPozoPisado();
        if(cuatroPorCuatro.elProximoPozoEsPenalizable()){
            vehiculo.sumarMovimientos(2);
            cuatroPorCuatro.reinciarPozosPizados();
        }
    }

    public void mostrarImagen(ObstaculoView obstaculoView){
        obstaculoView.mostrarImagen(this);
    }


}
