package edu.fiuba.algo3.modelo;

public class Puntaje {

    Integer movimientos;
    String nombre;

    public Puntaje(Integer movimientos, String nickname){
        this.movimientos = movimientos;
        this.nombre = nickname;
    }

    public int getMovimientos(){
        return this.movimientos;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int comparar(Puntaje puntaje) {
        if (movimientos > puntaje.getMovimientos()) return 1;
        if (movimientos < puntaje.getMovimientos()) return -1;
        return 0;
    }
    @Override
    public boolean equals(Object o) {
        Puntaje p = (Puntaje)o;
        return movimientos == p.getMovimientos() && nombre == p.getNombre();
    }
}
