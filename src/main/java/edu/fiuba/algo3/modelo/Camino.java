package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Movimientos.Direccion;
import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

import java.util.ArrayList;

public class Camino {
    public Esquina esquinaInicial, esquinaFinal;
    private ArrayList<Efecto> efectos;

    public Camino(Esquina esquinaInicial, Direccion unaDireccion) {
        this.esquinaInicial = esquinaInicial;
        esquinaFinal = unaDireccion.siguiente(esquinaInicial);
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
        if (this.esquinaInicial.equals(c.esquinaInicial) && this.esquinaFinal.equals(c.esquinaFinal)) return true;
        return this.esquinaInicial.equals(c.esquinaFinal) && this.esquinaFinal.equals(c.esquinaInicial);
    }

    public void aplicarEfecto(Jugador jugador, Vehiculo vehiculo){
        for (Efecto efecto: efectos) {
            vehiculo.aplicarEfecto(jugador, efecto);
        }
    }
}
