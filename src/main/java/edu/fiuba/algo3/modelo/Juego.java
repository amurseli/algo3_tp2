package edu.fiuba.algo3.modelo;

public class Juego {
    Ciudad ciudad;
    public Juego(){
        this.ciudad = new Ciudad(100,100, new Esquina(1, 10), new Moto(new Esquina(1,5)));
    }
    public void moverDerecha() {
        ciudad.moverDerecha();
    }

    public int obtenerMovimientosRealizados() {
        return this.ciudad.obtenerMovimientosRealizados();
    }
}
