package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AlgoBlocks extends Application{

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("AlgoBlocks");

        Button bloqueArriba = new Button();
        bloqueArriba.setText("bloqueArriba");
        Button bloqueAbajo = new Button();
        bloqueAbajo.setText("bloqueAbajo");
        Button bloqueDerecha = new Button();
        bloqueDerecha.setText("bloqueDerecha");
        Button bloqueIzquierda = new Button();
        bloqueIzquierda.setText("bloqueIzquierda");
        Button bloqueLevantarLapiz = new Button();
        bloqueLevantarLapiz.setText("bloqueLevantarLapiz");
        Button bloqueBajarLapiz = new Button();
        bloqueBajarLapiz.setText("bloqueBajarLapiz");

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

        VBox contenedorBloques = new VBox(tituloBloques, bloqueArriba, bloqueAbajo, bloqueDerecha, bloqueIzquierda, bloqueLevantarLapiz, bloqueBajarLapiz);
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


        BotonBLoqueEventHandler bloqueArribaEventHandler = new BotonBLoqueEventHandler(bloqueArriba);
        BotonBLoqueEventHandler bloqueAbajoEventHandler = new BotonBLoqueEventHandler(bloqueAbajo);
        BotonBLoqueEventHandler bloqueDerechaEventHandler = new BotonBLoqueEventHandler(bloqueDerecha);
        BotonBLoqueEventHandler bloqueIzquierdaEventHandler = new BotonBLoqueEventHandler(bloqueIzquierda);
        BotonBLoqueEventHandler bloqueLevantarLapizEventHandler = new BotonBLoqueEventHandler(bloqueLevantarLapiz);
        BotonBLoqueEventHandler bloqueBajarLapizEventHandler = new BotonBLoqueEventHandler(bloqueBajarLapiz);

        bloqueArriba.setOnDragDetected(bloqueArribaEventHandler);
        bloqueAbajo.setOnDragDetected(bloqueAbajoEventHandler);
        bloqueDerecha.setOnDragDetected(bloqueDerechaEventHandler);
        bloqueIzquierda.setOnDragDetected(bloqueIzquierdaEventHandler);
        bloqueLevantarLapiz.setOnDragDetected(bloqueLevantarLapizEventHandler);
        bloqueBajarLapiz.setOnDragDetected(bloqueBajarLapizEventHandler);

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
