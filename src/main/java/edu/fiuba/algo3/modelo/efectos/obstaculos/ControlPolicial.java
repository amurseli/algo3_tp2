package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class ControlPolicial implements Efecto {




    public void aplicarEfecto(Auto auto) {
        int maximo = 10;
        int numero = (int) (Math.random() * maximo +1);

        if (numero <= 3){
            auto.sumarMovimientos(3);
        }
    }


    public void aplicarEfecto(Moto moto) {
        int maximo = 10;
        int numero = (int) (Math.random() * maximo +1);

        if (numero <= 8){
            moto.sumarMovimientos(3);
        }


    }


    public void aplicarEfecto(CuatroPorCuatro cuatroPorCuatro) {
        int maximo = 10;
        int numero = (int) (Math.random() * maximo +1);

        if (numero <= 5){
            cuatroPorCuatro.sumarMovimientos(3);
        }

    }

}

