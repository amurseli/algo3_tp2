package edu.fiuba.algo3.modelo.vehiculos.singletons;

import edu.fiuba.algo3.modelo.vehiculos.Moto;

public class MotoSingleton {

    private static Moto instancia;

    public static Moto obtenerInstancia() {
        if (instancia == null) {
            instancia = new Moto();
        }
        return instancia;
    }
}