package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public abstract class BotonBloqueEventHandler implements EventHandler<MouseEvent> {

    private Tablero tablero;

    public BotonBloqueEventHandler(Tablero tablero) {
        this.tablero = tablero;
    }

    protected void agregarBloqueAlTablero(Bloque bloque) {
        tablero.agregarBloqueAlAlgoritmo(bloque);
    }
}