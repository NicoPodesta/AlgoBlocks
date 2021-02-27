package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;

public class PruebaVisualPizarra  extends Application {
    @Override
    public void start(Stage stage)  {
        Dibujador dibujador = new Dibujador();
        dibujador.dibujarLineaDerecha();
        dibujador.dibujarLineaDerecha();
        dibujador.dibujarLineaDerecha();
        stage.setScene(dibujador.getEscena());
        stage.setTitle("Pizarra");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
