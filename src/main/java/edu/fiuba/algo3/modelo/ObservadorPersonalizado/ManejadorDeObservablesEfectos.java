package edu.fiuba.algo3.modelo.ObservadorPersonalizado;

import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ObstaculoNull;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaFavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaNull;

import java.util.ArrayList;

public class ManejadorDeObservablesEfectos {
    public ArrayList<ObservadorEfectos> observadores;

    public ManejadorDeObservablesEfectos(){
        observadores = new ArrayList<ObservadorEfectos>();
    }

    public void addObservador(ObservadorEfectos o){
        observadores.add(o);
    };

    public void deleteObservador(ObservadorEfectos o){
        observadores.remove(o);
    }

    public void notificar(Pozo pozo){
        for (ObservadorEfectos observadorEfectos :
                observadores)
        {
            observadorEfectos.actualizar(pozo);
        }
    }

    public void notificar(ControlPolicial controlPolicial){
        for (ObservadorEfectos observadorEfectos :
                observadores)
        {
            observadorEfectos.actualizar(controlPolicial);
        }
    }


    public void notificar(Piquete piquete){
        for (ObservadorEfectos observadorEfectos :
                observadores)
        {
            observadorEfectos.actualizar(piquete);
        }
    }


    public void notificar(ObstaculoNull obstaculoNull){
        for (ObservadorEfectos observadorEfectos :
                observadores)
        {
            observadorEfectos.actualizar(obstaculoNull);
        }
    }


    public void notificar(CambioDeVehiculo cambioDeVehiculo){
        for (ObservadorEfectos observadorEfectos :
                observadores)
        {
            observadorEfectos.actualizar(cambioDeVehiculo);
        }
    }

    public void notificar(SorpresaDesfavorable sorpresaDesfavorable){
        for (ObservadorEfectos observadorEfectos :
                observadores)
        {
            observadorEfectos.actualizar(sorpresaDesfavorable);
        }
    }


    public void notificar(SorpresaFavorable sorpresaFavorable){
        for (ObservadorEfectos observadorEfectos :
                observadores)
        {
            observadorEfectos.actualizar(sorpresaFavorable);
        }
    }


    public void notificar(SorpresaNull sorpresaNull){
        for (ObservadorEfectos observadorEfectos :
                observadores)
        {
            observadorEfectos.actualizar(sorpresaNull);
        }
    }
}
