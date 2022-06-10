package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.efectos.Efecto;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Camino {
    public Esquina esquina1, esquina2;
    public Efecto efecto;

    public Camino(Esquina esquinaSalida, Esquina esquinaLlegada) {
        esquina1 = esquinaSalida;
        esquina2 = esquinaLlegada;
    }
    public void agregrarEfecto(Efecto nuevoEfecto){
        efecto = nuevoEfecto;
    }

    @Override
    public boolean equals(Object o) {
        Camino c = (Camino) o;
        if (this.esquina1.equals(c.esquina1) && this.esquina2.equals(c.esquina2)) return true;
        if (this.esquina1.equals(c.esquina2) && this.esquina2.equals(c.esquina1)) return true;
        return false;
    }

    public void aplicarEfecto(Vehiculo vehiculo){

        //TODO: LE DEJE HARCODEADO ESTO PERO ESTA MAL. TIENE QUE HABER UNA FOMRA DE QUE RECIBA EL VEHICULO FELIZMENTE
        efecto.aplicarEfecto((Moto)vehiculo);
    }

}
