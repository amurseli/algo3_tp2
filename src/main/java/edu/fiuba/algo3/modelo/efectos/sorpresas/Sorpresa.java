package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;

public abstract class Sorpresa implements Efecto {

    public abstract void aplicarEfecto(Jugador jugador, Auto auto);
    public abstract void aplicarEfecto(Jugador jugador, Moto moto);
    public abstract void aplicarEfecto(Jugador jugador, CuatroPorCuatro cuatroPorCuatro);

}
