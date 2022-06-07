package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

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
        //this.generarEfectos();
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

    public void agregarEfecto(Efecto efecto){
        efectos.add(efecto);
    }

    /*private void generarEfectos() {
        efectos.add(new Pozo(new Camino(new Esquina(1,5),new Esquina(1,6))));
    }
    */


    private void aplicarEfectos() {
        //TODO: ESTO ESTA MAL, LA COMPARACION DE ESTOY PASANDO POR UN EFECTO DEBERIA SER EN OTRO LADO. REFACTOR
        Camino camino = new Camino(p1.vehiculo.posicionAnterior, p1.vehiculo.posicion);

        for (Efecto efecto: efectos) {
            if (camino.equals(efecto.obtenerPosicion())) {
                efecto.aplicarEfecto(this.p1);
            }
        }
    }
}
