package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class CambioDeVehiculo extends Sorpresa {

    public void aplicarEfecto(Jugador jugador, Auto auto) {
        jugador.setVehiculo(new CuatroPorCuatro(auto.posicion));
    }

    public void aplicarEfecto(Jugador jugador, Moto moto) {
        jugador.setVehiculo(new Auto(moto.posicion));
    }

    public void aplicarEfecto(Jugador jugador, CuatroPorCuatro cuatroPorCuatro){
        jugador.setVehiculo(new Moto(cuatroPorCuatro.posicion));
    }
}
