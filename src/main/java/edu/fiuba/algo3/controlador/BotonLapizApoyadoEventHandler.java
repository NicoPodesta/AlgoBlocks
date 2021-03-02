package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueLapizApoyado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.scene.input.MouseEvent;

public class BotonLapizApoyadoEventHandler extends BotonBloqueEventHandler {

    public BotonLapizApoyadoEventHandler(ConjuntoBloques algoritmo, ContenedorPrincipal contenedor) {
        super(algoritmo, contenedor);
    }

    @Override
    public void handle(MouseEvent event) {
        Bloque bloque = new BloqueLapizApoyado();
        algoritmo.agregarBloque(bloque);
        contenedor.agregarNombreBloque(bloque);
    }
}