package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.BloqueAbajo;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.scene.input.MouseEvent;

public class BotonBloqueAbajoEventHandler extends BotonBloqueEventHandler {

    public BotonBloqueAbajoEventHandler(Tablero tablero) {
        super(tablero);
    }

    @Override
    public void handle(MouseEvent event) {
        agregarBloqueAlTablero(new BloqueAbajo());
    }
}