package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;

public abstract class Sorpresa implements Efecto {

    public abstract void aplicarEfecto(Auto auto);
    public abstract void aplicarEfecto(Moto moto);
    public abstract void aplicarEfecto(CuatroPorCuatro cuatroPorCuatro);

}
