package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import java.util.ArrayList;

public class ManejadorDeObservables {

    public ArrayList<ObservadorTipoVehiculo> observadores;

    public ManejadorDeObservables(){
        observadores = new ArrayList<ObservadorTipoVehiculo>();
    }

    public void addObservador(ObservadorTipoVehiculo o){
        observadores.add(o);
    };

    public void notificar(Auto unAuto){
        for (ObservadorTipoVehiculo unObservador:
             observadores)
        {
            unObservador.actualizar(unAuto);
        }
    }

    public void notificar(Moto unaAuto){
        for (ObservadorTipoVehiculo unObservador:
                observadores)
        {
            unObservador.actualizar(unaAuto);
        }
    }

    public void notificar(CuatroPorCuatro una4x4){
        for (ObservadorTipoVehiculo unObservador:
                observadores)
        {
            unObservador.actualizar(una4x4);
        }
    }

}
