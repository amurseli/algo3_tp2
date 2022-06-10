package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.vehiculos.Auto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovimientosTest {
    @Test
    public void Test01MoverseIzquierda(){
        Juego juego = new Juego();
        juego.crearCiudad(10,10,new Esquina(10,10),new Auto(new Esquina(2,2)));
        juego.moverIzquierda();
        Assertions.assertEquals(juego.ciudad.jugador.vehiculo.posicion, new Esquina(2,1));
    }
    @Test
    public void Test02MoverseDerecha(){
        Juego juego = new Juego();
        juego.crearCiudad(10,10,new Esquina(10,10),new Auto(new Esquina(2,2)));
        juego.moverDerecha();
        Assertions.assertEquals(juego.ciudad.jugador.vehiculo.posicion, new Esquina(2,3));
    }
    @Test
    public void Test03MoverseArriba(){
        Juego juego = new Juego();
        juego.crearCiudad(10,10,new Esquina(10,10),new Auto(new Esquina(2,2)));
        juego.moverArriba();
        Assertions.assertEquals(juego.ciudad.jugador.vehiculo.posicion, new Esquina(1,2));
    }
    @Test
    public void Test04MoverseAbajo(){
        Juego juego = new Juego();
        juego.crearCiudad(10,10,new Esquina(10,10),new Auto(new Esquina(2,2)));
        juego.moverAbajo();
        Assertions.assertEquals(juego.ciudad.jugador.vehiculo.posicion, new Esquina(3,2));
    }
    @Test
    public void Test05ProbarMovimientosRealizados(){
        Juego juego = new Juego();
        juego.crearCiudad(10,10,new Esquina(10,10),new Auto(new Esquina(2,2)));
        juego.moverIzquierda();
        Assertions.assertEquals(juego.obtenerMovimientosRealizados(), 1);
    }
}
