package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonTerminadoEventHandler;
import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorConjuntoBloques extends Contenedor {

    private ContenedorBotones contenedorBotones;
    private ContenedorAlgoritmo contenedorAlgoritmos;

    public ContenedorConjuntoBloques(ConjuntoBloques algoritmo, ConjuntoBloques conjunto,
                                     ArrayList<BloquePersonalizado> bloquesPersonalizados, Stage stage){
        contenedorBotones = new ContenedorBotones(conjunto, bloquesPersonalizados);
        contenedorAlgoritmos = new ContenedorAlgoritmo();
        agregarBotones(); //ver para los dos de setear el tamaño correcto
        agregarAlgoritmo(contenedorAlgoritmos);
        Button botonTerminado = new Button("Terminado");
        botonTerminado.setOnMouseClicked(new BotonTerminadoEventHandler(algoritmo, conjunto, stage));
        setRight(botonTerminado);
    }

    private void agregarBotones(){
        contenedorBotones.setPrefWidth(256);
        contenedorBotones.setSpacing(10);
        contenedorBotones.setPadding(new Insets(15 , 0,0,60));
        contenedorBotones.setStyle("-fx-border-color: black;-fx-border-width: 2;");

        setLeft(contenedorBotones);
    }

    private void agregarAlgoritmo(VBox contenedorAlgoritmo){

        contenedorAlgoritmo.setPrefWidth(256);
        contenedorAlgoritmo.setSpacing(10);
        contenedorAlgoritmo.setPadding(new Insets(15 , 0,0,85));
        contenedorAlgoritmo.setStyle("-fx-border-color: black;-fx-border-width: 2 1");

        setCenter(contenedorAlgoritmo);
    }

    public void agregarNombreBloque(Bloque bloque){
        contenedorAlgoritmos.agregar(new Label(bloque.obtenerNombre()));
    }

    public void eliminarUltimoNombreBloque(){
        contenedorAlgoritmos.removerUltimo();
    }
}
