package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PuntajeTest {
    @Test
    public void seCreaUnPuntajeConLosDatosCorrespondientes() {
        Puntaje puntaje = new Puntaje(10, "nombre");
        Assertions.assertEquals(10, puntaje.getMovimientos());
        Assertions.assertEquals("nombre", puntaje.getNombre());
    }
    @Test
    public void unPuntajeDevuelve1AlSerComparadoConUnoMenor() {
        Puntaje puntajeMayor = new Puntaje(10, "nombre1");
        Puntaje puntajeMenor = new Puntaje(5, "nombre2");
        Assertions.assertEquals(1, puntajeMayor.comparar(puntajeMenor));
    }
    @Test
    public void unPuntajeDevuelveMenos1AlSerComparadoConUnoMayor() {
        Puntaje puntajeMenor = new Puntaje(5, "nombre1");
        Puntaje puntajeMayor = new Puntaje(10, "nombre2");
        Assertions.assertEquals(-1, puntajeMenor.comparar(puntajeMayor));
    }
    @Test
    public void unPuntajeDevuelve0AlSerComparadoConUnoDeIgualMovimientos() {
        Puntaje puntaje1 = new Puntaje(10, "nombre1");
        Puntaje puntaje2 = new Puntaje(10, "nombre2");
        Assertions.assertEquals(0, puntaje1.comparar(puntaje2));
    }
}
