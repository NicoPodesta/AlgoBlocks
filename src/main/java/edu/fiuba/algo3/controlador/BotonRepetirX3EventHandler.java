package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloqueRepetir;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BotonRepetirX3EventHandler extends BotonBloqueEventHandler {

    public BotonRepetirX3EventHandler(ConjuntoBloques algoritmo) {
        super(algoritmo);
    }

    @Override
    public void handle(MouseEvent event) {
        BloqueRepetir bloqueRepetir = new BloqueRepetir(3);
        Stage stage = new Stage();
        stage.setScene(new Scene(new ContenedorConjuntoBloques(algoritmo, bloqueRepetir),1024,668));
        stage.show();
    }
}