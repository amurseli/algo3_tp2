package edu.fiuba.algo3.modelo.efectos;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public abstract class Efecto {
    protected Camino posicion;

    protected Efecto(Camino c) {
        this.posicion = c;
    }

    public Camino obtenerPosicion(){
        return posicion;
    }

    public abstract void aplicarEfecto(Camino caminoRecorrido, Jugador jugador, Vehiculo vehiculo);
}
