package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.scene.input.MouseEvent;

public class BotonInvertirEventHandler extends BotonBloqueEventHandler {

    public BotonInvertirEventHandler(ConjuntoBloques algoritmo ) {
        super(algoritmo);
    }

    @Override
    public void handle(MouseEvent event) {
        //abrir ventana para generar conjuntos bloques
    }
}