package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    //TODO Meter tamaños de ciudad :)
    Jugador jugador;
    Esquina meta;
    //List<Efecto> efectos;

    ListadoCaminos caminos;

    Ciudad(int tamanioFilas, int tamanioColumnas, Esquina meta, Vehiculo v){
        this.jugador = new Jugador(v);
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
        jugador.moverIzquierda();
    }
    public void moverArriba() {
        jugador.moverArriba();
    }
    public void moverAbajo() {
        jugador.moverAbajo();
    }

    public void agregarCaminoConEfecto(Camino camino, Efecto efecto){
        caminos.agregarCaminoConEfecto(camino,efecto);
    }

    /*private void generarEfectos() {
        efectos.add(new Pozo(new Camino(new Esquina(1,5),new Esquina(1,6))));
    }
    */

}
