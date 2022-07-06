package edu.fiuba.algo3.modelo.ObservadorPersonalizado;

import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ObstaculoNull;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
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

    public void deleteObservador(ObservadorTipoVehiculo o){
        observadores.remove(o);
    }

    public void notificar(Auto unAuto){
        for (ObservadorTipoVehiculo unObservadorTipoVehiculo :
             observadores)
        {
            unObservadorTipoVehiculo.actualizar(unAuto);
        }
    }

    public void notificar(Moto unaAuto){
        for (ObservadorTipoVehiculo unObservadorTipoVehiculo :
                observadores)
        {
            unObservadorTipoVehiculo.actualizar(unaAuto);
        }
    }

    public void notificar(CuatroPorCuatro una4x4){
        for (ObservadorTipoVehiculo unObservadorTipoVehiculo :
                observadores)
        {
            unObservadorTipoVehiculo.actualizar(una4x4);
        }
    }

}
