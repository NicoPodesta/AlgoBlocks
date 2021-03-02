package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class BotonBloqueEventHandler implements EventHandler<MouseEvent> {

    protected ConjuntoBloques algoritmo;

    public BotonBloqueEventHandler(ConjuntoBloques algoritmo) {
        this.algoritmo = algoritmo;
    }
}