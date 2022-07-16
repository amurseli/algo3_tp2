package edu.fiuba.algo3.modelo.GeneradoresRandom;

import edu.fiuba.algo3.modelo.ObserverPersonalizado.ManejadorDeObservablesSorpresa;
import edu.fiuba.algo3.modelo.efectos.sorpresas.*;

public class GeneradorRandomSorpresas extends ManejadorDeObservablesSorpresa {

    public static final int MINIMA_CANTIDAD_SORPRESAS = 1;
    public static final int MAXIMA_CANTIDAD_SORPRESAS = 4;

    public Sorpresa generarSorpresa() {
        GeneradorRandom generadorRandom = new GeneradorRandom();
        int numero = generadorRandom.generarRandomInt(MINIMA_CANTIDAD_SORPRESAS, MAXIMA_CANTIDAD_SORPRESAS);
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
