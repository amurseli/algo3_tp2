package edu.fiuba.algo3.modelo.GeneradoresRandom;

import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.Esquina;
import edu.fiuba.algo3.modelo.ObserverPersonalizado.ManejadorDeObservablesSorpresa;
import edu.fiuba.algo3.modelo.efectos.sorpresas.*;

import java.util.concurrent.ThreadLocalRandom;

public class GeneradorRandom {

    public int generarRandomInt(int min, int max) {

        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        int randomNum = tlr.nextInt(min, max + 1);
        return randomNum;

    }

    public Direccion generarDireccion(){
        int numero = generarRandomInt(1,4);
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










































