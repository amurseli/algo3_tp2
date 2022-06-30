package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaFavorable;

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
            case 1: return new Derecha();
            case 2: return new Izquierda();
            case 3: return new Arriba();
            case 4: return new Abajo();
        }
        return null;
    }

    public Esquina generarEsquina(Esquina limite){
        return new Esquina(generarRandomInt(1,limite.columna-1), generarRandomInt(1,limite.fila-1));
    }

    public Obstaculo generarObstaculo(){
        int numero = generarRandomInt(1,3);
        switch (numero){
            case 1: return new Pozo();
            case 2: return new ControlPolicial(new GeneradorRandom());
            case 3: return new Piquete();
        }
        return null;
    }

    public Sorpresa generarSorpresa(){
        int numero = generarRandomInt(1,3);
        switch (numero){
            case 1: return new CambioDeVehiculo();
            case 2: return new SorpresaFavorable();
            case 3: return new SorpresaDesfavorable();
        }
        return null;
    }










































}
