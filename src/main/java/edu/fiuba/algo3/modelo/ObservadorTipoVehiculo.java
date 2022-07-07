package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;

public interface ObservadorTipoVehiculo {

     void actualizar(Moto unamoto);
     void actualizar(Auto unaAuto);
     void actualizar(CuatroPorCuatro unaCamioneta);

}
