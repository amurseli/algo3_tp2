package edu.fiuba.algo3.modelo.Entrega_1_;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.GeneradoresRandom.GeneradorRandom;
import edu.fiuba.algo3.modelo.GeneradoresRandom.GeneradorRandomObstaculos;
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

        GeneradorRandomObstaculos randomDeCamino = Mockito.mock(GeneradorRandomObstaculos.class);
        Mockito.when(randomDeCamino.generarObstaculo()).thenReturn(new Pozo());
        camino.setRandomObstaculos(randomDeCamino);


        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new Moto(), new Esquina(1, 6)));
        juego.agregarCamino(camino);
        juego.mover(new Derecha());
        assertEquals(juego.obtenerMovimientosRealizados(), 1);
    }

    @Test
    public void Test01MotoPasaPorUnPozoYEsPenalizadaEnTresMovimientos() {
        Juego juego = new Juego();
        Camino camino = new Camino(new Esquina(1, 5), new Derecha());

        GeneradorRandomObstaculos randomDeCamino = Mockito.mock(GeneradorRandomObstaculos.class);
        Mockito.when(randomDeCamino.generarObstaculo()).thenReturn(new Pozo());
        camino.setRandomObstaculos(randomDeCamino);

        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new Moto(), new Esquina(1, 5)));
        juego.agregarCamino(camino);
        juego.mover(new Derecha());
        assertEquals(juego.obtenerMovimientosRealizados(), 4);
    }


    @Test
    public void Test02UnAutoPasaPorUnPozoYEsPenalizadoEnTresMovimientos() {
        Juego juego = new Juego();
        Camino camino = new Camino(new Esquina(1, 5), new Derecha());

        GeneradorRandomObstaculos randomDeCamino = Mockito.mock(GeneradorRandomObstaculos.class);
        Mockito.when(randomDeCamino.generarObstaculo()).thenReturn(new Pozo());
        camino.setRandomObstaculos(randomDeCamino);

        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new Auto(),new Esquina(1, 5)));
        juego.agregarCamino(camino);
        juego.mover(new Derecha());
        assertEquals(juego.obtenerMovimientosRealizados(), 4);
    }

    @Test
    public void Test03Un4x4PasaPorUnPozoYNoEsPenalizado() {
        Juego juego = new Juego();
        Camino camino = new Camino(new Esquina(1, 5), new Derecha());

        GeneradorRandomObstaculos randomDeCamino = Mockito.mock(GeneradorRandomObstaculos.class);
        Mockito.when(randomDeCamino.generarObstaculo()).thenReturn(new Pozo());
        camino.setRandomObstaculos(randomDeCamino);

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

        GeneradorRandomObstaculos randomDeCamino1 = Mockito.mock(GeneradorRandomObstaculos.class);
        Mockito.when(randomDeCamino1.generarObstaculo()).thenReturn(new Pozo());
        camino1.setRandomObstaculos(randomDeCamino1);

        Camino camino2 = new Camino(new Esquina(1, 6), new Derecha());

        GeneradorRandomObstaculos randomDeCamino2 = Mockito.mock(GeneradorRandomObstaculos.class);
        Mockito.when(randomDeCamino2.generarObstaculo()).thenReturn(new Pozo());
        camino2.setRandomObstaculos(randomDeCamino2);

        Camino camino3 = new Camino(new Esquina(1, 7), new Derecha());

        GeneradorRandomObstaculos randomDeCamino3 = Mockito.mock(GeneradorRandomObstaculos.class);
        Mockito.when(randomDeCamino3.generarObstaculo()).thenReturn(new Pozo());
        camino3.setRandomObstaculos(randomDeCamino3);

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

        GeneradorRandom stubGeneradorRandom = Mockito.mock(GeneradorRandom.class);
        Mockito.when(stubGeneradorRandom.generarRandomInt(1,10)).thenReturn(2);
        Camino camino = new Camino(new Esquina(1, 1), new Derecha());

        GeneradorRandomObstaculos randomDeCamino1 = Mockito.mock(GeneradorRandomObstaculos.class);
        Mockito.when(randomDeCamino1.generarObstaculo()).thenReturn(new ControlPolicial(stubGeneradorRandom));
        camino.setRandomObstaculos(randomDeCamino1);

        juego.agregarCamino(camino);
        juego.mover(new Derecha());

        Assertions.assertEquals(juego.obtenerMovimientosRealizados(), 4);
    }

    @Test
    public void Test064x4AtraviesaControlPolicialYLoParan() {
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new CuatroPorCuatro(), new Esquina(1, 1)));

        GeneradorRandom stubGeneradorRandom = Mockito.mock(GeneradorRandom.class);
        Mockito.when(stubGeneradorRandom.generarRandomInt(1,10)).thenReturn(2);
        Camino camino = new Camino(new Esquina(1, 1), new Derecha());

        GeneradorRandomObstaculos randomDeCamino1 = Mockito.mock(GeneradorRandomObstaculos.class);
        Mockito.when(randomDeCamino1.generarObstaculo()).thenReturn(new ControlPolicial(stubGeneradorRandom));
        camino.setRandomObstaculos(randomDeCamino1);

        juego.agregarCamino(camino);
        juego.mover(new Derecha());

        Assertions.assertEquals(juego.obtenerMovimientosRealizados(), 4);
    }

    @Test
    public void Test074x4AtraviesaControlPolicialYNoLoParan() {
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new CuatroPorCuatro(), new Esquina(1, 1)));

        GeneradorRandom stubGeneradorRandom = Mockito.mock(GeneradorRandom.class);
        Mockito.when(stubGeneradorRandom.generarRandomInt(1,10)).thenReturn(6);
        Camino camino = new Camino(new Esquina(1, 1), new Derecha());

        GeneradorRandomObstaculos randomDeCamino1 = Mockito.mock(GeneradorRandomObstaculos.class);
        Mockito.when(randomDeCamino1.generarObstaculo()).thenReturn(new ControlPolicial(stubGeneradorRandom));
        camino.setRandomObstaculos(randomDeCamino1);

        juego.agregarCamino(camino);

        juego.mover(new Derecha());

        Assertions.assertEquals(juego.obtenerMovimientosRealizados(), 1);
    }

    @Test
    public void Test08MotoAtraviesaControlPolicialYNoLaParan() {

        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new Moto(), new Esquina(1, 1)));

        GeneradorRandom stubGeneradorRandom = Mockito.mock(GeneradorRandom.class);
        Mockito.when(stubGeneradorRandom.generarRandomInt(1,10)).thenReturn(9);
        Camino camino = new Camino(new Esquina(1, 1), new Derecha());

        GeneradorRandomObstaculos randomDeCamino1 = Mockito.mock(GeneradorRandomObstaculos.class);
        Mockito.when(randomDeCamino1.generarObstaculo()).thenReturn(new ControlPolicial(stubGeneradorRandom));
        camino.setRandomObstaculos(randomDeCamino1);

        juego.agregarCamino(camino);
        juego.mover(new Derecha());

        Assertions.assertEquals(juego.obtenerMovimientosRealizados(), 1);
    }
}