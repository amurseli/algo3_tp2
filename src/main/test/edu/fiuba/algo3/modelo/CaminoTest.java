package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Direcciones.Izquierda;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.*;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.TipoVehiculo;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Assertions;
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

    @Test
    public void Test02UnCaminoTieneDosEfectosSePasaPorLosEfectosSeEliminaLaSorpresaQuedaElObstaculo() {
        ListadoCaminos lista = new ListadoCaminos();
        Camino camino = new Camino(new Esquina(1,2),new Derecha());
        camino.agregrarEfecto(new SorpresaFavorable());
        camino.agregrarEfecto(new Pozo());

        lista.agregarCamino(camino);
        TipoVehiculo estado = new Moto();
        Vehiculo unVehiculo = new Vehiculo(estado,new Esquina(1,1));

        camino.aplicarEfecto(unVehiculo,estado);

        Assertions.assertEquals(camino.obtenerCantidadEfectos(), 1);
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
