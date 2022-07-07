package edu.fiuba.algo3.modelo.ObserverPersonalizado;

import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ObstaculoNull;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaFavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaNull;

public interface ObservadorObstaculo {
    void actualizar(Piquete piquete);

    void actualizar(ControlPolicial controlPolicial);
    void actualizar(Pozo pozo);
    void actualizar(ObstaculoNull obstaculoNull);
}
