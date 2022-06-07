package edu.fiuba.algo3.modelo;

public class Camino {
    private Esquina esquina1, esquina2;

    public Camino(Esquina esquina1, Esquina esquina2) {
        this.esquina1 = esquina1;
        this.esquina2 = esquina2;
    }

    @Override
    public boolean equals(Object o) {
        Camino c = (Camino) o;
        if (this.esquina1.equals(c.esquina1) && this.esquina2.equals(c.esquina2)) return true;
        if (this.esquina1.equals(c.esquina2) && this.esquina2.equals(c.esquina1)) return true;
        return false;
    }
}
