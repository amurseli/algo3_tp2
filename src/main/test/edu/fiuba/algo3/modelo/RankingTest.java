package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RankingTest {
    @Test
    public void seAgregan3PuntajesAlRankingYQuedanOrdenados() {
        Ranking ranking = new Ranking();
        Puntaje puntaje1 = new Puntaje(5, "nombre1");
        Puntaje puntaje2 = new Puntaje(10, "nombre2");
        Puntaje puntaje3 = new Puntaje(15, "nombre3");
        Puntaje puntaje4 = new Puntaje(20, "nombre4");
        ranking.agregarPuntaje(puntaje2);
        ranking.agregarPuntaje(puntaje4);
        ranking.agregarPuntaje(puntaje1);
        ranking.agregarPuntaje(puntaje3);
        Assertions.assertTrue(ranking.compararPuntaje(puntaje4, 0));
        Assertions.assertTrue(ranking.compararPuntaje(puntaje3, 1));
        Assertions.assertTrue(ranking.compararPuntaje(puntaje2, 2));
        Assertions.assertTrue(ranking.compararPuntaje(puntaje1, 3));
    }
}
