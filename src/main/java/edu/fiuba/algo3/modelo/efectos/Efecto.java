package edu.fiuba.algo3.modelo.efectos;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public interface Efecto {

    public void aplicarEfecto(Jugador jugador,Auto auto);
    public void aplicarEfecto(Jugador jugador,Moto moto);
    public void aplicarEfecto(Jugador jugador,CuatroPorCuatro cuatroPorCuatro);

}
