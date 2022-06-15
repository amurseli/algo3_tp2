package edu.fiuba.algo3.modelo.Entrega_1_;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.Esquina;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Movimientos.Derecha;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CasosDeUso {

    @Test
    public void Test00MotoPasaPorUnCaminoVacioYNoEsPenalizada(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Moto(new Esquina(1,6)));
        juego.agregarCaminoConEfecto(new Camino(new Esquina(1,5), new Derecha()), new Pozo());
        juego.mover(new Derecha());
        assertEquals(juego.obtenerMovimientosRealizados(), 1);
    }

    @Test
    public void Test01MotoPasaPorUnPozoYEsPenalizadaEnTresMovimientos(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Moto(new Esquina(1,5)));
        juego.agregarCaminoConEfecto(new Camino(new Esquina(1,5), new Derecha()), new Pozo());
        juego.mover(new Derecha());
        assertEquals(juego.obtenerMovimientosRealizados(), 4);
    }


    @Test
    public void Test02UnAutoPasaPorUnPozoYEsPenalizadoEnTresMovimientos(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Auto(new Esquina(1,5)));
        juego.agregarCaminoConEfecto(new Camino(new Esquina(1,5), new Derecha()), new Pozo());
        juego.mover(new Derecha());
        assertEquals(juego.obtenerMovimientosRealizados(), 4);
    }

    @Test
    public void Test03Un4x4PasaPorUnPozoYNoEsPenalizado(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new CuatroPorCuatro(new Esquina(1,5)));
        juego.agregarCaminoConEfecto(new Camino(new Esquina(1,5), new Derecha()), new Pozo());
        juego.mover(new Derecha());
        assertEquals(juego.obtenerMovimientosRealizados(), 1);
    }


    @Test
    public void Test04Un4x4PasaPor3PozosYEsPenalizado(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1,10), new CuatroPorCuatro(new Esquina(1,5)));

        juego.agregarCaminoConEfecto(new Camino(new Esquina(1,5), new Derecha()), new Pozo());
        juego.agregarCaminoConEfecto(new Camino(new Esquina(1,6), new Derecha()), new Pozo());
        juego.agregarCaminoConEfecto(new Camino(new Esquina(1,7), new Derecha()), new Pozo());


        juego.mover(new Derecha());
        juego.mover(new Derecha());
        juego.mover(new Derecha());

        assertEquals(juego.obtenerMovimientosRealizados(), 5);
    }

    @Test
    public void Test05AutoAtraviesaMuchosControlesPolicialesYLoParanEl30PorcientoDeLasVeces (){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10000, 10000), new Esquina(1,10000), new Auto(new Esquina(1,1)));

        for (int i = 1; i<9990; i++){
            juego.agregarCaminoConEfecto(new Camino(new Esquina(1,i), new Derecha()), new ControlPolicial());
            juego.mover(new Derecha());
        }
        int movimientosHechos = 9899;
        double controlesEsperados = movimientosHechos * 0.3 * 3;
        double esperado = movimientosHechos + controlesEsperados;
        // me fijo si los movimientos totales son iguales a lo esperado +- 5%

        Assertions.assertTrue(juego.obtenerMovimientosRealizados() < (esperado + esperado*5/100)
                && juego.obtenerMovimientosRealizados() > (esperado - esperado*5/100));
    }

    @Test
    public void Test064x4AtraviesaMuchosControlesPolicialesYLoParanEl50PorcientoDeLasVeces (){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10000, 10000), new Esquina(1,10000), new CuatroPorCuatro(new Esquina(1,1)));

        for (int i = 1; i<9990; i++){
            juego.agregarCaminoConEfecto(new Camino(new Esquina(1,i), new Derecha()), new ControlPolicial());
            juego.mover(new Derecha());
        }
        int movimientosHechos = 9899;
        double controlesEsperados = movimientosHechos * 0.5 * 3;
        double esperado = movimientosHechos + controlesEsperados;
        // me fijo si los movimientos totales son iguales a lo esperado +- 5%

        Assertions.assertTrue(juego.obtenerMovimientosRealizados() < (esperado + esperado*5/100)
                && juego.obtenerMovimientosRealizados() > (esperado - esperado*5/100));
    }

    @Test
    public void Test07MotoAtraviesaMuchosControlesPolicialesYLoParanEl80PorcientoDeLasVeces (){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10000, 10000), new Esquina(1,10000), new Moto(new Esquina(1,1)));

        for (int i = 1; i<9990; i++){
            juego.agregarCaminoConEfecto(new Camino(new Esquina(1,i), new Derecha()), new ControlPolicial());
            juego.mover(new Derecha());
        }

        int movimientosHechos = 9899;
        double controlesEsperados = movimientosHechos * 0.8 * 3;
        double esperado = movimientosHechos + controlesEsperados;
        // me fijo si los movimientos totales son iguales a lo esperado +- 5%

        Assertions.assertTrue(juego.obtenerMovimientosRealizados() < (esperado + esperado*5/100)
                && juego.obtenerMovimientosRealizados() > (esperado - esperado*5/100));
    }


}