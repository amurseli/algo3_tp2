package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.Abajo;
import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
