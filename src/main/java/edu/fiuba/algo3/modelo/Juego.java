package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.vehiculos.TipoVehiculo;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Juego {
    Ciudad ciudad;
    public Juego(){}

    public void crearCiudad(Esquina limite, Esquina meta, Vehiculo vehiculo) {
        this.ciudad = new Ciudad(limite, meta, vehiculo);
    }

    public void agregarCaminoConEfecto(Camino nuevoCamino, Efecto nuevoEfecto){
        ciudad.agregarCaminoConEfecto(nuevoCamino, nuevoEfecto);
    }
    public void mover(Direccion unaDireccion) { ciudad.mover(unaDireccion);}

    public Vehiculo obtenerVehiculo(){
        return ciudad.obtenerVehiculo();
    }

    public TipoVehiculo obtenerTipoVehiculo(){
        return ciudad.obtenerTipoVehiculo();
    }

    public int obtenerMovimientosRealizados() {
        return this.ciudad.obtenerMovimientosRealizados();
    }

}
