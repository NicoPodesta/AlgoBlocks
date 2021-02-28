package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonRepetirX2EventHandler implements EventHandler<MouseEvent> {

    private Tablero tablero;

    public BotonRepetirX2EventHandler(Tablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public void handle(MouseEvent event) {
        //abrir ventana para generar conjuntos bloques
    }
}