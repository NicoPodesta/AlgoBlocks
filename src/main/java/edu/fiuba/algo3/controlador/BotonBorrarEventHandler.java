package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoritmoVacioException;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonBorrarEventHandler implements EventHandler<MouseEvent> {

    protected ConjuntoBloques algoritmo;
    protected ContenedorPrincipal contenedor;


    public BotonBorrarEventHandler(ConjuntoBloques algoritmo, ContenedorPrincipal contenedor) {
        this.algoritmo = algoritmo;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(MouseEvent event) {
        try{
            algoritmo.removerUltimoBloque();
            contenedor.eliminarUltimoNombreBloque();
        } catch (AlgoritmoVacioException o) {}//ver si se quiere mandar un mensaje si no se puede remover o simplemente que no haga nada el boton
    }
}