package edu.fiuba.algo3.modelo.efectos.obstaculos;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class ControlPolicial extends Efecto {

    public ControlPolicial(Camino c) {
        super(c);
    }

    public void aplicarEfecto(Camino caminoRecorrido,Jugador jugador,Vehiculo vehiculo) {
        if(posicion.equals(caminoRecorrido)){
            vehiculo.aplicarEfecto(this);
        }
    }
}
