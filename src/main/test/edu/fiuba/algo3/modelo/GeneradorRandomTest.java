package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.GeneradoresRandom.GeneradorRandom;
import edu.fiuba.algo3.modelo.GeneradoresRandom.GeneradorRandomObstaculos;
import edu.fiuba.algo3.modelo.GeneradoresRandom.GeneradorRandomSorpresas;
import edu.fiuba.algo3.modelo.efectos.obstaculos.*;
import edu.fiuba.algo3.modelo.efectos.sorpresas.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class GeneradorRandomTest {
    @Test
    public void devuelveUnNumeroEntero() {
        GeneradorRandom generador = new GeneradorRandom();
        int generado = generador.generarRandomInt(1,10);
        assertEquals((int)generado, generado);
    }
    @Test
    public void generarUnaDireccionRandomDevuelveUnaDireccion(){
        GeneradorRandom generador = new GeneradorRandom();
        Direccion direccion = generador.generarDireccion();
        Object claseGenerada = direccion.getClass();
        assertTrue(
                claseGenerada == Arriba.class
                || claseGenerada == Abajo.class
                || claseGenerada == Derecha.class
                || claseGenerada == Izquierda.class
        );
    }
    @Test
    public void generarUnObstaculoRandomDevuelveUnObstaculo(){
        GeneradorRandomObstaculos generador = new GeneradorRandomObstaculos();
        Obstaculo obstaculo = generador.generarObstaculo();
        Object claseGenerada = obstaculo.getClass();
        assertTrue(
                claseGenerada == Pozo.class
                        || claseGenerada == ControlPolicial.class
                        || claseGenerada == Piquete.class
                        || claseGenerada == ObstaculoNull.class
        );
    }
    @Test
    public void generarUnaSorpresaRandomDevuelveUnaSorpresa(){
        GeneradorRandomSorpresas generador = new GeneradorRandomSorpresas();
        Sorpresa sorpresa = generador.generarSorpresa();
        Object claseGenerada = sorpresa.getClass();
        assertTrue(
                claseGenerada == SorpresaDesfavorable.class
                        || claseGenerada == SorpresaFavorable.class
                        || claseGenerada == CambioDeVehiculo.class
                        || claseGenerada == SorpresaNull.class
        );
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
    public void generarUnObstaculoAleatorioGeneraUnPozo(){

        GeneradorRandomObstaculos stubGeneradorRandom = Mockito.mock(GeneradorRandomObstaculos.class);
        Mockito.when(stubGeneradorRandom.generarObstaculo()).thenReturn(new Pozo());
        Obstaculo obstaculo = stubGeneradorRandom.generarObstaculo();
        assertEquals(obstaculo.getClass(), Pozo.class);
    }
    @Test
    public void generarUnObstaculoAleatorioGeneraUnControlPolicial(){

        GeneradorRandomObstaculos stubGeneradorRandom = Mockito.mock(GeneradorRandomObstaculos.class);
        Mockito.when(stubGeneradorRandom.generarObstaculo()).thenReturn(new ControlPolicial(new GeneradorRandom()));
        Obstaculo obstaculo = stubGeneradorRandom.generarObstaculo();
        assertEquals(obstaculo.getClass(), ControlPolicial.class);
    }

    @Test
    public void generarUnObstaculoAleatorioGeneraUnPiquete(){

        GeneradorRandomObstaculos stubGeneradorRandom = Mockito.mock(GeneradorRandomObstaculos.class);
        Mockito.when(stubGeneradorRandom.generarObstaculo()).thenReturn(new Piquete());
        Obstaculo obstaculo = stubGeneradorRandom.generarObstaculo();
        assertEquals(obstaculo.getClass(), Piquete.class);
    }

    @Test
    public void generarUnaSorpresaAleatoriaDevuelveUnaSorpresaDeCambioDeVehiculo(){
        GeneradorRandomSorpresas stubGeneradorRandom = Mockito.mock(GeneradorRandomSorpresas.class);
        Mockito.when(stubGeneradorRandom.generarSorpresa()).thenReturn(new CambioDeVehiculo());
        Sorpresa sorpresa = stubGeneradorRandom.generarSorpresa();
        assertEquals(sorpresa.getClass(), CambioDeVehiculo.class);
    }

    @Test
    public void generarUnaSorpresaAleatoriaDevuelveUnaSorpresaFavorable(){
        GeneradorRandomSorpresas stubGeneradorRandom = Mockito.mock(GeneradorRandomSorpresas.class);
        Mockito.when(stubGeneradorRandom.generarSorpresa()).thenReturn(new SorpresaFavorable());
        Sorpresa sorpresa = stubGeneradorRandom.generarSorpresa();
        assertEquals(sorpresa.getClass(), SorpresaFavorable.class);
    }

    @Test
    public void generarUnaSorpresaAleatoriaDevuelveUnaSorpresaDesfavorable(){
        GeneradorRandomSorpresas stubGeneradorRandom = Mockito.mock(GeneradorRandomSorpresas.class);
        Mockito.when(stubGeneradorRandom.generarSorpresa()).thenReturn(new SorpresaDesfavorable());
        Sorpresa sorpresa = stubGeneradorRandom.generarSorpresa();
        assertEquals(sorpresa.getClass(), SorpresaDesfavorable.class);
    }
}
