package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VehiculoTest {
    @Test
    public void Test01CreoUnVehiculoCorrectamente(){
        Moto v = new Moto(new Esquina(1,1));
        Esquina e = new Esquina(1,1);
        Assertions.assertEquals(v.posicion,e);
    }
}
