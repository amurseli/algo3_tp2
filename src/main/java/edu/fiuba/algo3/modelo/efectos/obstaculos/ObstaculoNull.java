package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.ObservadorPersonalizado.ManejadorDeObservables;
import edu.fiuba.algo3.modelo.ObservadorPersonalizado.ManejadorDeObservablesEfectos;
import edu.fiuba.algo3.modelo.ObservadorPersonalizado.ObservadorEfectos;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class ObstaculoNull extends ManejadorDeObservablesEfectos implements Obstaculo{

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Auto auto) {
    }

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, Moto moto) {

    }

    @Override
    public void aplicarEfecto(Vehiculo vehiculo, CuatroPorCuatro cuatroPorCuatro) {

    }

    @Override
    public void confirmarAgregacion() {
        notificar(this);
    }

    @Override
    public void observar(ObservadorEfectos observadorEfectos) {
        addObservador(observadorEfectos);

    }


}
