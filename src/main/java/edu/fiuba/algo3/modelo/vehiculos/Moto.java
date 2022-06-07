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

    //TODO: Constructor 2, lo comento para cuando lo usemos
    /*public Moto(Esquina posicion, Esquina posicionAnterior, int movimientos) {
        super(posicion, posicionAnterior, movimientos);
    }*/

    @Override
    public void aplicarEfecto(Pozo e) {
        this.sumarMovimientos(3);

    }

    @Override
    public void aplicarEfecto(Piquete e) {

    }

    @Override
    public void aplicarEfecto(ControlPolicial e) {

        int maximo = 10;
        int numero = (int) (Math.random() * maximo +1);

        if (numero <= 8){
            this.sumarMovimientos(3);
        }
    }

    @Override
    public void aplicarEfecto(SorpresaFavorable e) {

    }

    @Override
    public void aplicarEfecto(SorpresaDesfavorable e) {

    }

    @Override
    public Vehiculo aplicarEfecto(CambioDeVehiculo e) {

        return this;
    }
}
