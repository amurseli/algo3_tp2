package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

import java.util.List;

public class Jugador {
    Vehiculo vehiculo;



    Jugador(Vehiculo v){
        this.vehiculo = v;
    }
    public int obtenerMovimientosRealizados() {
        return this.vehiculo.obtenerMovimientosRealizados();
    }

    public void moverDerecha(ListadoCaminos caminos) {
        Camino caminoRecorrido = vehiculo.moverDerecha();
        Camino unCamino = caminos.obtenerCaminoRecorrido(caminoRecorrido);
        unCamino.aplicarEfecto(this, vehiculo);
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
