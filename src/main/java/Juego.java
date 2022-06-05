public class Juego {
    Ciudad ciudad;
    Juego(){
        this.ciudad = new Ciudad(100,100, new Moto());
    }
    public void moverDerecha() {
        ciudad.moverDerecha();
    }
}
