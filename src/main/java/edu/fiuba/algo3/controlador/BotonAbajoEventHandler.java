package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.BloqueAbajo;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.scene.input.MouseEvent;

public class BotonAbajoEventHandler extends BotonBloqueEventHandler {

    public BotonAbajoEventHandler(Tablero tablero) {
        super(tablero);
    }

    @Override
    public void handle(MouseEvent event) {
        agregarBloqueAlTablero(new BloqueAbajo());
    }
}