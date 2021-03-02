package edu.fiuba.algo3.vista;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class VistaLapizApoyado implements VistaLapiz {
    public Path recorrido;
    public Pane root;

    public double x_anterior;
    public double y_anterior;

    public VistaLapizApoyado(Path recorrido, Pane root, double x_anterior, double y_anterior) {
        this.recorrido = recorrido;
        this.root = root;
        this.x_anterior = x_anterior;
        this.y_anterior = y_anterior;
    }

    @Override
    public void dibujarArriba() {
        if(y_anterior == 0){
            y_anterior = n * TAM_LINEA;
            this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior));
        }
        dibujarCirculo();
        this.recorrido.getElements().add(new LineTo(x_anterior, y_anterior - TAM_LINEA));
        actualizarXeYPrevios();
        dibujarCirculo();
    }

    @Override
    public void dibujarAbajo() {
        if(y_anterior == n * TAM_LINEA){
            y_anterior = 0;
            this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior));
        }
        dibujarCirculo();
        this.recorrido.getElements().add(new LineTo(x_anterior, y_anterior + TAM_LINEA));
        actualizarXeYPrevios();
        dibujarCirculo();
    }

    @Override
    public void dibujarDerecha() {
        if(x_anterior == n * TAM_LINEA){
            x_anterior = 0;
            this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior));
        }
        dibujarCirculo();
        this.recorrido.getElements().add(new LineTo(x_anterior + TAM_LINEA, y_anterior));
        actualizarXeYPrevios();
        dibujarCirculo();
    }

    @Override
    public void dibujarIzquierda() {
        if(x_anterior == 0){
            x_anterior = n * TAM_LINEA;
            this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior));
        }
        dibujarCirculo();
        this.recorrido.getElements().add(new LineTo(x_anterior - TAM_LINEA, y_anterior));
        actualizarXeYPrevios();
        dibujarCirculo();
    }

    @Override
    public void actualizarXeYPrevios() {
        LineTo lineaPrevia = (LineTo) this.recorrido.getElements().get(this.recorrido.getElements().size() - 1);
        x_anterior = lineaPrevia.getX();
        y_anterior = lineaPrevia.getY();
    }

    private void dibujarCirculo(){
        Circle circulo = new Circle(x_anterior, y_anterior, 4);
        circulo.setFill(Color.BLACK);
        this.root.getChildren().add(circulo);
    }
}