package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Puntaje {

    Integer movimientos;
    String nickname;

    public Puntaje(Integer movimientos, String nickname){
        this.movimientos = movimientos;
        this.nickname = nickname;
    }

    public int getMovimientos(){
        return this.movimientos;
    }

}
