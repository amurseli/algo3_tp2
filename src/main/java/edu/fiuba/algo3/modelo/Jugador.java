package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Vehiculo;

public class Jugador {
    Vehiculo vehiculo;
    Jugador(Vehiculo v){
        this.vehiculo = v;
    }
    public int obtenerMovimientosRealizados() {
        return this.vehiculo.obtenerMovimientosRealizados();
    }
    public void aplicarEfecto(Pozo pozo) {
        this.vehiculo = this.vehiculo.aplicarEfecto(pozo);
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
