package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.ObserverPersonalizado.ManejadorDeObservablesTipoVehiculo;
import edu.fiuba.algo3.modelo.ObserverPersonalizado.ObservadorTipoVehiculo;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;


public class Moto extends ManejadorDeObservablesTipoVehiculo implements TipoVehiculo {

    public TipoVehiculo cambiarVehiculo(){
        Auto auto = new Auto();
        notificar(auto);
        return auto;
    }
    public void aplicarEfecto(Vehiculo vehiculo, Sorpresa sorpresas) {
        sorpresas.aplicarEfecto(vehiculo);
    }

    public void aplicarEfecto(Vehiculo vehiculo, Obstaculo obstaculos) {
        obstaculos.aplicarEfecto(vehiculo, this);
    }

    @Override
    public void observar(ObservadorTipoVehiculo unObservador) {
        addObservador(unObservador);
    }

}
