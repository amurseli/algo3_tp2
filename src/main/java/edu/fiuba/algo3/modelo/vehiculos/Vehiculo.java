package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaFavorable;

public abstract class Vehiculo {
    public Esquina posicion;
    public Esquina posicionAnterior;
    private int movimientos;

    public Vehiculo(Esquina posicion) {
        this.posicion = posicion;
        this.movimientos = 0;
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
        Esquina e = this.posicion.obtenerEsquinaDerecha();
        this.sumarMovimientos(1);
        this.asignarPosicion(e);
    }
    public void moverIzquierda() {
        Esquina e = this.posicion.obtenerEsquinaIzquierda();
        this.sumarMovimientos(1);
        this.asignarPosicion(e);
    }
    public void moverArriba() {
        Esquina e = this.posicion.obtenerEsquinaArriba();
        this.sumarMovimientos(1);
        this.asignarPosicion(e);
    }
    public void moverAbajo() {
        Esquina e = this.posicion.obtenerEsquinaAbajo();
        this.sumarMovimientos(1);
        this.asignarPosicion(e);
    }
    public abstract void aplicarEfecto(Pozo e);
    public abstract void aplicarEfecto(Piquete e);
    public abstract void aplicarEfecto(ControlPolicial e);
    public abstract void aplicarEfecto(SorpresaFavorable e);
    public abstract void aplicarEfecto(SorpresaDesfavorable e);
    public abstract Vehiculo aplicarEfecto(CambioDeVehiculo e);
    private void asignarPosicion(Esquina p) {
        this.posicionAnterior = this.posicion;
        this.posicion = p;
    }
    protected void sumarMovimientos(int m) {
        this.movimientos += m;
    }

    //TODO: noc q es esto asi q lo comento pq no se usa
    /*
    protected void sumarMovimientosPorcentaje(int p) {
        this.movimientos = (int)Math.floor(this.movimientos * (p / 100 + 1));
    }*/
}
