package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloqueInvertir;
import edu.fiuba.algo3.modelo.BloqueRepetir;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BotonInvertirEventHandler extends BotonBloqueEventHandler {

    public BotonInvertirEventHandler(ConjuntoBloques algoritmo ) {
        super(algoritmo);
    }

    @Override
    public void handle(MouseEvent event) {
        BloqueInvertir bloqueinvertir = new BloqueInvertir();
        Stage stage = new Stage();
        stage.setScene(new Scene(new ContenedorConjuntoBloques(algoritmo, bloqueinvertir),1024,668));
        stage.show();
    }
}