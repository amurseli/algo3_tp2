package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotoTest {
    @Test
    public void Test01CreoUnVehiculoCorrectamenteSeLeAsignaUnaPosicionYseSolicitaLaPosicion(){
        Vehiculo moto = new Vehiculo(new Moto(), new Esquina(1,1));
        Esquina esquinaDeMoto = new Esquina(1,1);
        Assertions.assertEquals(moto.posicion,esquinaDeMoto);
    }
}
