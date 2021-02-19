package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.BloqueLapizApoyado;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.scene.input.MouseEvent;

public class BotonBloqueLapizApoyadoEventHandler extends BotonBloqueEventHandler {

    public BotonBloqueLapizApoyadoEventHandler(Tablero tablero) {
        super(tablero);
    }

    @Override
    public void handle(MouseEvent event) {
        agregarBloqueAlTablero(new BloqueLapizApoyado());
    }
}