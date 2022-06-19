package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.efectos.Efecto;

public class Vehiculo {
    public Esquina posicion;
    public Esquina posicionAnterior;
    private int movimientos;
    private TipoVehiculo estado;

    public Vehiculo(TipoVehiculo tipo, Esquina posicion) {
        this.estado = tipo;
        this.posicion = posicion;
        movimientos = 0;
    }

    public int obtenerMovimientosRealizados() {
        return this.movimientos;
    }

    public Esquina obtenerPosicion(){
        return posicion;
    }
    public TipoVehiculo obtenerTipoVehiculo() {
        return this.estado;
    }

    public void mover(Direccion unaDireccion, ListadoCaminos caminos) {
        Esquina nuevaEsquina = unaDireccion.siguiente(posicion);
        sumarMovimientos(1);
        asignarPosicion(nuevaEsquina);
        Camino caminoRecorrido = caminos.obtenerCaminoRecorrido(new Camino(posicionAnterior, unaDireccion));
        caminoRecorrido.aplicarEfecto(this);
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

    public void aplicarPorcentaje(double porcentaje){
        movimientos = movimientos + (int)(movimientos * porcentaje);
    }

    public void aplicarEfecto(Efecto efecto) {
        estado.aplicarEfecto(this, efecto);
    }

    public void cambiarTipo() {
        this.estado = this.estado.cambiarVehiculo();
    }
}
