package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    //TODO Meter tamaños de ciudad :)
    Jugador p1;
    Esquina meta;
    List<Efecto> efectos;

    Ciudad(int tamanioFilas, int tamanioColumnas, Esquina meta, Vehiculo v){
        this.p1 = new Jugador(v);
        this.meta = meta;
        this.efectos = new ArrayList<>();
        this.generarEfectos();
    }
    public int obtenerMovimientosRealizados() {
        return this.p1.obtenerMovimientosRealizados();
    }
    public void moverDerecha() {
        p1.moverDerecha();
        this.aplicarEfectos();
    }
    public void moverIzquierda() {
        p1.moverIzquierda();
    }
    public void moverArriba() {
        p1.moverArriba();
    }
    public void moverAbajo() {
        p1.moverAbajo();
    }
    private void generarEfectos() {
        efectos.add(new Pozo(new Camino(new Esquina(1,5),new Esquina(1,6))));
    }
    private void aplicarEfectos() {
        for (Efecto efecto: efectos) {
            efecto.aplicarEfecto(this.p1);
        }
    }
}
