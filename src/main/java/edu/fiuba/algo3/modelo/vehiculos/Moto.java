package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;

public class Moto implements TipoVehiculo {
    @Override
    public TipoVehiculo cambiarVehiculo(){
        return new Auto();
    }

    public void aplicarEfecto(Vehiculo vehiculo, Sorpresa sorpresas) {
        sorpresas.aplicarEfecto(vehiculo);
    }

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Obstaculo obstaculos) {
        obstaculos.aplicarEfecto(vehiculo, this);
    }


}
