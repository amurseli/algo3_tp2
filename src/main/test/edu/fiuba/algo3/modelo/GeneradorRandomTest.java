package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeneradorRandomTest {
    @Test
    public void devuelveUnNumeroEntero() {
        GeneradorRandom generador = new GeneradorRandom();
        int generado = generador.generarRandomInt(1,10);
        assertEquals((int)generado, generado);
    }
}
