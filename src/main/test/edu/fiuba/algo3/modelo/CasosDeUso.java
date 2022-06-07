package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Juego;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUso {

    @Test
    public void Test01MotoPasaPorUnPozoYEsPenalizadaEnTresMovimientos(){
        Juego juego = new Juego();

        juego.moverDerecha();

        assertEquals(juego.obtenerMovimientosRealizados(), 4);
    }
}
