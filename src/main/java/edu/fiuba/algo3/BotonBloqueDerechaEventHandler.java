package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.BloqueDerecha;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.scene.input.MouseEvent;

public class BotonBloqueDerechaEventHandler extends BotonBloqueEventHandler {

    public BotonBloqueDerechaEventHandler(Tablero tablero) {
        super(tablero);
    }

    @Override
    public void handle(MouseEvent event) {
        agregarBloqueAlTablero(new BloqueDerecha());
    }
}