package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;

public class CuatroPorCuatro implements TipoVehiculo {
    int pozosPisados = 0;

    public void sumarPozoPisado(){
        pozosPisados += 1;
    }

    public void reinciarPozosPizados(){
        pozosPisados = 0;
    }

    public boolean elProximoPozoEsPenalizable(){
        boolean esPenalizable;
        esPenalizable = pozosPisados > 2;
        return esPenalizable;
    }

    @Override
    public TipoVehiculo cambiarVehiculo(){
        return new Moto();
    }

    public void aplicarEfecto(Vehiculo vehiculo, Sorpresa sorpresas) {
        sorpresas.aplicarEfecto(vehiculo);
    }

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Obstaculo obstaculos) {
        obstaculos.aplicarEfecto(vehiculo, this);
    }

}
