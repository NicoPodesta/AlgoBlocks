package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorBotones;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonAgregarEventHandler implements EventHandler<MouseEvent> {

    private ConjuntoBloques algoritmo;
    private BloquePersonalizado bloquePersonalizado;
    private TextField texto;
    private Stage stage;
    private ContenedorBotones contenedorBotones;

    public BotonAgregarEventHandler(ConjuntoBloques algoritmo, BloquePersonalizado bloquePersonalizado,
                                    TextField texto, Stage stage, ContenedorBotones contenedorBotones) {
        this.algoritmo = algoritmo;
        this.bloquePersonalizado = bloquePersonalizado;
        this.texto = texto;
        this.stage = stage;
        this.contenedorBotones = contenedorBotones;
    }

    @Override
    public void handle(MouseEvent event) {
        bloquePersonalizado = new BloquePersonalizado(texto.getText(), algoritmo);
        contenedorBotones.habilitarBLoquePersonalizado(texto.getText());
        stage.close();
    }
}