package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueDerecha;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class BotonDerechaEventHandler extends BotonBloqueEventHandler {

    public BotonDerechaEventHandler(ArrayList<Bloque> algoritmo) {
        super(algoritmo);
    }

    @Override
    public void handle(MouseEvent event) {
        algoritmo.add(new BloqueDerecha());
    }
}