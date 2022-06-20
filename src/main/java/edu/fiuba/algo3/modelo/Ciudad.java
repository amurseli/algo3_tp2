package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.vehiculos.TipoVehiculo;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Ciudad {
    Vehiculo vehiculo;
    Esquina meta;
    Esquina limite;
    ListadoCaminos caminos;

    Ciudad(Esquina limite, Esquina meta, Vehiculo v){
        this.vehiculo = v;
        this.limite = limite;
        this.meta = meta;
        this.caminos = new ListadoCaminos();
    }
    public int obtenerMovimientosRealizados() {
        return this.vehiculo.obtenerMovimientosRealizados();
    }

    public Vehiculo obtenerVehiculo(){
        return vehiculo;
    }

    public TipoVehiculo obtenerTipoVehiculo(){
        return vehiculo.obtenerTipoVehiculo();
    }

    public Boolean mover(Direccion unaDireccion) {
        Esquina posicionActual = vehiculo.mover(unaDireccion,caminos);
        if (posicionActual.equals(meta)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;

    }

    public void agregarCaminoConEfecto(Camino camino, Efecto efecto){
        caminos.agregarCaminoConEfecto(camino,efecto);
    }


}
