package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.efectos.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaFavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaNull;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import javafx.scene.image.Image;

public interface ObservadorSorpresa {

    void actualizar(SorpresaFavorable unSorpresaFavorable);

    void actualizar(SorpresaDesfavorable unSorpresaDesfavorable);
    void actualizar(CambioDeVehiculo unCambioDeVehiculo);
    void actualizar(SorpresaNull unSorpresaNull);

}
