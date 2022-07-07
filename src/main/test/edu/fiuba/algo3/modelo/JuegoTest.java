package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JuegoTest {
    @Test
    public void seCreaLaCiudadConElLosValoresCorrectos() {
        Esquina limite = new Esquina(10,10);
        Esquina meta = new Esquina(5,5);
        Vehiculo vehiculo = new Vehiculo(new Moto(), new Esquina(0,0));
        Juego juego = new Juego();
        juego.crearCiudad(limite, meta, vehiculo);
        Assertions.assertEquals(juego.obtenerLimite(), limite);
        Assertions.assertEquals(juego.obtenerMeta(), meta);
        Assertions.assertEquals(juego.obtenerVehiculo(), vehiculo);
    }

    @Test
    public void seAgregaUnCaminoCorrectamente() {
        Juego juego = new Juego();
        Camino camino = new Camino(new Esquina(1, 5), new Derecha());
        camino.agregrarEfecto(new Pozo());
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new Moto(), new Esquina(1, 6)));
        juego.agregarCamino(camino);
        ListadoCaminos caminos = juego.obtenerCaminosConEfectos();
        assertTrue(caminos.caminoExiste(camino));
    }
}
