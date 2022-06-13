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

    public Vehiculo obtenerVehiculo(){
        return vehiculo;
    }

    public void moverDerecha(ListadoCaminos caminos) {
        Camino caminoRecorrido = vehiculo.moverDerecha();
        Camino unCamino = caminos.obtenerCaminoRecorrido(caminoRecorrido);
        unCamino.aplicarEfecto(this, vehiculo);
    }
    public void moverIzquierda(ListadoCaminos caminos) {
        Camino caminoRecorrido = vehiculo.moverIzquierda();
        Camino unCamino = caminos.obtenerCaminoRecorrido(caminoRecorrido);
        unCamino.aplicarEfecto(this, vehiculo);
    }

    public void moverArriba(ListadoCaminos caminos) {
        Camino caminoRecorrido = vehiculo.moverArriba();
        Camino unCamino = caminos.obtenerCaminoRecorrido(caminoRecorrido);
        unCamino.aplicarEfecto(this, vehiculo);
    }
    public void moverAbajo(ListadoCaminos caminos) {
        Camino caminoRecorrido = vehiculo.moverAbajo();
        Camino unCamino = caminos.obtenerCaminoRecorrido(caminoRecorrido);
        unCamino.aplicarEfecto(this, vehiculo);
    }
    public void setVehiculo(Vehiculo v){
        vehiculo = v;
    }

}
