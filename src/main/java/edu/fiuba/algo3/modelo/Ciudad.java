package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    Jugador jugador;
    Esquina meta;
    Esquina limite;
    ListadoCaminos caminos;

    Ciudad(Esquina limite, Esquina meta, Vehiculo v){
        this.jugador = new Jugador(v);
        this.limite = limite;
        this.meta = meta;
        this.caminos = new ListadoCaminos();
    }
    public int obtenerMovimientosRealizados() {
        return this.jugador.obtenerMovimientosRealizados();
    }
    public Vehiculo obtenerVehiculo(){
        return jugador.obtenerVehiculo();
    }
    public void moverDerecha() {
        jugador.moverDerecha(caminos);
    }
    public void moverIzquierda() {
        jugador.moverIzquierda(caminos);
    }
    public void moverArriba() {
        jugador.moverArriba(caminos);
    }
    public void moverAbajo() {
        jugador.moverAbajo(caminos);
    }

    public void agregarCaminoConEfecto(Camino camino, Efecto efecto){
        caminos.agregarCaminoConEfecto(camino,efecto);
    }
}
