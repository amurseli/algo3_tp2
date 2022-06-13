package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.efectos.Efecto;

public abstract class Vehiculo {
    public Esquina posicion;
    public Esquina posicionAnterior;
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

    public Camino moverDerecha() {
        Esquina nuevaEsquina = posicion.obtenerEsquinaDerecha();
        sumarMovimientos(1);
        asignarPosicion(nuevaEsquina);
        return new Camino(posicionAnterior,posicion);
    }
    public void moverIzquierda() {
        Esquina nuevaEsquina = posicion.obtenerEsquinaIzquierda();
        sumarMovimientos(1);
        asignarPosicion(nuevaEsquina);
    }
    public void moverArriba() {
        Esquina nuevaEsquina = posicion.obtenerEsquinaArriba();
        sumarMovimientos(1);
        asignarPosicion(nuevaEsquina);
    }
    public void moverAbajo() {
        Esquina nuevaEsquina = posicion.obtenerEsquinaAbajo();
        sumarMovimientos(1);
        asignarPosicion(nuevaEsquina);
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
