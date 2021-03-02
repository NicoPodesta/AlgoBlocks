package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ConjuntoBloques;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class LabelConjuntoBloquesEventHandler implements EventHandler<MouseEvent> {

    private ConjuntoBloques conjunto;

    public LabelConjuntoBloquesEventHandler(ConjuntoBloques conjunto) {
        this.conjunto = conjunto;
    }

    @Override
    public void handle(MouseEvent event) {

    }
}