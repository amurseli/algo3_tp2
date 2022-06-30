package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.vehiculos.TipoVehiculo;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

import java.util.ArrayList;

public class Camino {
    public Esquina esquinaInicial, esquinaFinal;
    public ArrayList<Sorpresa> sospresas;
    public ArrayList<Obstaculo> obstaculos;

    public Camino(Esquina esquinaInicial, Direccion unaDireccion) {
        this.esquinaInicial = esquinaInicial;
        esquinaFinal = unaDireccion.siguiente(esquinaInicial);
        sospresas = new ArrayList<>();
        obstaculos = new ArrayList<>();
    }
    public void agregrarEfecto(Sorpresa nuevaSorpresa){
        // TODO: excepciones en los controles
        if (sospresas.size() >= 2) {
            return;
        }
        if (sospresas.size() == 1 && sospresas.get(0).getClass().equals(nuevaSorpresa.getClass())) {
            // TODO: ver de mejorar la logica para que solo acepte como máximo 1 Obstaculo y 1 Sorpresa
            return;
        }
        sospresas.add(nuevaSorpresa);
    }

    public void agregrarEfecto(Obstaculo nuevoObstaculo){
        // TODO: excepciones en los controles
        if (obstaculos.size() >= 2) {
            return;
        }
        if (obstaculos.size() == 1 && obstaculos.get(0).getClass().equals(nuevoObstaculo.getClass())) {
            // TODO: ver de mejorar la logica para que solo acepte como máximo 1 Obstaculo y 1 Sorpresa
            return;
        }
        obstaculos.add(nuevoObstaculo);
    }

    @Override
    public boolean equals(Object o) {
        Camino c = (Camino) o;
        if (this.esquinaInicial.equals(c.esquinaInicial) && this.esquinaFinal.equals(c.esquinaFinal)) return true;
        return this.esquinaInicial.equals(c.esquinaFinal) && this.esquinaFinal.equals(c.esquinaInicial);
    }

    public void aplicarEfecto(Vehiculo vehiculo, TipoVehiculo estadoVehiculo){
        for (Obstaculo obstaculo: obstaculos) {
            estadoVehiculo.aplicarEfecto(vehiculo,obstaculo);
        }
        for (Sorpresa sorpresa: sospresas) {
            estadoVehiculo.aplicarEfecto(vehiculo,sorpresa);
        }

        sospresas = new ArrayList<>();
    }

    //Hecho unicamente para las pruebas
    public int obtenerCantidadEfectos(){
        return (sospresas.size() + obstaculos.size());
    }

}
