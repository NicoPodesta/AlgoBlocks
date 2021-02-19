package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.BloqueArriba;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.scene.input.MouseEvent;

public class BotonBloqueArribaEventHandler extends BotonBloqueEventHandler {

    public BotonBloqueArribaEventHandler(Tablero tablero) {
        super(tablero);
    }

    @Override
    public void handle(MouseEvent event) {
        agregarBloqueAlTablero(new BloqueArriba());
    }
}