package edu.fiuba.algo3.modelo.Entrega_2_;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.Esquina;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaFavorable;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasosDeUso2 {
    @Test
    public void Test01UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaFavorable(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Moto(new Esquina(1,1)));
        juego.agregarCaminoConEfecto(new Camino(new Esquina(1,5), new Esquina(1,6)), new SorpresaFavorable());
        juego.moverDerecha();
        juego.moverDerecha();
        juego.moverDerecha();
        juego.moverDerecha();
        juego.moverIzquierda();
        juego.moverDerecha();
        juego.moverDerecha(); //Me muevo 7 veces y me resta el 20% para darme 6 (redondeado) TODO agregarlo a supuestos del pdf
        Assertions.assertEquals(juego.obtenerMovimientosRealizados(),6);

    }
    @Test
    public void Test02UnVehículoAtraviesaLaCiudadYEncuentraUnaSorpresaDesfavorable(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Moto(new Esquina(1,1)));
        juego.agregarCaminoConEfecto(new Camino(new Esquina(1,5), new Esquina(1,6)), new SorpresaDesfavorable());
        juego.moverDerecha();
        juego.moverDerecha();
        juego.moverDerecha();
        juego.moverDerecha();
        juego.moverIzquierda();
        juego.moverDerecha();
        juego.moverDerecha(); //Me muevo 7 veces y me suma el 25% para darme 8 (redondeado) TODO agregarlo a supuestos del pdf
        Assertions.assertEquals(juego.obtenerMovimientosRealizados(),8);
    }
    @Test
    public void Test03UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaDeCambioDeVehiculo(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Moto(new Esquina(1,5)));
        juego.agregarCaminoConEfecto(new Camino(new Esquina(1,5), new Esquina(1,6)), new CambioDeVehiculo());
        //TODO falta probar el cambio de los otros vehiculos (pero en otro lado) ((porque aguante las pruebas unitarias)) (((xd me olvide q iba a poner aca)))
        juego.moverDerecha();
        Assertions.assertEquals(juego.obtenerVehiculo().getClass(), Auto.class);
    }

    @Test
    public void Test04AutoSeEncuentraConPiqueteYPegaLaVuelta(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Auto(new Esquina(1,5)));
        juego.agregarCaminoConEfecto(new Camino(new Esquina(1,5), new Esquina(1,6)), new Piquete());
        juego.moverDerecha();
        Assertions.assertEquals(juego.obtenerVehiculo().obtenerPosicion(), new Esquina(1, 5));
        Assertions.assertEquals(juego.obtenerMovimientosRealizados(),1);
    }

    @Test
    public void Test05MotoSeEncuentraConPiqueteYNoPegaLaVueltaYSePenaliza(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Moto(new Esquina(1,5)));
        juego.agregarCaminoConEfecto(new Camino(new Esquina(1,5), new Esquina(1,6)), new Piquete());
        juego.moverDerecha();
        Assertions.assertEquals(juego.obtenerVehiculo().obtenerPosicion(), new Esquina(1, 6));
        Assertions.assertEquals(juego.obtenerMovimientosRealizados(),3);
    }

    @Test
    public void Test06CuatroPorCuatroSeEncuentraConPiqueteYPegaLaVuelta(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new CuatroPorCuatro(new Esquina(1,5)));
        juego.agregarCaminoConEfecto(new Camino(new Esquina(1,5), new Esquina(1,6)), new Piquete());
        juego.moverDerecha();
        Assertions.assertEquals(juego.obtenerVehiculo().obtenerPosicion(), new Esquina(1, 5));
        Assertions.assertEquals(juego.obtenerMovimientosRealizados(),1);
    }
}
