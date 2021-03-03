package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ContenedorBotones {


    public ContenedorBotones(){
    }

    public VBox crearContenedorBotones(ConjuntoBloques algoritmo){
        Label tituloBloques = new Label("Bloques disponibles");

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
        bloqueRepetirX2.setOnMouseClicked(new BotonRepetirX2EventHandler(algoritmo));
        bloqueRepetirX3.setOnMouseClicked(new BotonRepetirX3EventHandler(algoritmo));
        bloqueInvertir.setOnMouseClicked(new BotonInvertirEventHandler(algoritmo));
        //bloquePersonalizado.setOnMouseClicked(new BotonPersonalizadoEventHandler(algoritmo));

        return new VBox(tituloBloques, bloqueAbajo, bloqueArriba, bloqueDerecha, bloqueIzquierda, bloqueLevantarLapiz, bloqueApoyarLapiz, bloqueRepetirX2, bloqueRepetirX3, bloqueInvertir);
    }
}
