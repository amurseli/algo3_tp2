package edu.fiuba.algo3.modelo.efectos;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public interface Efecto {

    public void aplicarEfecto(Auto auto);
    public void aplicarEfecto(Moto moto);
    public void aplicarEfecto(CuatroPorCuatro cuatroPorCuatro);

}
