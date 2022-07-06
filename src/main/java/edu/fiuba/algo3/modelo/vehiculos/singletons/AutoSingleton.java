package edu.fiuba.algo3.modelo.vehiculos.singletons;

import edu.fiuba.algo3.modelo.vehiculos.Auto;

public class AutoSingleton {

    private static Auto instancia;

    public static Auto obtenerInstancia() {
        if (instancia == null) {
            instancia = new Auto();
        }
        return instancia;
    }
}
