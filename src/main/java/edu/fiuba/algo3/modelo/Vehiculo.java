package edu.fiuba.algo3.modelo;

public abstract class Vehiculo {
    private Esquina posicion;
    private Esquina posicionAnterior;
    private int movimientos;

    public Vehiculo(Esquina posicion) {
        this.posicion = posicion;
        this.movimientos = 0;
    }
    public Vehiculo(Esquina posicion, Esquina posicionAnterior, int movimientos) {
        this.posicion = posicion;
        this.posicionAnterior = posicionAnterior;
        this.movimientos = movimientos;
    }
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
    public abstract Vehiculo aplicarEfecto(Pozo e);
    public abstract Vehiculo aplicarEfecto(Piquete e);
    public abstract Vehiculo aplicarEfecto(ControlPolicial e);
    public abstract Vehiculo aplicarEfecto(SorpresaFavorable e);
    public abstract Vehiculo aplicarEfecto(SorpresaDesfavorable e);
    public abstract Vehiculo aplicarEfecto(CambioDeVehiculo e);
    private void asignarPosicion(Esquina p) {
        this.posicionAnterior = this.posicion;
        this.posicion = p;
    }
    protected void sumarMovimientos(int m) {
        this.movimientos += m;
    }
    protected void sumarMovimientosPorcentaje(int p) {
        this.movimientos = (int)Math.floor(this.movimientos * (p / 100 + 1));
    }
}
