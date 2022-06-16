package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Movimientos.Direccion;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

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

    public void mover(Direccion unaDireccion, ListadoCaminos caminos) {
        Camino caminoRecorrido = vehiculo.mover(unaDireccion);
        Camino unCamino = caminos.obtenerCaminoRecorrido(caminoRecorrido);
        unCamino.aplicarEfecto(this, vehiculo);
    }
    public void setVehiculo(Vehiculo v){
        vehiculo = v;
    }

}
