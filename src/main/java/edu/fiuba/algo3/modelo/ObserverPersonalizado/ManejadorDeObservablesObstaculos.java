package edu.fiuba.algo3.modelo.ObserverPersonalizado;

import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ObstaculoNull;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;

import java.util.ArrayList;

public class ManejadorDeObservablesObstaculos {

    public ArrayList<ObservadorObstaculo> observadores;

    public ManejadorDeObservablesObstaculos(){
        observadores = new ArrayList<ObservadorObstaculo>();
    }

    public void addObservador(ObservadorObstaculo o){
        observadores.add(o);
    };

    public void notificar(Piquete piquete){
        for (ObservadorObstaculo unObservador:
                observadores)
        {
            unObservador.actualizar(piquete);
        }
    }

    public void notificar(ControlPolicial controlPolicial){
        for (ObservadorObstaculo unObservador:
                observadores)
        {
            unObservador.actualizar(controlPolicial);
        }
    }

    public void notificar(ObstaculoNull obstaculoNull){
        for (ObservadorObstaculo unObservador:
                observadores)
        {
            unObservador.actualizar(obstaculoNull);
        }
    }

    public void notificar(Pozo pozo){
        for (ObservadorObstaculo unObservador:
                observadores)
        {
            unObservador.actualizar(pozo);
        }
    }
}
