package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorBloquePersonalizado;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonPersonalizadoEventHandler extends BotonBloqueEventHandler {

    private BloquePersonalizado bloquePersonalizado;

    public BotonPersonalizadoEventHandler(ConjuntoBloques algoritmo,
                                          BloquePersonalizado bloquePersonalizado) {
        super(algoritmo);
        this.bloquePersonalizado = bloquePersonalizado;
    }

    @Override
    public void handle(MouseEvent event) {
        algoritmo.agregarBloque(bloquePersonalizado);
    }
}