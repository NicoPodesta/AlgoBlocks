package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class BotonBloqueEventHandler implements EventHandler<MouseEvent> {

    protected ConjuntoBloques algoritmo;
    protected ContenedorPrincipal contenedor;

    public BotonBloqueEventHandler(ConjuntoBloques algoritmo, ContenedorPrincipal contenedor) {
        this.algoritmo = algoritmo;
        this.contenedor = contenedor;
    }
}