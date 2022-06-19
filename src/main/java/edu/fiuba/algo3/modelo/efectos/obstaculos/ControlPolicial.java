package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.GeneradorNumeros;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class ControlPolicial extends Obstaculo {
    GeneradorNumeros generadorNumeros;

    public ControlPolicial(GeneradorNumeros generadorNumeros) {
        this.generadorNumeros = generadorNumeros;
    }

    public void aplicarEfecto(Vehiculo vehiculo, Auto auto) {
        if (this.generadorNumeros.generarRandom() <= 3){
            vehiculo.sumarMovimientos(3);
        }
    }

    public void aplicarEfecto(Vehiculo vehiculo, Moto moto) {
        if (this.generadorNumeros.generarRandom() <= 8){
            vehiculo.sumarMovimientos(3);
        }

    }

    public void aplicarEfecto(Vehiculo vehiculo, CuatroPorCuatro cuatroPorCuatro) {
        if (this.generadorNumeros.generarRandom() <= 5){
            vehiculo.sumarMovimientos(3);
        }
    }

}

