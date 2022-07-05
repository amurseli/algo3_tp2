package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Piquete implements Obstaculo {

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Auto auto) {
        vehiculo.darLaVuelta();
    }
    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Moto moto) {
        vehiculo.sumarMovimientos(2);
    }
    @Override
    public void aplicarEfecto(Vehiculo vehiculo, CuatroPorCuatro cuatroPorCuatro) {
        vehiculo.darLaVuelta();
    }

    public void mostrarImagen(ObstaculoView obstaculoView){
        obstaculoView.mostrarImagen(this);
    }
}




