package edu.fiuba.algo3.modelo.Movimientos;

import edu.fiuba.algo3.modelo.Esquina;

public class Abajo implements Direccion {

    public Abajo(){}

    public Esquina siguiente(Esquina posicion){

        return posicion.obtenerEsquinaAbajo();
    }
}
