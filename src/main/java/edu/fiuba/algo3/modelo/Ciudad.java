package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.Direccion;
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

    public Boolean vehiculoEnEsquina(Esquina unaEsquina){
        return vehiculo.enEsquina(unaEsquina);
    }

    public Object obtenerTipoVehiculo(){
        return vehiculo.obtenerTipoVehiculo();
    }

    public Boolean mover(Direccion unaDireccion) {
        Esquina posicionActual = vehiculo.mover(unaDireccion,caminos, limite);
        return (posicionActual.equals(meta));
    }

    public void datosDePartida(Ranking listaDePuntajes, String nickname){
        vehiculo.datosDePartida(listaDePuntajes,nickname);
    }

    public void agregarCamino(Camino camino){
        caminos.agregarCamino(camino);
    }

    public Esquina obtenerLimite() {
        return limite;
    }

    public ListadoCaminos obtenerCaminosConEfectos() {
        return caminos;
    }

    public Esquina obtenerMeta() {
        return meta;
    }

    public Vehiculo obtenerVehiculo() {
        return vehiculo;
    }
}
