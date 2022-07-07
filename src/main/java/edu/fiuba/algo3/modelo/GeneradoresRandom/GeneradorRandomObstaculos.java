package edu.fiuba.algo3.modelo.GeneradoresRandom;

import edu.fiuba.algo3.modelo.ObserverPersonalizado.ManejadorDeObservablesObstaculos;
import edu.fiuba.algo3.modelo.efectos.obstaculos.*;

public class GeneradorRandomObstaculos extends ManejadorDeObservablesObstaculos {

    public Obstaculo generarObstaculo() {
        GeneradorRandom generadorRandom = new GeneradorRandom();
        int numero = generadorRandom.generarRandomInt(1, 4);
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
