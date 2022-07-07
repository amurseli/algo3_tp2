package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ObstaculoNull;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaNull;
import edu.fiuba.algo3.modelo.vehiculos.TipoVehiculo;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

import java.util.Observable;


public class Camino extends Observable {
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
        setChanged();
        this.notifyObservers();
    }

    public void agregrarEfecto(Obstaculo nuevoObstaculo){

        obstaculo = nuevoObstaculo;
        setChanged();
        this.notifyObservers();
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

        setChanged();
        this.notifyObservers();
    }
}
