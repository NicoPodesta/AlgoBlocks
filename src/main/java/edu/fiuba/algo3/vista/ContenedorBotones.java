package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ContenedorBotones extends VBox {

    public ContenedorBotones(ConjuntoBloques algoritmo, ArrayList<BloquePersonalizado> bloquesPersonalizados) {

        Label tituloBloques = new Label("Bloques disponibles");
        tituloBloques.setStyle("-fx-font-weight:bold");

        Button bloqueArriba = new Button("Arriba");
        Button bloqueAbajo = new Button("Abajo");
        Button bloqueDerecha = new Button("Derecha");
        Button bloqueIzquierda = new Button("Izquierda");
        Button bloqueLevantarLapiz = new Button("Levantar Lapiz");
        Button bloqueApoyarLapiz = new Button("Apoyar Lapiz");
        Button bloqueRepetirX2 = new Button("RepetirX2");
        Button bloqueRepetirX3 = new Button("RepetirX3");
        Button bloqueInvertir = new Button("Invertir Comportamiento");
        Button bloquePersonalizado = new Button("Personalizado");

        bloqueArriba.setOnMouseClicked(new BotonArribaEventHandler(algoritmo));
        bloqueAbajo.setOnMouseClicked(new BotonAbajoEventHandler(algoritmo));
        bloqueDerecha.setOnMouseClicked(new BotonDerechaEventHandler(algoritmo));
        bloqueIzquierda.setOnMouseClicked(new BotonIzquierdaEventHandler(algoritmo));
        bloqueLevantarLapiz.setOnMouseClicked(new BotonLapizLevantadoEventHandler(algoritmo));
        bloqueApoyarLapiz.setOnMouseClicked(new BotonLapizApoyadoEventHandler(algoritmo));
        bloqueRepetirX2.setOnMouseClicked(new BotonRepetirX2EventHandler(algoritmo, bloquesPersonalizados));
        bloqueRepetirX3.setOnMouseClicked(new BotonRepetirX3EventHandler(algoritmo, bloquesPersonalizados));
        bloqueInvertir.setOnMouseClicked(new BotonInvertirEventHandler(algoritmo, bloquesPersonalizados));
        bloquePersonalizado.setOnMouseClicked(new BotonPersonalizadoEventHandler(algoritmo, bloquesPersonalizados));

        ObservableList<Node> nodos = this.getChildren();
        nodos.add(tituloBloques);
        nodos.add(bloqueAbajo);
        nodos.add(bloqueArriba);
        nodos.add(bloqueDerecha);
        nodos.add(bloqueIzquierda);
        nodos.add(bloqueLevantarLapiz);
        nodos.add(bloqueApoyarLapiz);
        nodos.add(bloqueRepetirX2);
        nodos.add(bloqueRepetirX3);
        nodos.add(bloqueInvertir);
        nodos.add(bloquePersonalizado);
    }
}