package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MetaTest {

    @Test
    public void VehiculoLlegaALaMetaYGana() {
        Ciudad ciudad = new Ciudad(new Esquina(10, 10), new Esquina(1, 2), new Vehiculo(new Auto(),new Esquina(1, 1)));

        Assertions.assertTrue(ciudad.mover(new Derecha()));
    }

    @Test
    public void DosJugadoresJueganMaspasDistintosYGananYSeVenEnElRanqking() {
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 3), new Vehiculo(new Auto(), new Esquina(1, 1)));

        juego.mover(new Derecha());
        juego.mover(new Derecha());

        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 5), new Vehiculo(new Auto(), new Esquina(1, 1)));

        juego.mover(new Derecha());
        juego.mover(new Derecha());
        juego.mover(new Derecha());
        juego.mover(new Derecha());

    }
}
