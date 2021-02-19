package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.BloqueLapizLevantado;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.scene.input.MouseEvent;

public class BotonBloqueLapizLevantadoEventHandler extends BotonBloqueEventHandler {

    public BotonBloqueLapizLevantadoEventHandler(Tablero tablero) {
        super(tablero);
    }

    @Override
    public void handle(MouseEvent event) {
        agregarBloqueAlTablero(new BloqueLapizLevantado());
    }
}