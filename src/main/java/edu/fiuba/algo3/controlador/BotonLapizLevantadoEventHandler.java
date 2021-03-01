package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueLapizLevantado;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class BotonLapizLevantadoEventHandler extends BotonBloqueEventHandler {

    public BotonLapizLevantadoEventHandler(ArrayList<Bloque> algoritmo) {
        super(algoritmo);
    }

    @Override
    public void handle(MouseEvent event) {
        algoritmo.add(new BloqueLapizLevantado());
    }
}