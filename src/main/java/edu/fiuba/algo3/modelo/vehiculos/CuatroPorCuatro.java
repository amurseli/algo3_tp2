package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.efectos.Efecto;

public class CuatroPorCuatro extends Vehiculo {
    int pozosPisados = 0;

    public CuatroPorCuatro(Esquina posicion) {
        super(posicion);
    }

    @Override
    public void aplicarEfecto(Jugador jugador, Efecto efecto) {
        efecto.aplicarEfecto(this);
    }


//TODO: Para cuando tengamos las sorpresas hechas
    /*
    public CuatroPorCuatro(Esquina posicion, Esquina posicionAnterior, int movimientos) {
        super(posicion, posicionAnterior, movimientos);
    }*/

    public void sumarPozoPisado(){
        pozosPisados += 1;
    }

    public void reinciarPozosPizados(){
        pozosPisados = 0;
    }

    public int getPozosPisados(){
        return pozosPisados;
    }

}
