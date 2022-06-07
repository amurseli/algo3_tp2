package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EsquinaTest {
    @Test
    public void dosEsquinasConIgualFilaYColumnaSonIguales() {
        Esquina esquina1 = new Esquina(1, 3);
        Esquina esquina2 = new Esquina(1, 3);

        assertEquals(esquina1, esquina2);
    }

    @Test
    public void dosEsquinasConDistintaFilaNoSonIguales() {
        Esquina esquina1 = new Esquina(1, 3);
        Esquina esquina2 = new Esquina(2, 3);

        assertNotEquals(esquina1, esquina2);
    }

    @Test
    public void dosEsquinasConDistintaColumnaNoSonIguales() {
        Esquina esquina1 = new Esquina(2, 1);
        Esquina esquina2 = new Esquina(2, 3);

        assertNotEquals(esquina1, esquina2);
    }

    @Test
    public void puedoObtenerLaEsquinaDerecha() {
        Esquina esquina1 = new Esquina(1, 2);
        Esquina esquina2 = new Esquina(1, 3);

        assertEquals(esquina1.obtenerEsquinaDerecha(), esquina2);
    }

    @Test
    public void puedoObtenerLaEsquinaIzquierda() {
        Esquina esquina1 = new Esquina(1, 3);
        Esquina esquina2 = new Esquina(1, 2);

        assertEquals(esquina1.obtenerEsquinaIzquierda(), esquina2);
    }

    @Test
    public void puedoObtenerLaEsquinaArriba() {
        Esquina esquina1 = new Esquina(2, 2);
        Esquina esquina2 = new Esquina(1, 2);

        assertEquals(esquina1.obtenerEsquinaArriba(), esquina2);
    }

    @Test
    public void puedoObtenerLaEsquinaAbajo() {
        Esquina esquina1 = new Esquina(1, 2);
        Esquina esquina2 = new Esquina(2, 2);

        assertEquals(esquina1.obtenerEsquinaAbajo(), esquina2);
    }
}
