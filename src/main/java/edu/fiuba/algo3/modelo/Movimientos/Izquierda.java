package edu.fiuba.algo3.modelo.Movimientos;

import edu.fiuba.algo3.modelo.Esquina;

public class Izquierda implements Direccion {

    public Izquierda(){}

    public Esquina siguiente(Esquina posicion){

        return posicion.obtenerEsquinaIzquierda();
    }
}
