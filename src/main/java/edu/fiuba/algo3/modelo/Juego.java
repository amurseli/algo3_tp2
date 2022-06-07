package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Juego {
    Ciudad ciudad;
    public Juego(){}

    public void crearCiudad(int tamanioFilas,int tamanioColumnas, Esquina meta, Vehiculo vehiculo) {
        this.ciudad = new Ciudad(tamanioFilas,tamanioColumnas, meta, vehiculo);
    }

    public void agregarEfecto(Efecto efecto){
        ciudad.agregarEfecto(efecto);
    }
    public void moverDerecha() {
        ciudad.moverDerecha();
    }


    public int obtenerMovimientosRealizados() {
        return this.ciudad.obtenerMovimientosRealizados();
    }
}
