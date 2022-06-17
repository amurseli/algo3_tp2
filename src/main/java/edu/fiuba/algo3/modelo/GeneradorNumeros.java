package edu.fiuba.algo3.modelo;

public class GeneradorNumeros {

    public int generarRandom() {
        int maximo = 10;
        return ((int) (Math.random() * maximo +1));
    }
}
