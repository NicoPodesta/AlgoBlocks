package edu.fiuba.algo3.vista;

import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class VistaLapizLevantado implements VistaLapiz {
    public Path recorrido;
    public Pane root;

    public double x_anterior;
    public double y_anterior;

    public VistaLapizLevantado(Path recorrido, Pane root, double x_anterior, double y_anterior){
        this.recorrido = recorrido;
        this.root = root;
        this.x_anterior = x_anterior;
        this.y_anterior = y_anterior;
        inicializarRecorrido();
    }

    private void inicializarRecorrido(){
        //Inicializa el recorrido con un objeto MoveTo, desde aca se arma todo el recorrido
        this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior)); //Posicion inicial del recorrido
    }
    @Override
    public void dibujarArriba() {
        this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior - TAM_LINEA));
        this.y_anterior = y_anterior - TAM_LINEA;
    }

    @Override
    public void dibujarAbajo() {
        this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior + TAM_LINEA));
        this.y_anterior = y_anterior + TAM_LINEA;
    }

    @Override
    public void dibujarDerecha() {
        this.recorrido.getElements().add(new MoveTo(x_anterior + TAM_LINEA, y_anterior));
        this.x_anterior = x_anterior + TAM_LINEA;
    }

    @Override
    public void dibujarIzquierda() {
        this.recorrido.getElements().add(new MoveTo(x_anterior - TAM_LINEA, y_anterior));
        this.x_anterior = x_anterior - TAM_LINEA;
    }

    @Override
    public void actualizarXeYPrevios() {
        LineTo lineaPrevia = (LineTo) this.recorrido.getElements().get(this.recorrido.getElements().size() - 1);
        x_anterior = lineaPrevia.getX();
        y_anterior = lineaPrevia.getY();
    }
}
