package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Jugador {
    Vehiculo vehiculo;
    Jugador(Vehiculo v){
        this.vehiculo = v;
    }
    public int obtenerMovimientosRealizados() {
        return this.vehiculo.obtenerMovimientosRealizados();
    }
    public void aplicarEfecto(Pozo pozo) {

        this.vehiculo.aplicarEfecto(pozo);
    }
    public void aplicarEfecto(ControlPolicial control) {

        this.vehiculo.aplicarEfecto(control);
    }

    public void moverDerecha() {
        vehiculo.moverDerecha();
    }
    public void moverIzquierda() {
        vehiculo.moverIzquierda();
    }
    public void moverArriba() {
        vehiculo.moverArriba();
    }
    public void moverAbajo() {
        vehiculo.moverAbajo();
    }
}
