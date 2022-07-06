package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.ObservadorPersonalizado.ManejadorDeObservables;
import edu.fiuba.algo3.modelo.ObservadorPersonalizado.ManejadorDeObservablesEfectos;
import edu.fiuba.algo3.modelo.ObservadorPersonalizado.ObservadorEfectos;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Pozo extends ManejadorDeObservablesEfectos implements Obstaculo {

    public void aplicarEfecto(Vehiculo vehiculo, Auto auto) {
        vehiculo.sumarMovimientos(3);
    }

    public void aplicarEfecto(Vehiculo vehiculo, Moto moto) {
        vehiculo.sumarMovimientos(3);
    }


    public void aplicarEfecto(Vehiculo vehiculo, CuatroPorCuatro cuatroPorCuatro) {
        cuatroPorCuatro.sumarPozoPisado();
        if(cuatroPorCuatro.elProximoPozoEsPenalizable()){
            vehiculo.sumarMovimientos(2);
            cuatroPorCuatro.reinciarPozosPizados();
        }
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
