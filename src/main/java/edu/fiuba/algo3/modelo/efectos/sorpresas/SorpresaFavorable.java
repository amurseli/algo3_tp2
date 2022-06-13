package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;


public class SorpresaFavorable extends Sorpresa {
    final double porcentaje = -0.2;
    public void aplicarEfecto(Jugador jugador, Auto auto) {
        auto.aplicarPorcentaje(porcentaje);
    }

    public void aplicarEfecto(Jugador jugador, Moto moto) {
        moto.aplicarPorcentaje(porcentaje);
    }

    public void aplicarEfecto(Jugador jugador, CuatroPorCuatro cuatroPorCuatro) {
        cuatroPorCuatro.aplicarPorcentaje(porcentaje);
    }
}
