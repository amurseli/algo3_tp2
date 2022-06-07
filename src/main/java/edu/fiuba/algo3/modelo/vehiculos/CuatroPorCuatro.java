package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaFavorable;

public class CuatroPorCuatro extends Vehiculo {
    int pozosPisados = 0;

    public CuatroPorCuatro(Esquina e) {
        super(e);
    }

//TODO: Para cuando tengamos las sorpresas hechas
    /*
    public CuatroPorCuatro(Esquina posicion, Esquina posicionAnterior, int movimientos) {
        super(posicion, posicionAnterior, movimientos);
    }*/

    @Override
    public void aplicarEfecto(Pozo e) {
        pozosPisados ++;

        if(pozosPisados == 3){
            this.sumarMovimientos(2);
            pozosPisados = 0;
        }

    }

    @Override
    public void aplicarEfecto(Piquete e) {

    }

    @Override
    public void aplicarEfecto(ControlPolicial e) {
        int maximo = 10;
        int numero = (int) (Math.random() * maximo +1);

        if (numero <= 5){
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
