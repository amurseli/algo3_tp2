package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CaminoTest {
    @Test
    public void Test01dosCaminosConIgualesEsquinasSonIguales() {
        Camino camino1 = new Camino(new Esquina(1, 3), new Esquina(1,4));
        Camino camino2 = new Camino(new Esquina(1, 3), new Esquina(1,4));

        assertEquals(camino1, camino2);
    }

    @Test
    public void Test02dosCaminosConEsquinasInvertidasSonIguales() {
        Camino camino1 = new Camino(new Esquina(1, 3), new Esquina(1,4));
        Camino camino2 = new Camino(new Esquina(1, 4), new Esquina(1,3));

        assertEquals(camino1, camino2);
    }

    @Test
    public void Test03dosCaminosConDiferentesEsquinasSonDistintos() {
        Camino camino1 = new Camino(new Esquina(1, 3), new Esquina(1,4));
        Camino camino2 = new Camino(new Esquina(4, 4), new Esquina(4,3));

        assertNotEquals(camino1, camino2);
    }
}
