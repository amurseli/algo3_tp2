package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.dnd.DragGestureEvent;

import static org.junit.jupiter.api.Assertions.*;

public class GeneradorRandomTest {
    @Test
    public void devuelveUnNumeroEntero() {
        GeneradorRandom generador = new GeneradorRandom();
        int generado = generador.generarRandomInt(1,10);
        assertEquals((int)generado, generado);
    }

    @Test
    public void generarUnaDireccionRandomDevuelveDerecha(){

        GeneradorRandom stubGeneradorRandom = Mockito.mock(GeneradorRandom.class);
        Mockito.when(stubGeneradorRandom.generarDireccion()).thenReturn(new Derecha());
        Direccion direccion = stubGeneradorRandom.generarDireccion();
        assertEquals(direccion.getClass(), Derecha.class);

    }
    @Test
    public void generarUnaDireccionRandomDevuelveAbajo(){

        GeneradorRandom stubGeneradorRandom = Mockito.mock(GeneradorRandom.class);
        Mockito.when(stubGeneradorRandom.generarDireccion()).thenReturn(new Abajo());
        Direccion direccion = stubGeneradorRandom.generarDireccion();
        assertEquals(direccion.getClass(), Abajo.class);

    }
    @Test
    public void generarUnaDireccionRandomDevuelveIzquierda(){

        GeneradorRandom stubGeneradorRandom = Mockito.mock(GeneradorRandom.class);
        Mockito.when(stubGeneradorRandom.generarDireccion()).thenReturn(new Izquierda());
        Direccion direccion = stubGeneradorRandom.generarDireccion();
        assertEquals(direccion.getClass(), Izquierda.class);

    }
    @Test
    public void generarUnaDireccionRandomDevuelveArriba(){

        GeneradorRandom stubGeneradorRandom = Mockito.mock(GeneradorRandom.class);
        Mockito.when(stubGeneradorRandom.generarDireccion()).thenReturn(new Arriba());
        Direccion direccion = stubGeneradorRandom.generarDireccion();
        assertEquals(direccion.getClass(), Arriba.class);

    }
    @Test
    public void generarUnaEsquinaAleatoriaDevuelveUnaEsquinaDentroDelLimite(){
        Esquina limite = new Esquina(10,10);
        GeneradorRandom generadorRandom = new GeneradorRandom();
        Esquina esquina = generadorRandom.generarEsquina(limite);
        assertTrue(esquina.estaDentroDelLimite(limite));
    }

    @Test
    public void generarUnObstaculoAleatorioGeneraUnObtaculo(){
        GeneradorRandom generadorRandom = new GeneradorRandom();
        Obstaculo obstaculo = generadorRandom.generarObstaculo();
        assertEquals((Obstaculo)obstaculo, obstaculo);
    }

    @Test
    public void generarUnaSorpresaAleatoriaDevuelveUnaSorpresa(){
        GeneradorRandom generadorRandom = new GeneradorRandom();
        Sorpresa sorpresa = generadorRandom.generarSorpresa();
        assertEquals((Sorpresa)sorpresa, sorpresa);
    }
}
