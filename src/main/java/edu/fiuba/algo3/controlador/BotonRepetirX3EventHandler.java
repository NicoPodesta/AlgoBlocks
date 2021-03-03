package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.BloqueRepetir;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorConjuntoBloques;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonRepetirX3EventHandler extends BotonConjuntoBloquesEventHandler {

    public BotonRepetirX3EventHandler(ConjuntoBloques algoritmo, ArrayList<BloquePersonalizado> bloquesPersonalizados) {
        super(algoritmo, bloquesPersonalizados);
    }

    @Override
    public void handle(MouseEvent event) {
        BloqueRepetir bloqueRepetir = new BloqueRepetir(3);
        Stage stage = new Stage();
        stage.setScene(new Scene(new ContenedorConjuntoBloques(algoritmo, bloqueRepetir, bloquesPersonalizados, stage),
                1024,668));
        stage.show();
    }
}