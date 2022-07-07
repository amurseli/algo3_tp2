package edu.fiuba.algo3.modelo.ObserverPersonalizado;

import edu.fiuba.algo3.modelo.Localize;

public class Message extends Localize {

    public Message(String esContent, String usContent) {
        super(esContent, usContent);
    }

    public String greet() {
        return super.greet("es");
    }
}
