package edu.fiuba.algo3.modelo.GeneradoresRandom;

import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.Esquina;

import java.util.concurrent.ThreadLocalRandom;

public class GeneradorRandom {

    public static final int MINIMA_CANTIDAD_DIRECCIONES = 1;
    public static final int MAXIMA_CANTIDAD_DIRECCIONES = 4;

    public int generarRandomInt(int min, int max) {

        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        int randomNum = tlr.nextInt(min, max + 1);
        return randomNum;

    }

    public Direccion generarDireccion(){
        int numero = generarRandomInt(MINIMA_CANTIDAD_DIRECCIONES, MAXIMA_CANTIDAD_DIRECCIONES);
        switch (numero){
            case 2: return new Izquierda();
            case 3: return new Arriba();
            case 4: return new Abajo();
            default: return new Derecha();
        }
    }

    public Esquina generarEsquina(Esquina limite){
        return new Esquina(generarRandomInt(1,limite.fila-1), generarRandomInt(1,limite.columna-1));
    }

}










































