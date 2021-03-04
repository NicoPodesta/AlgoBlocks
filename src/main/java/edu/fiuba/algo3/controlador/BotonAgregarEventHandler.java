package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonAgregarEventHandler implements EventHandler<MouseEvent> {

    private ConjuntoBloques algoritmo;
    private ArrayList<BloquePersonalizado> bloquesPersonalizados;
    private TextField texto;
    private Stage stage;

    public BotonAgregarEventHandler(ConjuntoBloques algoritmo, ArrayList<BloquePersonalizado> bloquesPersonalizados,
                                    TextField texto, Stage stage) {
        this.algoritmo = algoritmo;
        this.bloquesPersonalizados = bloquesPersonalizados;
        this.texto = texto;
        this.stage = stage;
    }

    @Override
    public void handle(MouseEvent event) {
        BloquePersonalizado bloque = new BloquePersonalizado(texto.getText(), algoritmo);
        bloquesPersonalizados.add(bloque);
        stage.close();
    }
}