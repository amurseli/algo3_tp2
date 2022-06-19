package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.efectos.Efecto;

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

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Efecto efecto) {
        efecto.aplicarEfecto(vehiculo, this);
    }

}
