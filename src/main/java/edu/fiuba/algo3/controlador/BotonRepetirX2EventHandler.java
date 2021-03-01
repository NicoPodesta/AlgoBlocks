package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class BotonRepetirX2EventHandler extends BotonBloqueEventHandler {

    public BotonRepetirX2EventHandler(ArrayList<Bloque> algoritmo) {
        super(algoritmo);
    }

    @Override
    public void handle(MouseEvent event) {
        //abrir ventana para generar conjuntos bloques
    }
}