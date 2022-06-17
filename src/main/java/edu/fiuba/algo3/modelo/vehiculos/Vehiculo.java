package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Movimientos.Direccion;
import edu.fiuba.algo3.modelo.efectos.Efecto;

public abstract class Vehiculo {
    public Esquina posicion;
    public Esquina posicionAnterior;

    protected int movimientos;

    public Vehiculo(Esquina posicion) {
        this.posicion = posicion;
        movimientos = 0;
    }

    public Vehiculo(Esquina posicion, Esquina posicionAnterior, int movimientos){
        this.posicion = posicion;
        this.posicionAnterior = posicionAnterior;
        this.movimientos = movimientos;
    }

    public int obtenerMovimientosRealizados() {
        return this.movimientos;
    }

    public Esquina obtenerPosicion(){
        return posicion;
    }

    public Camino mover(Direccion unaDireccion, ListadoCaminos caminos) {
        Esquina nuevaEsquina = unaDireccion.siguiente(posicion);
        sumarMovimientos(1);
        asignarPosicion(nuevaEsquina);
        Camino caminoRecorrido = caminos.obtenerCaminoRecorrido(new Camino(posicionAnterior, unaDireccion));
        return caminoRecorrido;
    }

    public void asignarPosicion(Esquina nuevaPosicion) {
        posicionAnterior = posicion;
        posicion = nuevaPosicion;
    }

    public void darLaVuelta(){
        posicion = posicionAnterior;
    }

    public void sumarMovimientos(int m) {
        this.movimientos += m;
    }

    public void setMovimientos(int nuevosMovimientos){
        movimientos = nuevosMovimientos;
    }

    public void aplicarPorcentaje(double porcentaje){
        movimientos = movimientos + (int)(movimientos * porcentaje);
    }

    public abstract void aplicarEfecto(Jugador jugador, Efecto efecto);

    public abstract Vehiculo cambiarVehiculo();
}
