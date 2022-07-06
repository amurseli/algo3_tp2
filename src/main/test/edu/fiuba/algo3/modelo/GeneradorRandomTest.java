package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;
import org.junit.jupiter.api.Test;
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
        GeneradorRandom generadorRandom = new GeneradorRandom();
        Direccion direccion = generadorRandom.generarDireccion();
        assertEquals((Direccion)direccion, direccion);
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
