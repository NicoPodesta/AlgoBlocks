package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


import edu.fiuba.algo3.modelo.Tablero;
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

public class PruebaVisualPizarra  extends Application {
    final int n = 10; // number of squares in each row and column
    final int TAM_LINEA = 75; // length of each square  in pixels
    final int offset = 25;
    @Override
    public void start(Stage stage)  {
        int cant_lineas = 0;
        //Creating a Path
        Path path = new Path();
        //Moving to the starting point
        MoveTo moveTo = new MoveTo(offset, offset);
        //Creating 1st line
        LineTo line1 = new LineTo(offset + TAM_LINEA, offset);
        cant_lineas++;


        //Adding all the elements to the path
        path.getElements().add(moveTo);
        path.getElements().addAll(line1);


        LineTo lineaPrevia = (LineTo) path.getElements().get(cant_lineas);
        LineTo line2 = new LineTo(lineaPrevia.getX(), lineaPrevia.getY() + TAM_LINEA);
        cant_lineas++;
        path.getElements().add(line2);


        lineaPrevia = (LineTo) path.getElements().get(cant_lineas);
        LineTo line3 = new LineTo(lineaPrevia.getX() + TAM_LINEA, lineaPrevia.getY());
        cant_lineas++;
        path.getElements().add(line3);







        path.setStrokeWidth(3.0);
        //Creating a Group object
        Group grupo = new Group(path);

        Pane root = new Pane(grupo);

        root.setPrefSize(n * TAM_LINEA, n * TAM_LINEA);

        Scene scene = new Scene(root, Color.WHITE);

        stage.setScene(scene);
        stage.setTitle("Pizarra");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
