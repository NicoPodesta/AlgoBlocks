package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonPersonalizadoEventHandler implements EventHandler<MouseEvent> {

    private Tablero tablero;

    public BotonPersonalizadoEventHandler(Tablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public void handle(MouseEvent event) {
        //abrir ventana para seleccionar bloques personalizados
    }
}