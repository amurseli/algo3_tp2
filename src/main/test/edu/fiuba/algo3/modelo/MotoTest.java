package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotoTest {
    @Test
    public void Test01CreoUnVehiculoCorrectamente(){
        Moto v = new Moto(new Esquina(1,1));
        Esquina e = new Esquina(1,1);
        Assertions.assertEquals(v.posicion,e);
    }
    @Test
    public void Test02MotoPasaPorPozoYSeRetornaCorrectamente(){
        Juego juego = new Juego();
        juego.crearCiudad(10, 10, new Esquina(1, 10), new Moto(new Esquina(1,5)));
        juego.agregarEfecto(new Pozo(new Camino(new Esquina(1,5),new Esquina(1,6))));
        juego.moverDerecha();
        //assertEquals();
    }
}
