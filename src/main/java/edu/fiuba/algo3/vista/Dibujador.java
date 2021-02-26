package edu.fiuba.algo3.vista;

import javafx.scene.Group;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Dibujador {
    public final int n = 10; //Numero de posibles segmentos
    public final int TAM_LINEA = 75; //Tamaño de cada linea
    private Group grupo;
    private Path recorrido;

    private double x_anterior;
    private double y_anterior;

    public Dibujador(Path recorrido, int posInicialRecorrido){
        //Group grupo = new Group(path); Ejemplos de google dicen que hay que agregar el recorrido a un objeto de tipo grupo pero no veo cambio alguno, lo dejo por las dudas
        this.recorrido = recorrido;
        this.recorrido.setStrokeWidth(3.0);
        this.recorrido.getElements().add(new MoveTo(posInicialRecorrido, posInicialRecorrido)); //Posicion inicial del recorrido
        actualizarXeYPrevios();
    }

    private void actualizarXeYPrevios(){
        LineTo lineaPrevia = (LineTo) this.recorrido.getElements().get(this.recorrido.getElements().size() - 1);
        x_anterior = lineaPrevia.getX();
        y_anterior = lineaPrevia.getY();
    }
}
