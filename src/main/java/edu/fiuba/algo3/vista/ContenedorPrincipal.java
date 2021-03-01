package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.Personaje;
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

import java.util.ArrayList;


public class ContenedorPrincipal extends BorderPane {

    public Dibujador dibujador;

    public ContenedorPrincipal(ArrayList<Bloque> algoritmo, Personaje personaje,
                               ArrayList<BloquePersonalizado> bloquesPersonalizados, Dibujador dibujador) {
        this.dibujador = dibujador;
        this.setLeft(nuevoContenedorBloques(algoritmo, personaje, bloquesPersonalizados));
        this.setCentro();
    }

    private HBox nuevoContenedorBloques(ArrayList<Bloque> algoritmo, Personaje personaje,
                                        ArrayList<BloquePersonalizado> bloquesPersonalizados) {
        Button bloqueArriba = new Button("Arriba");
        Button bloqueAbajo = new Button("Abajo");
        Button bloqueDerecha = new Button("Derecha");
        Button bloqueIzquierda = new Button("Izquierda");
        Button bloqueLevantarLapiz = new Button("LevantarLapiz");
        Button bloqueApoyarLapiz = new Button("ApoyarLapiz");
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
        bloquePersonalizado.setOnMouseClicked(new BotonPersonalizadoEventHandler(algoritmo, bloquesPersonalizados));

        Label tituloBloques = new Label("Bloques disponibles");
        Label tituloAlgoritmo = new Label("Algoritmo Actual");

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

    private VBox nuevoContenedorPizzarra() {
        Button ejecutar = new Button();
        ejecutar.setText("Ejecutar");

        Button guardarAlgoritmo = new Button();
        guardarAlgoritmo.setText("Guardar algoritmo");

        Button salir = new Button();
        salir.setText("Salir");

        HBox contenedorBotonesPizarra = new HBox(ejecutar, guardarAlgoritmo, salir);

        VBox contenedorPizarra = new VBox(contenedorBotonesPizarra, dibujador.getPane());
        contenedorPizarra.setMinWidth(512);
        contenedorPizarra.setStyle("-fx-border-color: black;-fx-border-width: 2");
        contenedorBotonesPizarra.setPadding(new Insets(30 , 0,50,85));
        contenedorBotonesPizarra.setSpacing(50);

        return contenedorPizarra;
    }

    private void setCentro() {
        this.setCenter(nuevoContenedorPizzarra());
    }

}