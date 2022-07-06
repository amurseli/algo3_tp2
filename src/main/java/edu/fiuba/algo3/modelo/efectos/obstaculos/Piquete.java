package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.ObservadorPersonalizado.ManejadorDeObservables;
import edu.fiuba.algo3.modelo.ObservadorPersonalizado.ManejadorDeObservablesEfectos;
import edu.fiuba.algo3.modelo.ObservadorPersonalizado.ObservadorEfectos;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Piquete extends ManejadorDeObservablesEfectos implements Obstaculo {


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

    @Override
    public void confirmarAgregacion() {
        System.out.println("SOY UN PIQUETE CONFIRMANDO QUE ME AGREGARON");
        notificar(this);
    }

    @Override
    public void observar(ObservadorEfectos observadorEfectos) {
        addObservador(observadorEfectos);

    }


}




