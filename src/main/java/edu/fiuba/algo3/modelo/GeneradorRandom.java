package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.efectos.obstaculos.*;
import edu.fiuba.algo3.modelo.efectos.sorpresas.*;

import java.util.concurrent.ThreadLocalRandom;

public class GeneradorRandom extends ManejadorDeObservablesSorpresa {

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

    public Obstaculo generarObstaculo(){
        int numero = generarRandomInt(1,3);
        switch (numero){
            case 1: return new Pozo();
            case 2: return new ControlPolicial(new GeneradorRandom());
            case 3: return new Piquete();
            default: return new ObstaculoNull();
        }
    }

    public Sorpresa generarSorpresa() {
        int numero = generarRandomInt(1, 4);
        switch (numero) {
            case 1:
                CambioDeVehiculo unCambio = new CambioDeVehiculo();
                notificar(unCambio);
                return unCambio;
            case 2:
                SorpresaFavorable unaFavorable = new SorpresaFavorable();
                notificar(unaFavorable);
                return unaFavorable;
            case 3:
                SorpresaDesfavorable unaDesfavorable = new SorpresaDesfavorable();
                notificar(unaDesfavorable);
                return unaDesfavorable;
            default:
                SorpresaNull unaVacia = new SorpresaNull();
                notificar(unaVacia);
                return unaVacia;
        }
    }
}










































