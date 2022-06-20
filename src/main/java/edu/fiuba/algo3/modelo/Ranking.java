package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ranking {

    ArrayList<Puntaje> tablaDePuntajes;

    Ranking(){
        tablaDePuntajes = new ArrayList<Puntaje>();
    }

    public void agregarPuntaje(Puntaje nuevoPuntaje){
        tablaDePuntajes.add(nuevoPuntaje);
    }

    public void mostrarRanking(){
        System.out.println("TABLA DE PUNAJE\n");

        for (Puntaje puntaje :tablaDePuntajes){
            System.out.println(puntaje.nickname + " realizó "+puntaje.movimientos + " movimientos");
        }
    }
}
