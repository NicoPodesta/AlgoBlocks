package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueIzquierda;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class BotonIzquierdaEventHandler extends BotonBloqueEventHandler {

    public BotonIzquierdaEventHandler(ConjuntoBloques algoritmo, ContenedorPrincipal contenedor) {
        super(algoritmo, contenedor);
    }

    @Override
    public void handle(MouseEvent event) {
        algoritmo.agregarBloque(new BloqueIzquierda());
        contenedor.agregarNombreBloque("Izquierda");
    }
}