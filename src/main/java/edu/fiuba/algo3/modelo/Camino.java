package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ObstaculoNull;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaNull;
import edu.fiuba.algo3.modelo.vehiculos.TipoVehiculo;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;


public class Camino {
    public Esquina esquinaInicial, esquinaFinal;
    public Sorpresa sorpresa;
    public Obstaculo obstaculo;

    public Camino(Esquina esquinaInicial, Direccion unaDireccion) {
        this.esquinaInicial = esquinaInicial;
        esquinaFinal = unaDireccion.siguiente(esquinaInicial);
        sorpresa = new SorpresaNull();
        obstaculo = new ObstaculoNull();

    }
    public void agregrarEfecto(Sorpresa nuevaSorpresa){

        //TODO: SUPUESTO, EL AGRAR EFECTO REMPLAZA
        sorpresa = nuevaSorpresa;
    }

    public void agregrarEfecto(Obstaculo nuevoObstaculo){

        obstaculo = nuevoObstaculo;
    }

    @Override
    public boolean equals(Object o) {
        Camino c = (Camino) o;
        if (this.esquinaInicial.equals(c.esquinaInicial) && this.esquinaFinal.equals(c.esquinaFinal)) return true;
        return this.esquinaInicial.equals(c.esquinaFinal) && this.esquinaFinal.equals(c.esquinaInicial);
    }

    public void aplicarEfecto(Vehiculo vehiculo, TipoVehiculo estadoVehiculo){

        estadoVehiculo.aplicarEfecto(vehiculo,obstaculo);

        estadoVehiculo.aplicarEfecto(vehiculo,sorpresa);

        sorpresa = new SorpresaNull();
    }

    //Hecho unicamente para las pruebas
    public Boolean obtenerCantidadEfectos(Sorpresa sorpresa){
        return (sorpresa.getClass().equals(this.sorpresa));
    }

}
