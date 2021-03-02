package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.*;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;


public class ContenedorPrincipal extends BorderPane {

    private Dibujador dibujador;
    private ConjuntoBloques algoritmo;
    private ObservableList<Node> nombresBloquesAlgoritmo;

    public ContenedorPrincipal(ConjuntoBloques algoritmo, Personaje personaje,
                               ArrayList<BloquePersonalizado> bloquesPersonalizados, Dibujador dibujador) {
        this.dibujador = dibujador;
        this.algoritmo = algoritmo;
        this.setLeft(nuevoContenedorBloques(personaje, bloquesPersonalizados));
        this.setCentro();
    }

    private HBox nuevoContenedorBloques(Personaje personaje, ArrayList<BloquePersonalizado> bloquesPersonalizados) {
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

        bloqueArriba.setOnMouseClicked(new BotonArribaEventHandler(algoritmo,this));
        bloqueAbajo.setOnMouseClicked(new BotonAbajoEventHandler(algoritmo,this));
        bloqueDerecha.setOnMouseClicked(new BotonDerechaEventHandler(algoritmo,this));
        bloqueIzquierda.setOnMouseClicked(new BotonIzquierdaEventHandler(algoritmo,this));
        bloqueLevantarLapiz.setOnMouseClicked(new BotonLapizLevantadoEventHandler(algoritmo,this));
        bloqueApoyarLapiz.setOnMouseClicked(new BotonLapizApoyadoEventHandler(algoritmo,this));
        bloqueRepetirX2.setOnMouseClicked(new BotonRepetirX2EventHandler(algoritmo,this));
        bloqueRepetirX3.setOnMouseClicked(new BotonRepetirX3EventHandler(algoritmo,this));
        bloqueInvertir.setOnMouseClicked(new BotonInvertirEventHandler(algoritmo,this));
        bloquePersonalizado.setOnMouseClicked(new BotonPersonalizadoEventHandler(algoritmo, bloquesPersonalizados,
                this));

        Label tituloBloques = new Label("Bloques disponibles");

        VBox contenedorBotones = new VBox(tituloBloques, bloqueArriba, bloqueAbajo, bloqueDerecha, bloqueIzquierda,
                bloqueLevantarLapiz, bloqueApoyarLapiz, bloqueRepetirX2, bloqueRepetirX3, bloqueInvertir,
                bloquePersonalizado);
        contenedorBotones.setPrefWidth(256);
        contenedorBotones.setSpacing(10);
        contenedorBotones.setPadding(new Insets(15 , 0,0,60));
        contenedorBotones.setStyle("-fx-border-color: black;-fx-border-width: 2;");

        VBox contenedorAlgoritmo = new VBox(new Label("Algoritmo Actual"));
        nombresBloquesAlgoritmo = contenedorAlgoritmo.getChildren();
        contenedorAlgoritmo.setPrefWidth(256);
        contenedorAlgoritmo.setPadding(new Insets(15 , 0,0,85));
        contenedorAlgoritmo.setStyle("-fx-border-color: black;-fx-border-width: 2 1");

        return new HBox(contenedorBotones, contenedorAlgoritmo);
    }

    private VBox nuevoContenedorPizzarra() {
        Button ejecutar = new Button("Ejecutar");

        Button guardarAlgoritmo = new Button("Guardar algoritmo");

        Button salir = new Button("Salir");

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

    public void agregarNombreBloque(String nombre) {
        nombresBloquesAlgoritmo.add(new Label(nombre));
    }
}