package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonEjecutarEventHandler implements EventHandler<MouseEvent> {

    private ConjuntoBloques algoritmo;
    private Personaje personaje;

    public BotonEjecutarEventHandler(ConjuntoBloques algoritmo, Personaje personaje) {
        this.algoritmo = algoritmo;
        this.personaje = personaje;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.algoritmo.ejecutar(this.personaje);
    }
}