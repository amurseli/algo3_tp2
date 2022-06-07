package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaFavorable;

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

        int maximo = 10;
        int numero = (int) (Math.random() * maximo +1);

        if (numero <= 8){
            this.sumarMovimientos(3);
        }
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
