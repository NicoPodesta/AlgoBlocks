package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.BloqueRepetir;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.scene.input.MouseEvent;

public class BotonBloqueRepetirX2EventHandler extends BotonBloqueEventHandler {

    public BotonBloqueRepetirX2EventHandler(Tablero tablero) {
        super(tablero);
    }

    @Override
    public void handle(MouseEvent event) {
        agregarBloqueAlTablero(new BloqueRepetir(2));
    }
}