package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;


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
    @Override
    public void start(Stage stage)  {
        //Creating a Path
        Path path = new Path();

        //Moving to the starting point
        MoveTo moveTo = new MoveTo(10, 10);

        //Creating 1st line
        LineTo line1 = new LineTo(20, 10);

        //Creating 2nd line
        LineTo line2 = new LineTo(20,20);

        //Creating 3rd line
        LineTo line3 = new LineTo(10,20);

        //Creating 4th line
        LineTo line4 = new LineTo(0, 0);

        //Creating 4th line
        LineTo line5 = new LineTo(10, 10);

        //Adding all the elements to the path
        path.getElements().add(moveTo);
        path.getElements().addAll(line1, line2, line3, line4, line5);

        path.setStrokeWidth(3.0);
        //Creating a Group object
        Group root = new Group(path);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);

        //Setting title to the Stage
        stage.setTitle("Drawing an arc through a path");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }
}
