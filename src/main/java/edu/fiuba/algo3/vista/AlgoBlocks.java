package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.controlador.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlgoBlocks extends Application{

    @Override
    public void start(Stage stage) {
        stage.setTitle("AlgoBlocks");

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

        Label tituloBloques = new Label();
        tituloBloques.setText("Bloques disponibles");
        Label tituloAlgoritmo = new Label();
        tituloAlgoritmo.setText("Algoritmo Actual");

        Button ejecutar = new Button();
        ejecutar.setText("Ejecutar");

        Button guardarAlgoritmo = new Button();
        guardarAlgoritmo.setText("Guardar algoritmo");

        Button salir = new Button();
        salir.setText("Salir");

        HBox contenedorBotones = new HBox(ejecutar, guardarAlgoritmo, salir);

        VBox contenedorBloques = new VBox(tituloBloques, bloqueArriba, bloqueAbajo, bloqueDerecha, bloqueIzquierda,
                bloqueLevantarLapiz, bloqueApoyarLapiz);
        contenedorBloques.setPrefWidth(256);
        contenedorBloques.setSpacing(10);
        contenedorBloques.setPadding(new Insets(15 , 0,0,60));
        contenedorBloques.setStyle("-fx-border-color: black;-fx-border-width: 2;");

        VBox contenedorAlgoritmo = new VBox(tituloAlgoritmo);
        contenedorAlgoritmo.setPrefWidth(256);
        contenedorAlgoritmo.setPadding(new Insets(15 , 0,0,85));
        contenedorAlgoritmo.setStyle("-fx-border-color: black;-fx-border-width: 2 1");

        VBox contenedorPizarra = new VBox(contenedorBotones, armarPizarra());
        contenedorPizarra.setMinWidth(512);
        contenedorPizarra.setStyle("-fx-border-color: black;-fx-border-width: 2");
        contenedorBotones.setPadding(new Insets(55 , 0,0,85));
        contenedorBotones.setSpacing(50);

        HBox contenedorPrincipal = new HBox(contenedorBloques, contenedorAlgoritmo, contenedorPizarra);

        Tablero tablero = new Tablero();
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

        Scene escenaPrincipal = new Scene(contenedorPrincipal, 960,650);
        stage.setScene(escenaPrincipal);
        stage.show();
    }

    public GridPane armarPizarra(){
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

    public static void main(String[] args) {
        launch();
    }
}