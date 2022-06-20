package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.efectos.Efecto;
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

    public void agregarCaminoConEfecto(Camino nuevoCamino, Efecto nuevoEfecto){
        ciudad.agregarCaminoConEfecto(nuevoCamino, nuevoEfecto);
    }
    public void mover(Direccion unaDireccion) {
        if(ciudad.mover(unaDireccion)){
            System.out.println("SE TERMINO EL JUEGO. HAS GANADO");
            Puntaje nuevoPuntaje = new Puntaje(this.obtenerMovimientosRealizados(),"JUANCITO"); //harcodeo el nikname porque eso habria que pasarlo cuando se gane como un input
            this.listaDePuntajes.agregarPuntaje(nuevoPuntaje);
            listaDePuntajes.mostrarRanking();
        };
    }

    public Esquina devolverLimite(){
        return ciudad.obtenerLimite();
    }

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
