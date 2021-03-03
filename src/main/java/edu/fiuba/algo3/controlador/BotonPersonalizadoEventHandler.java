package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorBloquePersonalizado;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
        Stage stage = new Stage();
        stage.setScene(new Scene(new ContenedorBloquePersonalizado(algoritmo, bloquesPersonalizados, stage),
                1024,668));
        stage.show();
    }
}