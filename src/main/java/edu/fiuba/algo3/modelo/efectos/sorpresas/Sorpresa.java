package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public abstract class Sorpresa implements Efecto {

    public abstract void aplicarEfecto(Vehiculo vehiculo, Auto auto);
    public abstract void aplicarEfecto(Vehiculo vehiculo, Moto moto);
    public abstract void aplicarEfecto(Vehiculo vehiculo, CuatroPorCuatro cuatroPorCuatro);

}
