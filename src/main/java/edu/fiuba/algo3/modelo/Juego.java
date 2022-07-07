package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

import java.util.Observable;

public class Juego extends Observable {
    Ciudad ciudad;
    Ranking listaDePuntajes;
    String nickname;


    public Juego(){
        this.listaDePuntajes = new Ranking();
    }

    public void asignarNickname(String nickname){
        this.nickname = nickname;
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

    public Ranking obtenerRanking(){
        return listaDePuntajes;
    }

    private void finDelJuego(){
        ciudad.datosDePartida(listaDePuntajes,nickname);
        setChanged();
        notifyObservers();

    }

    public Esquina obtenerLimite(){
        return ciudad.obtenerLimite();
    }

    public Boolean vehiculoEnEsquina(Esquina unaEsquina){
        return ciudad.vehiculoEnEsquina(unaEsquina);
    }

    public Object obtenerTipoVehiculo(){
        return ciudad.obtenerTipoVehiculo();
    }

    public int obtenerMovimientosRealizados() {
        return this.ciudad.obtenerMovimientosRealizados();
    }

    public ListadoCaminos obtenerCaminosConEfectos() {
        return  ciudad.obtenerCaminosConEfectos();
    }

    public Esquina obtenerMeta() {
        return ciudad.obtenerMeta();
    }

    public Vehiculo obtenerVehiculo(){
        return ciudad.obtenerVehiculo();
    }

    public void nuevaPartida(Esquina limite){
        GeneradorRandom generadorRandom = new GeneradorRandom();

        Esquina comienzo = new Esquina(0,0);
        this.crearCiudad(limite,limite,new Vehiculo(new Auto(), comienzo));

        Integer cantidadDeCaminos = (limite.fila + limite.columna) / 2 * 3;

        //agrego los caminos
        for (int i = 0; i < (cantidadDeCaminos); i++){

            Camino camino = new Camino(generadorRandom.generarEsquina(this.obtenerLimite()), generadorRandom.generarDireccion());
            this.agregarCamino(camino);
        }

    }
}
