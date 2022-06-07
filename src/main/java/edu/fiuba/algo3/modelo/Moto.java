package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Vehiculo;

public class Moto extends Vehiculo {

    public Moto(Esquina e) {
        super(e);
    }

    public Moto(Esquina posicion, Esquina posicionAnterior, int movimientos) {
        super(posicion, posicionAnterior, movimientos);
    }

    @Override
    public Vehiculo aplicarEfecto(Pozo e) {
        this.sumarMovimientos(3);
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
