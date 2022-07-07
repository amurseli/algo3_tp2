package edu.fiuba.algo3.modelo.GeneradoresRandom;

import edu.fiuba.algo3.modelo.ObserverPersonalizado.ManejadorDeObservablesSorpresa;
import edu.fiuba.algo3.modelo.efectos.sorpresas.*;

public class GeneradorRandomSorpresas extends ManejadorDeObservablesSorpresa {

    public Sorpresa generarSorpresa() {
        GeneradorRandom generadorRandom = new GeneradorRandom();
        int numero = generadorRandom.generarRandomInt(1, 4);
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
