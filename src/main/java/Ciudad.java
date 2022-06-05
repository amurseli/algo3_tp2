import java.util.*;

public class Ciudad {
    //TODO Meter tamaños de ciudad :)
    Jugador p1;
    Ciudad(int tamanioX, int tamanioY, Vehiculo v){
        this.p1 = new Jugador(v);
       // Esquina[][] ciudad = new Esquina[10][10]; // Esto funciona asi xd

    }

    public void moverDerecha() {
        p1.moverDerecha();
    }
}
