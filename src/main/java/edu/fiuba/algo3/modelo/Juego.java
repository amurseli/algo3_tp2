package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.vehiculos.TipoVehiculo;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Juego {
    Ciudad ciudad;

    Ranking listaDePuntajes;
    public Juego(){
        this.listaDePuntajes = new Ranking();
    }

    public void crearCiudad(Esquina limite, Esquina meta, Vehiculo vehiculo) {
        this.ciudad = new Ciudad(limite, meta, vehiculo);
    }

    public void agregarCamino(Camino nuevoCamino){
        ciudad.agregarCamino(nuevoCamino);
    }
    public void mover(Direccion unaDireccion) {
        if(ciudad.mover(unaDireccion)){
            finDelJuego();
        };
    }

    private void finDelJuego(){
        System.out.println("SE TERMINO EL JUEGO. HAS GANADO");
        ciudad.datosDePartida(listaDePuntajes,"JUANCITO");//harcodeo el nikname porque eso habria que pasarlo cuando se gane como un input
        listaDePuntajes.mostrarRanking();
    }

    public Esquina devolverLimite(){
        return ciudad.obtenerLimite();
    }

    public Boolean vehiculoEnEsquina(Esquina unaEsquina){
        return ciudad.vehiculoEnEsquina(unaEsquina);
    }

    public Esquina obtenerPosicionVehiculo(){
        return ciudad.obtenerPosicionVehiculo();
    }

    public Object obtenerTipoVehiculo(){
        return ciudad.obtenerTipoVehiculo();
    }

    public int obtenerMovimientosRealizados() {
        return this.ciudad.obtenerMovimientosRealizados();
    }

    public ListadoCaminos obtenerEfectos() {
        return  ciudad.obtenerEfectos();
    }

    public Esquina obtenerMeta() {
        return ciudad.obtenerMeta();
    }
}
