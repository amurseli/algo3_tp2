package edu.fiuba.algo3.modelo.Entrega_1_;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.Esquina;
import edu.fiuba.algo3.modelo.GeneradorNumeros;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CasosDeUso {

    @Test
    public void Test00MotoPasaPorUnCaminoVacioYNoEsPenalizada() {
        Juego juego = new Juego();
        Camino camino = new Camino(new Esquina(1, 5), new Derecha());
        camino.agregrarEfecto(new Pozo());
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new Moto(), new Esquina(1, 6)));
        juego.agregarCamino(camino);
        juego.mover(new Derecha());
        assertEquals(juego.obtenerMovimientosRealizados(), 1);
    }

    @Test
    public void Test01MotoPasaPorUnPozoYEsPenalizadaEnTresMovimientos() {
        Juego juego = new Juego();
        Camino camino = new Camino(new Esquina(1, 5), new Derecha());
        camino.agregrarEfecto(new Pozo());
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new Moto(), new Esquina(1, 5)));
        juego.agregarCamino(camino);
        juego.mover(new Derecha());
        assertEquals(juego.obtenerMovimientosRealizados(), 4);
    }


    @Test
    public void Test02UnAutoPasaPorUnPozoYEsPenalizadoEnTresMovimientos() {
        Juego juego = new Juego();
        Camino camino = new Camino(new Esquina(1, 5), new Derecha());
        camino.agregrarEfecto(new Pozo());
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new Auto(),new Esquina(1, 5)));
        juego.agregarCamino(camino);
        juego.mover(new Derecha());
        assertEquals(juego.obtenerMovimientosRealizados(), 4);
    }

    @Test
    public void Test03Un4x4PasaPorUnPozoYNoEsPenalizado() {
        Juego juego = new Juego();
        Camino camino = new Camino(new Esquina(1, 5), new Derecha());
        camino.agregrarEfecto(new Pozo());
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new CuatroPorCuatro(), new Esquina(1, 5)));
        juego.agregarCamino(camino);
        juego.mover(new Derecha());
        assertEquals(juego.obtenerMovimientosRealizados(), 1);
    }


    @Test
    public void Test04Un4x4PasaPor3PozosYEsPenalizado() {
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new CuatroPorCuatro(), new Esquina(1, 5)));
        Camino camino1 = new Camino(new Esquina(1, 5), new Derecha());
        camino1.agregrarEfecto(new Pozo());
        Camino camino2 = new Camino(new Esquina(1, 6), new Derecha());
        camino2.agregrarEfecto(new Pozo());
        Camino camino3 = new Camino(new Esquina(1, 7), new Derecha());
        camino3.agregrarEfecto(new Pozo());

        juego.agregarCamino(camino1);
        juego.agregarCamino(camino2);
        juego.agregarCamino(camino3);

        juego.mover(new Derecha());
        juego.mover(new Derecha());
        juego.mover(new Derecha());

        assertEquals(juego.obtenerMovimientosRealizados(), 5);
    }

    @Test
    public void Test05AutoAtraviesaControlPolicialYLoParan() {

        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new Auto(), new Esquina(1, 1)));

        GeneradorNumeros stubGeneradorNumeros = Mockito.mock(GeneradorNumeros.class);
        Mockito.when(stubGeneradorNumeros.generarRandom()).thenReturn(2);
        Camino camino = new Camino(new Esquina(1, 1), new Derecha());
        camino.agregrarEfecto(new ControlPolicial(stubGeneradorNumeros));

        juego.agregarCamino(camino);
        juego.mover(new Derecha());

        Assertions.assertEquals(juego.obtenerMovimientosRealizados(), 4);
    }

    @Test
    public void Test064x4AtraviesaControlPolicialYLoParan() {
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new CuatroPorCuatro(), new Esquina(1, 1)));

        GeneradorNumeros stubGeneradorNumeros = Mockito.mock(GeneradorNumeros.class);
        Mockito.when(stubGeneradorNumeros.generarRandom()).thenReturn(2);
        Camino camino = new Camino(new Esquina(1, 1), new Derecha());
        camino.agregrarEfecto(new ControlPolicial(stubGeneradorNumeros));

        juego.agregarCamino(camino);
        juego.mover(new Derecha());

        Assertions.assertEquals(juego.obtenerMovimientosRealizados(), 4);
    }

    @Test
    public void Test074x4AtraviesaControlPolicialYNoLoParan() {
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new CuatroPorCuatro(), new Esquina(1, 1)));

        GeneradorNumeros stubGeneradorNumeros = Mockito.mock(GeneradorNumeros.class);
        Mockito.when(stubGeneradorNumeros.generarRandom()).thenReturn(6);
        Camino camino = new Camino(new Esquina(1, 1), new Derecha());
        camino.agregrarEfecto(new ControlPolicial(stubGeneradorNumeros));

        juego.agregarCamino(camino);

        juego.mover(new Derecha());

        Assertions.assertEquals(juego.obtenerMovimientosRealizados(), 1);
    }

    @Test
    public void Test08MotoAtraviesaControlPolicialYNoLaParan() {

        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new Moto(), new Esquina(1, 1)));

        GeneradorNumeros stubGeneradorNumeros = Mockito.mock(GeneradorNumeros.class);
        Mockito.when(stubGeneradorNumeros.generarRandom()).thenReturn(9);
        Camino camino = new Camino(new Esquina(1, 1), new Derecha());
        camino.agregrarEfecto(new ControlPolicial(stubGeneradorNumeros));

        juego.agregarCamino(camino);
        juego.mover(new Derecha());

        Assertions.assertEquals(juego.obtenerMovimientosRealizados(), 1);
    }
}