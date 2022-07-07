package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;

import java.util.ArrayList;
import java.util.List;

public class ManejadorDeObservables {

    public ArrayList<Observador> observadores;

    public ManejadorDeObservables(){
        observadores = new ArrayList<Observador>();
    }

    public void addObservador(Observador o){
        observadores.add(o);
    };

    public void notificar(Auto unAuto){
        for (Observador unObservador:
             observadores)
        {
            unObservador.actualizar(unAuto);
        }
    }

    public void notificar(Moto unaAuto){
        for (Observador unObservador:
                observadores)
        {
            unObservador.actualizar(unaAuto);
        }
    }

    public void notificar(CuatroPorCuatro una4x4){
        for (Observador unObservador:
                observadores)
        {
            unObservador.actualizar(una4x4);
        }
    }

}
