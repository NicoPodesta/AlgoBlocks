package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Tablero;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlgoBlocks extends Application{

    @Override
    public void start(Stage stage) {
        stage.setTitle("AlgoBlocks");

        Tablero tablero = new Tablero();
        Dibujador dibujador = new Dibujador();
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(tablero, dibujador);
        Scene escenaPrincipal = new Scene(contenedorPrincipal, 1024, 668); //ver si esta bien pasar estos numeros
        stage.setScene(escenaPrincipal);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}