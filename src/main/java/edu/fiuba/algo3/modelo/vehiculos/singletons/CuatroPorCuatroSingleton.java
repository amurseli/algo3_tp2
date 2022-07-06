package edu.fiuba.algo3.modelo.vehiculos.singletons;

import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;

public class CuatroPorCuatroSingleton {

    private static CuatroPorCuatro instancia;

    public static CuatroPorCuatro obtenerInstancia() {
        if (instancia == null) {
            instancia = new CuatroPorCuatro();
        }
        return instancia;
    }
}
