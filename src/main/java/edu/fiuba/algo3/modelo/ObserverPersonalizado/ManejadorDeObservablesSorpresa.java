package edu.fiuba.algo3.modelo.ObserverPersonalizado;

import edu.fiuba.algo3.modelo.efectos.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaFavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaNull;

import java.util.ArrayList;

public class ManejadorDeObservablesSorpresa {

    public ArrayList<ObservadorSorpresa> observadores;

    public ManejadorDeObservablesSorpresa(){
        observadores = new ArrayList<ObservadorSorpresa>();
    }

    public void addObservador(ObservadorSorpresa o){
        observadores.add(o);
    };

    public void notificar(SorpresaFavorable unSorpresaFavorable){
        for (ObservadorSorpresa unObservador:
                observadores)
        {
            unObservador.actualizar(unSorpresaFavorable);
        }
    }

    public void notificar(CambioDeVehiculo unCambioDeVehiculo){
        for (ObservadorSorpresa unObservador:
                observadores)
        {
            unObservador.actualizar(unCambioDeVehiculo);
        }
    }

    public void notificar(SorpresaNull unSorpresaNull){
        for (ObservadorSorpresa unObservador:
                observadores)
        {
            unObservador.actualizar(unSorpresaNull);
        }
    }

    public void notificar(SorpresaDesfavorable unDesfavorable){
        for (ObservadorSorpresa unObservador:
                observadores)
        {
            unObservador.actualizar(unDesfavorable);
        }
    }



}
