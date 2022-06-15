package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Movimientos.Direccion;
import edu.fiuba.algo3.modelo.efectos.Efecto;

public abstract class Vehiculo {
    public Esquina posicion;
    public Esquina posicionAnterior;
    public Camino caminoRealizado;
    private int movimientos;

    public Vehiculo(Esquina posicion) {
        this.posicion = posicion;
        movimientos = 0;
    }

    public int obtenerMovimientosRealizados() {
        return this.movimientos;
    }

    public Esquina obtenerPosicion(){
        return posicion;
    }

    public Camino mover(Direccion unaDireccion) {
        Esquina nuevaEsquina = unaDireccion.siguiente(posicion);
        caminoRealizado = new Camino(posicion, unaDireccion);
        sumarMovimientos(1);
        asignarPosicion(nuevaEsquina);
        return caminoRealizado;
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
}
