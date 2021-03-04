package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorBotones;
import edu.fiuba.algo3.vista.ContenedorGuardarAlgoritmo;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonGuardarAlgoritmoEventHandler extends BotonConjuntoBloquesEventHandler {

    ContenedorBotones contenedorBotones;

    public BotonGuardarAlgoritmoEventHandler(ConjuntoBloques algoritmo, ContenedorBotones contenedor) {

        super(algoritmo);
        contenedorBotones = contenedor;
    }

    @Override
    public void handle(MouseEvent event) {
        Stage stage = new Stage();
        stage.setScene(new Scene(new ContenedorGuardarAlgoritmo(algoritmo, contenedorBotones),
                520,120));
        stage.setTitle("Guardar algoritmo personalizado");
        stage.show();
    }
}