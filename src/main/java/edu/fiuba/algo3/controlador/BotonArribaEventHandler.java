package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloqueArriba;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.scene.input.MouseEvent;

public class BotonArribaEventHandler extends BotonBloqueEventHandler {

    public BotonArribaEventHandler(Tablero tablero) {
        super(tablero);
    }

    @Override
    public void handle(MouseEvent event) {
        agregarBloqueAlTablero(new BloqueArriba());
    }
}