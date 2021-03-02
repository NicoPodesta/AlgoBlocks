package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.scene.input.MouseEvent;

public class BotonRepetirX3EventHandler extends BotonBloqueEventHandler {

    public BotonRepetirX3EventHandler(ConjuntoBloques algoritmo, ContenedorPrincipal contenedor) {
        super(algoritmo, contenedor);
    }

    @Override
    public void handle(MouseEvent event) {
        //abrir ventana para generar conjuntos bloques
    }
}