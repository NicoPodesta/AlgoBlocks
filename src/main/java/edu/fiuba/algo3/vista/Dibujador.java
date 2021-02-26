package edu.fiuba.algo3.vista;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Dibujador {
    private final int n = 10; //Numero de posibles segmentos
    private final int TAM_LINEA = 75; //Tamaño de cada linea
    private final int posInicialRecorrido = 25;

    private Path recorrido;
    private Pane root;
    private Scene scene;
    private double x_anterior;
    private double y_anterior;


    public Dibujador(){
        //Group grupo = new Group(path); Ejemplos de google dicen que hay que agregar el recorrido a un objeto de tipo grupo pero no veo cambio alguno, lo dejo por las dudas
        this.recorrido = new Path();
        this.root = new Pane(this.recorrido);
        this.root.setPrefSize(n * TAM_LINEA, n * TAM_LINEA);
        this.recorrido.setStrokeWidth(3.0);
        inicializarRecorrido();
        this.scene  = new Scene(root, Color.WHITE);
    }

    private void inicializarRecorrido(){
        this.recorrido.getElements().add(new MoveTo(posInicialRecorrido, posInicialRecorrido)); //Posicion inicial del recorrido
        x_anterior = posInicialRecorrido;
        y_anterior = posInicialRecorrido;
    }

    private void actualizarXeYPrevios(){
        LineTo lineaPrevia = (LineTo) this.recorrido.getElements().get(this.recorrido.getElements().size() - 1);
        x_anterior = lineaPrevia.getX();
        y_anterior = lineaPrevia.getY();
    }

    public Scene getEscena(){
        return scene;
    }
}
