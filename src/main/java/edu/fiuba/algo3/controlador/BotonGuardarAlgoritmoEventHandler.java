package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorBloquePersonalizado;
import edu.fiuba.algo3.vista.ContenedorConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonGuardarAlgoritmoEventHandler implements EventHandler<MouseEvent> {

    private ArrayList<BloquePersonalizado> bloquesPersonalizados;
    private ConjuntoBloques algoritmo;

    public BotonGuardarAlgoritmoEventHandler(ConjuntoBloques algoritmo,
                                             ArrayList<BloquePersonalizado> bloquesPersonalizados) {
        this.algoritmo = algoritmo;
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