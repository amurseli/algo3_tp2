package edu.fiuba.algo3.modelo.Entrega_2_;

import edu.fiuba.algo3.modelo.Camino;
import edu.fiuba.algo3.modelo.Esquina;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Direcciones.Izquierda;
import edu.fiuba.algo3.modelo.efectos.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.efectos.sorpresas.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.efectos.sorpresas.SorpresaFavorable;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasosDeUso2 {
    @Test
    public void Test01UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaFavorable(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new Moto(), new Esquina(1,1)));
        Camino camino = new Camino(new Esquina(1,5),new Derecha());
        camino.agregrarEfecto(new SorpresaFavorable());

        juego.agregarCamino(camino);
        juego.mover(new Derecha());
        juego.mover(new Derecha());
        juego.mover(new Derecha());
        juego.mover(new Derecha());
        juego.mover(new Izquierda());
        juego.mover(new Derecha());
        juego.mover(new Derecha()); //Me muevo 7 veces y me resta el 20% para darme 6 (redondeado) TODO agregarlo a supuestos del pdf
        Assertions.assertEquals(juego.obtenerMovimientosRealizados(),6);

    }
    @Test
    public void Test02UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaDesfavorable(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new Moto(), new Esquina(1,1)));
        Camino camino = new Camino(new Esquina(1,5), new Derecha());
        camino.agregrarEfecto(new SorpresaDesfavorable());

        juego.agregarCamino(camino);

        juego.mover(new Derecha());
        juego.mover(new Derecha());
        juego.mover(new Derecha());
        juego.mover(new Derecha());
        juego.mover(new Izquierda());
        juego.mover(new Derecha());
        juego.mover(new Derecha()); //Me muevo 7 veces y me suma el 25% para darme 8 (redondeado) TODO agregarlo a supuestos del pdf
        Assertions.assertEquals(juego.obtenerMovimientosRealizados(),8);
    }
    @Test
    public void Test03UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaDeCambioDeVehiculo(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new Moto(), new Esquina(1,5)));
        Camino camino = new Camino(new Esquina(1,5), new Derecha());
        camino.agregrarEfecto(new CambioDeVehiculo());

        juego.agregarCamino(camino);

        juego.mover(new Derecha());
        // TODO crear metodos para test para no tener que usar getters acá
        Assertions.assertEquals(juego.obtenerTipoVehiculo().getClass(), Auto.class);
        Assertions.assertEquals(juego.obtenerMovimientosRealizados(),1);
        Assertions.assertEquals(juego.obtenerVehiculo().obtenerPosicion(),new Esquina(1,6));
    }

    @Test
    public void Test04AutoSeEncuentraConPiqueteYPegaLaVuelta(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new Auto(), new Esquina(1,5)));
        Camino camino = new Camino(new Esquina(1,5), new Derecha());
        camino.agregrarEfecto(new Piquete());
        juego.agregarCamino(camino);

        juego.mover(new Derecha());
        Assertions.assertEquals(juego.obtenerVehiculo().obtenerPosicion(), new Esquina(1, 5));
        Assertions.assertEquals(juego.obtenerMovimientosRealizados(),1);
    }

    @Test
    public void Test05MotoSeEncuentraConPiqueteYNoPegaLaVueltaYSePenaliza(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new Moto(), new Esquina(1,5)));
        Camino camino = new Camino(new Esquina(1,5), new Derecha());
        camino.agregrarEfecto(new Piquete());
        juego.agregarCamino(camino);

        juego.mover(new Derecha());
        Assertions.assertEquals(juego.obtenerVehiculo().obtenerPosicion(), new Esquina(1, 6));
        Assertions.assertEquals(juego.obtenerMovimientosRealizados(),3);
    }

    @Test
    public void Test06CuatroPorCuatroSeEncuentraConPiqueteYPegaLaVuelta(){
        Juego juego = new Juego();
        juego.crearCiudad(new Esquina(10, 10), new Esquina(1, 10), new Vehiculo(new CuatroPorCuatro(), new Esquina(1,5)));
        Camino camino = new Camino(new Esquina(1,5), new Derecha());
        camino.agregrarEfecto(new Piquete());
        juego.agregarCamino(camino);

        juego.mover(new Derecha());
        Assertions.assertEquals(juego.obtenerVehiculo().obtenerPosicion(), new Esquina(1, 5));
        Assertions.assertEquals(juego.obtenerMovimientosRealizados(),1);
    }
}
