package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Puntaje;

public class Vehiculo {
    private Esquina posicion;
    public Esquina posicionAnterior;
    private int movimientos;
    private TipoVehiculo estado;

    public Vehiculo(TipoVehiculo tipo, Esquina posicion) {
        this.estado = tipo;
        this.posicion = posicion;
        movimientos = 0;
    }

    public int obtenerMovimientosRealizados() {
        return this.movimientos;
    }

    public Esquina obtenerPosicion(){
        return posicion;
    }
    public Object obtenerTipoVehiculo() {//METODO USADO SOLO EN PRUEBAS
        return (estado.getClass());
    }

    public Esquina mover(Direccion unaDireccion, ListadoCaminos caminos, Esquina limite) {
        Esquina nuevaEsquina = unaDireccion.siguiente(posicion);

        if(!validarPosicion(limite,nuevaEsquina)){

            sumarMovimientos(1);
            asignarPosicion(nuevaEsquina);
            Camino caminoRecorrido = caminos.obtenerCaminoRecorrido(new Camino(posicionAnterior, unaDireccion));
            caminoRecorrido.aplicarEfecto(this,estado);
        }

        return posicion;
    }

    public void asignarPosicion(Esquina nuevaPosicion) {
        posicionAnterior = posicion;
        posicion = nuevaPosicion;
    }

    public void darLaVuelta(){
        posicion = posicionAnterior;
    }

    public void sumarMovimientos(int m) {
        this.movimientos += m;
    }

    public void aplicarPorcentaje(double porcentaje){
        movimientos = movimientos + (int)(movimientos * porcentaje);
    }

    public void cambiarTipo() {
        this.estado = this.estado.cambiarVehiculo();
    }

    public boolean validarPosicion(Esquina limite, Esquina nuevaEsquina){
        return nuevaEsquina.getFila() < 0 || nuevaEsquina.getColumna() < 0 ||
                nuevaEsquina.getFila() > limite.getFila() || nuevaEsquina.getColumna() > limite.getColumna();
    }

    public void datosDePartida(Ranking listaDePuntajes, String nickname){
        Puntaje nuevoPuntaje = new Puntaje(movimientos,nickname);
        listaDePuntajes.agregarPuntaje(nuevoPuntaje);
    }

    public Boolean enEsquina(Esquina unaEsquina){
        return (posicion.equals(unaEsquina));
    }
}
