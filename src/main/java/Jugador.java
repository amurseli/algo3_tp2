public class Jugador {
    Vehiculo vehiculoActual;
    Jugador(Vehiculo v){
        this.vehiculoActual = v;
    }
    public void moverDerecha() {
        vehiculoActual.moverDerecha();
    }
}
