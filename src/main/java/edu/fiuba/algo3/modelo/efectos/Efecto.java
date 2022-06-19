package edu.fiuba.algo3.modelo.efectos;

import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public interface Efecto {

    void aplicarEfecto(Vehiculo vehiculo, Auto auto);
    void aplicarEfecto(Vehiculo vehiculo, Moto moto);
    public void aplicarEfecto(Vehiculo vehiculo, CuatroPorCuatro cuatroPorCuatro);

}
