package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Juego {
    Ciudad ciudad;
    Ranking listaDePuntajes;

    String nickname;

    public boolean finDeJuego = false;
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
        System.out.println("SE TERMINO EL JUEGO. HAS GANADO");
        ciudad.datosDePartida(listaDePuntajes,nickname);//harcodeo el nikname porque eso habria que pasarlo cuando se gane como un input
        finDeJuego = true;

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

    public ListadoCaminos obtenerCaminos() {
        return  ciudad.obtenerEfectos();
    }

    public Esquina obtenerMeta() {
        return ciudad.obtenerMeta();
    }

    public Vehiculo obtenerVehiculo(){
        return ciudad.obtenerVehiculo();
    }

    public void nuevaPartida(Esquina limite){
        this.finDeJuego = false;
        this.crearCiudad(limite,new Esquina(1,5),new Vehiculo(new Auto(), new Esquina(5,1)));

        //agrego obstaculos
        for (int i = 0; i < 20; i++){

            GeneradorRandom generadorRandom = new GeneradorRandom();
            Camino camino = new Camino(generadorRandom.generarEsquina(this.obtenerLimite()), generadorRandom.generarDireccion());
            Obstaculo obtaculo = generadorRandom.generarObstaculo();
            camino.agregrarEfecto(obtaculo);
            this.agregarCamino(camino);
        }

        //agrego sorpresas
        for (int i = 0; i < 20 ; i++){
            GeneradorRandom generadorRandom = new GeneradorRandom();
            Camino camino = new Camino(generadorRandom.generarEsquina(this.obtenerLimite()), generadorRandom.generarDireccion());
            Sorpresa sorpresa = generadorRandom.generarSorpresa();
            camino.agregrarEfecto(sorpresa);
            this.agregarCamino(camino);
        }
    }
}
