package edu.fiuba.algo3.modelo;

public class Auto extends Vehiculo {

    public Auto(Esquina e) {
        super(e);
    }

    public Auto(Esquina posicion, Esquina posicionAnterior, int movimientos) {
        super(posicion, posicionAnterior, movimientos);
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
