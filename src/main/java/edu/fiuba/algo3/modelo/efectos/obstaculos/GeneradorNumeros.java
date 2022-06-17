package edu.fiuba.algo3.modelo.efectos.obstaculos;

public class GeneradorNumeros {

    public int generarRandom() {
        int maximo = 10;
        return ((int) (Math.random() * maximo +1));
    }
}
