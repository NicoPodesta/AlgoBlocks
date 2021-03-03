package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.vista.Dibujador;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonEjecutarEventHandler implements EventHandler<MouseEvent> {

    private ConjuntoBloques algoritmo;
    private Personaje personaje;
    private Dibujador dibujador;

    public BotonEjecutarEventHandler(ConjuntoBloques algoritmo, Personaje personaje, Dibujador dibujador) {
        this.algoritmo = algoritmo;
        this.personaje = personaje;
        this.dibujador = dibujador;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.algoritmo.ejecutar(this.personaje);
        //Falta hacer clear al dibujador y al personaje
    }
}