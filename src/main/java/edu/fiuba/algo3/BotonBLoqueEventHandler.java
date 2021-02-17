package edu.fiuba.algo3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

public class BotonBLoqueEventHandler implements EventHandler<MouseEvent> {
    private Button miBoton;
    public BotonBLoqueEventHandler(Button miBoton ) {
        this.miBoton = miBoton;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
    }
}
