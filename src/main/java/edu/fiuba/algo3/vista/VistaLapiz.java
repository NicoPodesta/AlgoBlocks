package edu.fiuba.algo3.vista;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.Path;

public interface VistaLapiz {

    int n = 10; //Numero de posibles segmentos
    int TAM_LINEA = 51; //Tamaño de cada linea

    public void dibujarArriba();
    public void dibujarAbajo();
    public void dibujarDerecha();
    public void dibujarIzquierda();
    public void actualizarXeYPrevios();

}
