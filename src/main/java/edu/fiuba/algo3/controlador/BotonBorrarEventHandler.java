package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonBorrarEventHandler implements EventHandler<MouseEvent> {

    protected ConjuntoBloques algoritmo;

    public BotonBorrarEventHandler(ConjuntoBloques algoritmo, ContenedorPrincipal contenedor) {
        this.algoritmo = algoritmo;
    }

    @Override
    public void handle(MouseEvent event) {
        algoritmo.removerUltimoBloque();
    }
}