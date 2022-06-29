package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.ObtaculoView;

public interface Obstaculo {

    void aplicarEfecto(Vehiculo vehiculo, Auto auto);
    void aplicarEfecto(Vehiculo vehiculo, Moto moto);
    public void aplicarEfecto(Vehiculo vehiculo, CuatroPorCuatro cuatroPorCuatro);

    void mostrarImagen(ObtaculoView obtaculoView);

}
