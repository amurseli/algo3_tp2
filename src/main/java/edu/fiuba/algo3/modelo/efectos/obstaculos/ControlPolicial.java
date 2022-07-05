package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.GeneradorRandom;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class ControlPolicial implements Obstaculo {
    GeneradorRandom generadorRandom;

    public ControlPolicial(GeneradorRandom generadorRandom) {
        this.generadorRandom = generadorRandom;
    }

    public void aplicarEfecto(Vehiculo vehiculo, Auto auto) {
        if (this.generadorRandom.generarRandomInt(1,10) <= 3){
            vehiculo.sumarMovimientos(3);
        }
    }

    public void aplicarEfecto(Vehiculo vehiculo, Moto moto) {
        if (this.generadorRandom.generarRandomInt(1,10) <= 8){
            vehiculo.sumarMovimientos(3);
        }

    }

    public void aplicarEfecto(Vehiculo vehiculo, CuatroPorCuatro cuatroPorCuatro) {
        if (this.generadorRandom.generarRandomInt(1,10) <= 5){
            vehiculo.sumarMovimientos(3);
        }
    }

    public void mostrarImagen(ObstaculoView obstaculoView){
        obstaculoView.mostrarImagen(this);
    }
}

