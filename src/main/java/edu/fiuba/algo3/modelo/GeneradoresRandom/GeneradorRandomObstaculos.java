package edu.fiuba.algo3.modelo.GeneradoresRandom;

import edu.fiuba.algo3.modelo.ObserverPersonalizado.ManejadorDeObservablesObstaculos;
import edu.fiuba.algo3.modelo.efectos.obstaculos.*;

public class GeneradorRandomObstaculos extends ManejadorDeObservablesObstaculos {

    public static final int MIN_CANTIDAD_DE_OBSTACULOS = 1;
    public static final int CANTIDAD_DE_OBSTACULOS = 4;

    public Obstaculo generarObstaculo() {
        GeneradorRandom generadorRandom = new GeneradorRandom();
        int numero = generadorRandom.generarRandomInt(MIN_CANTIDAD_DE_OBSTACULOS, CANTIDAD_DE_OBSTACULOS);
        switch (numero) {
            case 1:
                Pozo pozo = new Pozo();
                notificar(pozo);
                return pozo;
            case 2:
                Piquete piquete = new Piquete();
                notificar(piquete);
                return piquete;
            case 3:
                ControlPolicial controlPolicial = new ControlPolicial(generadorRandom);
                notificar(controlPolicial);
                return controlPolicial;
            default:
                ObstaculoNull obstaculoNull = new ObstaculoNull();
                notificar(obstaculoNull);
                return obstaculoNull;
        }
    }

}
