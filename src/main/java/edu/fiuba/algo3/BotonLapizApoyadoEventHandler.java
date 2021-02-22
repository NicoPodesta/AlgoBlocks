package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.BloqueLapizApoyado;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.scene.input.MouseEvent;

public class BotonLapizApoyadoEventHandler extends BotonBloqueEventHandler {

    public BotonLapizApoyadoEventHandler(Tablero tablero) {
        super(tablero);
    }

    @Override
    public void handle(MouseEvent event) {
        agregarBloqueAlTablero(new BloqueLapizApoyado());
    }
}