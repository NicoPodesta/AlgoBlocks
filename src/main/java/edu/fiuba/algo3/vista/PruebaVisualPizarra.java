package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;

public class PruebaVisualPizarra  extends Application {
    public final int n = 10; //Numero de posibles segmentos
    public final int TAM_LINEA = 75; //Tamaño de cada linea
    public final int offset = 25;
    @Override
    public void start(Stage stage)  {
        Dibujador dibujador = new Dibujador();
        stage.setScene(dibujador.getEscena());
        stage.setTitle("Pizarra");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
