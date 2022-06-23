package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.Abajo;
import edu.fiuba.algo3.modelo.Direcciones.Arriba;
import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Direcciones.Izquierda;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovimientosTest {
    @Test
    public void Test01MoverseIzquierda(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10),new Esquina(10,10),new Vehiculo(new Auto(), new Esquina(2,2)));
        juego.mover(new Izquierda());
        Assertions.assertEquals(juego.ciudad.vehiculo.posicion, new Esquina(2,1));
    }
    @Test
    public void Test02MoverseDerecha(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10),new Esquina(10,10),new Vehiculo(new Auto(), new Esquina(2,2)));
        juego.mover(new Derecha());
        Assertions.assertEquals(juego.ciudad.vehiculo.posicion, new Esquina(2,3));
    }
    @Test
    public void Test03MoverseArriba(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10),new Esquina(10,10),new Vehiculo(new Auto(), new Esquina(2,2)));
        juego.mover(new Arriba());
        Assertions.assertEquals(juego.ciudad.vehiculo.posicion, new Esquina(1,2));
    }
    @Test
    public void Test04MoverseAbajo(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10),new Esquina(10,10),new Vehiculo(new Auto(), new Esquina(2,2)));
        juego.mover(new Abajo());
        Assertions.assertEquals(juego.ciudad.vehiculo.posicion, new Esquina(3,2));
    }
    @Test
    public void Test05ProbarMovimientosRealizados(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10),new Esquina(10,10),new Vehiculo(new Auto(), new Esquina(2,2)));
        juego.mover(new Izquierda());
        Assertions.assertEquals(juego.obtenerMovimientosRealizados(), 1);
    }
    @Test
    public void Test06MuevoAbajoYSeAplicaEfectoPozo(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10),new Esquina(10,10),new Vehiculo(new Auto(), new Esquina(1,5)));
        Camino camino = new Camino(new Esquina(1,5), new Abajo());
        camino.agregrarEfecto(new Pozo());
        juego.agregarCamino(camino);

        juego.mover(new Abajo());
        Assertions.assertEquals(juego.obtenerMovimientosRealizados(), 4);
    }
    @Test
    public void Test07MuevoArribaYSeAplicaEfectoPiquete(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10),new Esquina(10,10),new Vehiculo(new Auto(), new Esquina(2,5)));
        Camino camino = new Camino(new Esquina(1,5), new Abajo());
        camino.agregrarEfecto(new Piquete());
        juego.agregarCamino(camino);

        juego.mover(new Arriba());
        Assertions.assertEquals(juego.obtenerVehiculo().obtenerPosicion(), new Esquina(2, 5));

    }
    @Test
    public void Test08MuevoIzquierdaYSeAplicaEfectoSorpresaDesfavorable(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10),new Esquina(10,10),new Vehiculo(new Auto(), new Esquina(1,5)));
        Camino camino = new Camino(new Esquina(1,5), new Abajo());
        camino.agregrarEfecto(new SorpresaDesfavorable());
        juego.agregarCamino(camino);

        juego.mover(new Derecha());
        juego.mover(new Izquierda());
        juego.mover(new Derecha());
        juego.mover(new Izquierda());
        juego.mover(new Derecha());
        juego.mover(new Izquierda());
        juego.mover(new Derecha());
        juego.mover(new Izquierda());
        juego.mover(new Derecha());
        juego.mover(new Izquierda());
        juego.mover(new Abajo());

        Assertions.assertEquals(juego.obtenerMovimientosRealizados(), 13);
    }
}
