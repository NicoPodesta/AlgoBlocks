package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class BotonPersonalizadoEventHandler extends BotonBloqueEventHandler {

    private ArrayList<BloquePersonalizado> bloquesPersonalizados;

    public BotonPersonalizadoEventHandler(ConjuntoBloques algoritmo,
                                          ArrayList<BloquePersonalizado> bloquesPersonalizados) {
        super(algoritmo);
        this.bloquesPersonalizados = bloquesPersonalizados;
    }

    @Override
    public void handle(MouseEvent event) {
        //abrir ventana para seleccionar bloques personalizados
    }
}