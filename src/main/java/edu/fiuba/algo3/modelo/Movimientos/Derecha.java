package edu.fiuba.algo3.modelo.Movimientos;

import edu.fiuba.algo3.modelo.Esquina;

public class Derecha implements Direccion {

    public Derecha(){}

    public Esquina siguiente(Esquina posicion){

        return posicion.obtenerEsquinaDerecha();
    }

}
