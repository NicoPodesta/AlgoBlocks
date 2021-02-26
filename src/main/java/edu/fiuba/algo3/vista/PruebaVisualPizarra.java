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
        //Creating a Path
        Path path = new Path();
        //Moving to the starting point
        MoveTo moveTo = new MoveTo(offset, offset);
        //Creating 1st line
        LineTo line1 = new LineTo(offset + TAM_LINEA, offset);


        //Adding all the elements to the path
        path.getElements().add(moveTo);
        path.getElements().addAll(line1);


        LineTo lineaPrevia = (LineTo) path.getElements().get(path.getElements().size() - 1);
        LineTo line2 = new LineTo(lineaPrevia.getX(), lineaPrevia.getY() + TAM_LINEA);
        path.getElements().add(line2);

        lineaPrevia = (LineTo) path.getElements().get(path.getElements().size() - 1);
        LineTo line3 = new LineTo(lineaPrevia.getX() + TAM_LINEA, lineaPrevia.getY());
        path.getElements().add(line3);

        path.setStrokeWidth(3.0);
        //Creating a Group object


        Pane root = new Pane(path);
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
