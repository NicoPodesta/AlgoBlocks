package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class ContenedorPrincipal extends BorderPane {

    public ContenedorPrincipal(Tablero tablero){
        this.setContenedorBloques(tablero);
        this.setCentro();
    }

    private HBox nuevoContenedorBloques(Tablero tablero){
        Button bloqueArriba = new Button();
        bloqueArriba.setText("Arriba");
        Button bloqueAbajo = new Button();
        bloqueAbajo.setText("Abajo");
        Button bloqueDerecha = new Button();
        bloqueDerecha.setText("Derecha");
        Button bloqueIzquierda = new Button();
        bloqueIzquierda.setText("Izquierda");
        Button bloqueLevantarLapiz = new Button();
        bloqueLevantarLapiz.setText("LevantarLapiz");
        Button bloqueApoyarLapiz = new Button();
        bloqueApoyarLapiz.setText("ApoyarLapiz");
        Button bloqueRepetirX2 = new Button();
        bloqueRepetirX2.setText("RepetirX2");
        Button bloqueRepetirX3 = new Button();
        bloqueRepetirX3.setText("RepetirX3");
        Button bloqueInvertir = new Button();
        bloqueInvertir.setText("Invertir Comportamiento");
        Button bloquePersonalizado = new Button();
        bloquePersonalizado.setText("Personalizado");

        BotonArribaEventHandler arribaEventHandler = new BotonArribaEventHandler(tablero);
        BotonAbajoEventHandler abajoEventHandler = new BotonAbajoEventHandler(tablero);
        BotonDerechaEventHandler derechaEventHandler = new BotonDerechaEventHandler(tablero);
        BotonIzquierdaEventHandler izquierdaEventHandler = new BotonIzquierdaEventHandler(tablero);
        BotonLapizLevantadoEventHandler lapizLevantadoEventHandler = new BotonLapizLevantadoEventHandler(tablero);
        BotonLapizApoyadoEventHandler lapizApoyadoEventHandler = new BotonLapizApoyadoEventHandler(tablero);

        bloqueArriba.setOnDragDetected(arribaEventHandler);
        bloqueAbajo.setOnDragDetected(abajoEventHandler);
        bloqueDerecha.setOnDragDetected(derechaEventHandler);
        bloqueIzquierda.setOnDragDetected(izquierdaEventHandler);
        bloqueLevantarLapiz.setOnDragDetected(lapizLevantadoEventHandler);
        bloqueApoyarLapiz.setOnDragDetected(lapizApoyadoEventHandler);

        Label tituloBloques = new Label();
        tituloBloques.setText("Bloques disponibles");
        Label tituloAlgoritmo = new Label();
        tituloAlgoritmo.setText("Algoritmo Actual");

        VBox contenedorBotones = new VBox(tituloBloques, bloqueArriba, bloqueAbajo, bloqueDerecha, bloqueIzquierda,
                bloqueLevantarLapiz, bloqueApoyarLapiz, bloqueRepetirX2, bloqueRepetirX3, bloqueInvertir,
                bloquePersonalizado);
        contenedorBotones.setPrefWidth(256);
        contenedorBotones.setSpacing(10);
        contenedorBotones.setPadding(new Insets(15 , 0,0,60));
        contenedorBotones.setStyle("-fx-border-color: black;-fx-border-width: 2;");

        VBox contenedorAlgoritmo = new VBox(tituloAlgoritmo);
        contenedorAlgoritmo.setPrefWidth(256);
        contenedorAlgoritmo.setPadding(new Insets(15 , 0,0,85));
        contenedorAlgoritmo.setStyle("-fx-border-color: black;-fx-border-width: 2 1");

        return new HBox(contenedorBotones, contenedorAlgoritmo);
    }

    private void setContenedorBloques(Tablero tablero){

        this.setLeft(nuevoContenedorBloques(tablero));

    }

    private VBox nuevoContenedorPizzarra(){
        Button ejecutar = new Button();
        ejecutar.setText("Ejecutar");

        Button guardarAlgoritmo = new Button();
        guardarAlgoritmo.setText("Guardar algoritmo");

        Button salir = new Button();
        salir.setText("Salir");

        HBox contenedorBotonesPizarra = new HBox(ejecutar, guardarAlgoritmo, salir);

        VBox contenedorPizarra = new VBox(contenedorBotonesPizarra, armarPizarra());
        contenedorPizarra.setMinWidth(512);
        contenedorPizarra.setStyle("-fx-border-color: black;-fx-border-width: 2");
        contenedorBotonesPizarra.setPadding(new Insets(55 , 0,0,85));
        contenedorBotonesPizarra.setSpacing(50);

        return contenedorPizarra;
    }

    private void setCentro(){

        this.setCenter(nuevoContenedorPizzarra());
    }

    private GridPane armarPizarra(){
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(80,0,0,0));
        for(int y = 0; y < 10; y++){
            for(int x = 0; x < 10; x++){

                // Create a new TextField in each Iteration
                TextField tf = new TextField();
                tf.setPrefHeight(50);
                tf.setPrefWidth(50);
                tf.setAlignment(Pos.CENTER);
                tf.setEditable(false);

                // Iterate the Index using the loops
                gridPane.setRowIndex(tf,y);
                gridPane.setColumnIndex(tf,x);
                gridPane.getChildren().add(tf);
            }
        }
        return gridPane;
    }
}
