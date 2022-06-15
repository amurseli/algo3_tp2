package edu.fiuba.algo3.modelo.Movimientos;

import edu.fiuba.algo3.modelo.Esquina;

public class Arriba implements Direccion {

    public Arriba(){}

    public Esquina siguiente(Esquina posicion){

        return posicion.obtenerEsquinaArriba();
    }
}
