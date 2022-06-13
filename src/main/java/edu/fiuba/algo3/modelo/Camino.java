package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

import java.util.ArrayList;

public class Camino {
    public Esquina esquina1, esquina2;
    private ArrayList<Efecto> efectos;

    public Camino(Esquina esquinaSalida, Esquina esquinaLlegada) {
        esquina1 = esquinaSalida;
        esquina2 = esquinaLlegada;
        efectos = new ArrayList<>();
    }
    public void agregrarEfecto(Efecto nuevoEfecto){
        // TODO: excepciones en los controles
        if (efectos.size() >= 2) {
            return;
        }
        if (efectos.size() == 1 && efectos.get(0).getClass().equals(nuevoEfecto.getClass())) {
            // TODO: ver de mejorar la logica para que solo acepte como máximo 1 Obstaculo y 1 Sorpresa
            return;
        }
        efectos.add(nuevoEfecto);
    }

    @Override
    public boolean equals(Object o) {
        Camino c = (Camino) o;
        if (this.esquina1.equals(c.esquina1) && this.esquina2.equals(c.esquina2)) return true;
        return this.esquina1.equals(c.esquina2) && this.esquina2.equals(c.esquina1);
    }

    public void aplicarEfecto(Jugador jugador, Vehiculo vehiculo){
        for (Efecto efecto: efectos) {
            vehiculo.aplicarEfecto(jugador, efecto);
        }
    }

}
