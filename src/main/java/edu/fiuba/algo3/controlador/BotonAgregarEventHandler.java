package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoritmoVacioException;
import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorBotones;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BotonAgregarEventHandler implements EventHandler<MouseEvent> {

    private ConjuntoBloques algoritmo;
    private BloquePersonalizado bloquePersonalizado;
    private TextField texto;
    private ContenedorBotones contenedorBotones;

    public BotonAgregarEventHandler(ConjuntoBloques algoritmo ,
                                    TextField texto, ContenedorBotones contenedorBotones) {
        this.algoritmo = algoritmo;
        this.texto = texto;
        this.contenedorBotones = contenedorBotones;
    }

    @Override
    public void handle(MouseEvent event) {
        bloquePersonalizado = new BloquePersonalizado(texto.getText());
        contenedorBotones.habilitarBLoquePersonalizado(texto.getText(), bloquePersonalizado, algoritmo);
        contenedorBotones.agregarVista(bloquePersonalizado);
        try {
            bloquePersonalizado.agregarAlgoritmo(algoritmo);
        } catch (AlgoritmoVacioException o){}
    }
}