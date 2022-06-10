package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    //TODO Meter tamaños de ciudad :)
    Jugador jugador;
    Esquina meta;
    List<Efecto> efectos;

    Ciudad(int tamanioFilas, int tamanioColumnas, Esquina meta, Vehiculo v){
        this.jugador = new Jugador(v);
        this.meta = meta;
        this.efectos = new ArrayList<>();
        //this.generarEfectos();
    }
    public int obtenerMovimientosRealizados() {
        return this.jugador.obtenerMovimientosRealizados();
    }
    public void moverDerecha() {
        jugador.moverDerecha();
        jugador.aplicarEfectos(efectos);
    }
    public void moverIzquierda() {
        jugador.moverIzquierda();
        jugador.aplicarEfectos(efectos);
    }
    public void moverArriba() {
        jugador.moverArriba();
        jugador.aplicarEfectos(efectos);
    }
    public void moverAbajo() {
        jugador.moverAbajo();
        jugador.aplicarEfectos(efectos);
    }

    public void agregarEfecto(Efecto efecto){
        efectos.add(efecto);
    }

    /*private void generarEfectos() {
        efectos.add(new Pozo(new Camino(new Esquina(1,5),new Esquina(1,6))));
    }
    */

}
