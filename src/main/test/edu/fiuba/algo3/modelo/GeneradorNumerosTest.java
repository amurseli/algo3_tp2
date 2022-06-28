package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeneradorNumerosTest {
    @Test
    public void devuelveUnNumeroEntero() {
        GeneradorNumeros generador = new GeneradorNumeros();
        int generado = generador.generarRandom();
        assertEquals((int)generado, generado);
    }
}
