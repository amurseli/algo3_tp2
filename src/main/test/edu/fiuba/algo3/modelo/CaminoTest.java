package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Direcciones.Izquierda;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CaminoTest {
    @Test
    public void Test01dosCaminosConIgualesEsquinasSonIguales() {
        Camino camino1 = new Camino(new Esquina(1, 3), new Derecha());
        Camino camino2 = new Camino(new Esquina(1, 3), new Derecha());

        assertEquals(camino1, camino2);
    }

    @Test
    public void Test02dosCaminosConEsquinasInvertidasSonIguales() {
        Camino camino1 = new Camino(new Esquina(1, 3), new Derecha());
        Camino camino2 = new Camino(new Esquina(1, 4), new Izquierda());

        assertEquals(camino1, camino2);
    }

    @Test
    public void Test03dosCaminosConDiferentesEsquinasSonDistintos() {
        Camino camino1 = new Camino(new Esquina(1, 3), new Derecha());
        Camino camino2 = new Camino(new Esquina(4, 4), new Izquierda());

        assertNotEquals(camino1, camino2);
    }
    /*@Test
    public void  Test04seCrean2SorpresasYSeAgreganEnUnCaminoGeneraUnError() throws LimiteAlcanzado {
        Sorpresa sorpresa1 = new SorpresaDesfavorable();
        Sorpresa sorpresa2 = new SorpresaFavorable();

        Esquina posicionInicial = new Esquina(1,2);
        Camino camino = new Camino(posicionInicial,new Derecha());

        camino.agregrarEfecto(sorpresa1);

        assertThrows(LimiteAlcanzado.class, () -> {
            camino.agregrarEfecto(sorpresa2);
        });


    }*/
}
