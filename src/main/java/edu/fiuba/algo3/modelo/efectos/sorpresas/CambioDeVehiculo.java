package edu.fiuba.algo3.modelo.efectos.sorpresas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class CambioDeVehiculo extends Sorpresa {

    public void aplicarEfecto(Jugador jugador, Auto auto) {
        jugador.setVehiculo(auto.cambiarVehiculo());
    }

    public void aplicarEfecto(Jugador jugador, Moto moto) {
        jugador.setVehiculo(moto.cambiarVehiculo());
    }

    public void aplicarEfecto(Jugador jugador, CuatroPorCuatro cuatroPorCuatro){
        jugador.setVehiculo(cuatroPorCuatro.cambiarVehiculo());
    }
}
