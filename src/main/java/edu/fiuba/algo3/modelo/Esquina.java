package edu.fiuba.algo3.modelo;

public class Esquina {
    public int fila, columna;

    public Esquina(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    // TODO: validar que la proxima esquina exista
    public Esquina obtenerEsquinaArriba() {
        return new Esquina(this.fila - 1, this.columna);
    }

    public Esquina obtenerEsquinaDerecha() {
        return new Esquina(this.fila, this.columna + 1);
    }

    public Esquina obtenerEsquinaAbajo() {
        return new Esquina(this.fila + 1, this.columna);
    }

    public Esquina obtenerEsquinaIzquierda() {
        return new Esquina(this.fila, this.columna - 1);
    }

    public int getFila(){
        return fila;
    }

    public int getColumna(){
        return columna;
    }

    @Override
    public boolean equals(Object o) {
        Esquina e = (Esquina)o;
        return this.fila == e.fila && this.columna == e.columna;
    }

}
