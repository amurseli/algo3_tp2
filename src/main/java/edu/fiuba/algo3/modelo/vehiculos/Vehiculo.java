package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaFavorable;

import java.util.List;

public abstract class Vehiculo {
    public Esquina posicion;
    public Esquina posicionAnterior;
    private int movimientos;

    public Vehiculo(Esquina posicion) {
        this.posicion = posicion;
        movimientos = 0;
    }
    /*
    public Vehiculo(Esquina posicion, Esquina posicionAnterior, int movimientos) {
        this.posicion = posicion;
        this.posicionAnterior = posicionAnterior;
        this.movimientos = movimientos;
    }*/

    public int obtenerMovimientosRealizados() {
        return this.movimientos;
    }
    public void moverDerecha() {
        Esquina nuevaEsquina = posicion.obtenerEsquinaDerecha();
        sumarMovimientos(1);
        asignarPosicion(nuevaEsquina);
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
    public abstract void aplicarEfecto(Pozo e);
    public abstract void aplicarEfecto(Piquete e);
    public abstract void aplicarEfecto(ControlPolicial e);
    public abstract void aplicarEfecto(SorpresaFavorable e);
    public abstract void aplicarEfecto(SorpresaDesfavorable e);
    public abstract Vehiculo aplicarEfecto(CambioDeVehiculo e);
    private void asignarPosicion(Esquina nuevaPosicion) {

        posicionAnterior = posicion;
        posicion = nuevaPosicion;

    }
    protected void sumarMovimientos(int m) {
        this.movimientos += m;
    }

    //TODO: noc q es esto asi q lo comento pq no se usa
    /*
    protected void sumarMovimientosPorcentaje(int p) {
        this.movimientos = (int)Math.floor(this.movimientos * (p / 100 + 1));
    }*/

    public void aplicarEfectos(List<Efecto> efectos,Jugador jugador) {

        Camino caminoRecorrido = new Camino(posicionAnterior, posicion);

        for (Efecto efecto: efectos) {
            efecto.aplicarEfecto(caminoRecorrido,jugador,this);
        }
    }
}
