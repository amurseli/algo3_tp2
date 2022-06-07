package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Vehiculo;

public class CuatroPorCuatro extends Vehiculo {
    int pozosPisados;

    public CuatroPorCuatro(Esquina e) {
        super(e);
        this.pozosPisados = 0;
    }

    public CuatroPorCuatro(Esquina posicion, Esquina posicionAnterior, int movimientos) {
        super(posicion, posicionAnterior, movimientos);
        this.pozosPisados = 0;
    }

    @Override
    public Vehiculo aplicarEfecto(Pozo e) {
        return this;
    }

    @Override
    public Vehiculo aplicarEfecto(Piquete e) {
        return this;
    }

    @Override
    public Vehiculo aplicarEfecto(ControlPolicial e) {
        return this;
    }

    @Override
    public Vehiculo aplicarEfecto(SorpresaFavorable e) {
        return this;
    }

    @Override
    public Vehiculo aplicarEfecto(SorpresaDesfavorable e) {
        return this;
    }

    @Override
    public Vehiculo aplicarEfecto(CambioDeVehiculo e) {
        return this;
    }
}
