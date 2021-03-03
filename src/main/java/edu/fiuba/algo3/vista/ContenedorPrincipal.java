package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class ContenedorPrincipal extends BorderPane {

    final private Dibujador dibujador;
    final private ConjuntoBloques algoritmo;
    final private ContenedorBotones contenedorBotones;
    private ContenedorAlgoritmo contenedorAlgoritmo;

    public ContenedorPrincipal(ConjuntoBloques algoritmo, Personaje personaje,
                               ArrayList<BloquePersonalizado> bloquesPersonalizados, Dibujador dibujador) {
        this.dibujador = dibujador;
        this.algoritmo = algoritmo;
        this.contenedorBotones = new ContenedorBotones();
        this.contenedorAlgoritmo = new ContenedorAlgoritmo();
        this.setLeft(nuevoContenedorBloques(personaje, bloquesPersonalizados, algoritmo));
        this.setCenter(nuevoContenedorPizzarra(personaje, bloquesPersonalizados));
    }

    private HBox nuevoContenedorBloques(Personaje personaje, ArrayList<BloquePersonalizado> bloquesPersonalizados, ConjuntoBloques algoritmo) {

        VBox contenedorBotones = this.contenedorBotones.crearContenedorBotones(algoritmo);
        contenedorBotones.setPrefWidth(256);
        contenedorBotones.setSpacing(10);
        contenedorBotones.setPadding(new Insets(15 , 0,0,60));
        contenedorBotones.setStyle("-fx-border-color: black;-fx-border-width: 2;");

        VBox contenedorAlgoritmo = this.contenedorAlgoritmo.obtenerContenedor();
        contenedorAlgoritmo.setPrefWidth(256);
        contenedorAlgoritmo.setSpacing(10);
        contenedorAlgoritmo.setPadding(new Insets(15 , 0,0,85));
        contenedorAlgoritmo.setStyle("-fx-border-color: black;-fx-border-width: 2 1");

        return new HBox(contenedorBotones, contenedorAlgoritmo);
    }

    private VBox nuevoContenedorPizzarra(Personaje personaje, ArrayList<BloquePersonalizado> bloquesPersonalizados) {

        Button botonBorrar = new Button("Borrar Ultimo Bloque");
        Button botonGuardarAlgoritmo = new Button("Guardar algoritmo");
        Button botonEjecutar = new Button("Ejecutar");

        botonBorrar.setOnMouseClicked(new BotonBorrarEventHandler(algoritmo, this));
        /*botonGuardarAlgoritmo.setOnMouseClicked(new BotonGuardarAlgoritmoEventHandler(algoritmo, bloquesPersonalizados,
                this));*/

        botonEjecutar.setOnMouseClicked(new BotonEjecutarEventHandler(algoritmo, personaje));

        HBox contenedorBotonesPizarra = new HBox(botonBorrar, botonGuardarAlgoritmo, botonEjecutar);

        VBox contenedorPizarra = new VBox(contenedorBotonesPizarra, dibujador.getPane());
        contenedorPizarra.setMinWidth(512);
        contenedorPizarra.setStyle("-fx-border-color: black;-fx-border-width: 2");
        contenedorBotonesPizarra.setPadding(new Insets(30 , 0,50,85));
        contenedorBotonesPizarra.setSpacing(50);

        return contenedorPizarra;
    }

    public void agregarNombreBloque(Bloque bloque) {
        this.contenedorAlgoritmo.agregar(new Button(bloque.obtenerNombre()));
    }

   /* // la idea es que los conjuntos de bloques sean azules y se puedan clickear para ver su contenido
    public void agregarNombreConjuntoBloques(ConjuntoBloques conjunto) {
        Label nuevoLabel = new Label(conjunto.obtenerNombre());
        nuevoLabel.setTextFill(Color.BLUE);
        nuevoLabel.setOnMouseClicked(new LabelConjuntoBloquesEventHandler(conjunto));
        nombresBloquesAlgoritmo.add(nuevoLabel);
    }*/

    public void eliminarUltimoNombreBloque() {
        this.contenedorAlgoritmo.removerUltimo();
    }
}