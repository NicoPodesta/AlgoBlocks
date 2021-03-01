package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Dibujador {
    private final int n = 10; //Numero de posibles segmentos
    private final int TAM_LINEA = 51; //Tamaño de cada linea
    private final int posInicialRecorrido = (n * TAM_LINEA)/2;

    private Path recorrido;
    private Pane root;
    //Siempre necesitamos tener el x e y anterior para poder dibujar un nuevo tramo
    private double x_anterior;
    private double y_anterior;


    public Dibujador(){
        //Group grupo = new Group(path); Ejemplos de google dicen que hay que agregar el recorrido a un objeto de tipo grupo pero no veo cambio alguno, lo dejo por las dudas
        this.recorrido = new Path();
        this.root = new Pane(this.recorrido);
        this.root.setPrefSize(n * TAM_LINEA, n * TAM_LINEA);
        BackgroundImage miBackground= new BackgroundImage(new Image("file:src/main/java/edu/fiuba/algo3/vista/Imagenes/fondo_dibujador.png",n * TAM_LINEA,n * TAM_LINEA,false,false),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        this.root.setBackground(new Background(miBackground));
        this.recorrido.setStrokeWidth(4.5);
        inicializarRecorrido();
        this.root.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
    }

    private void inicializarRecorrido(){
        //Inicializa el recorrido con un objeto MoveTo, desde aca se arma todo el recorrido
        this.recorrido.getElements().add(new MoveTo(posInicialRecorrido, posInicialRecorrido)); //Posicion inicial del recorrido
        x_anterior = posInicialRecorrido;
        y_anterior = posInicialRecorrido;
    }

    public void dibujarLineaAbajo(){
        if(y_anterior == n * TAM_LINEA){
            y_anterior = 0;
            this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior));
        }
        dibujarCirculo();
        this.recorrido.getElements().add(new LineTo(x_anterior, y_anterior + TAM_LINEA));
        actualizarXeYPrevios();
        dibujarCirculo();
    }
    public void dibujarLineaArriba(){
        if(y_anterior == 0){
            y_anterior = n * TAM_LINEA;
            this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior));
        }
        dibujarCirculo();
        this.recorrido.getElements().add(new LineTo(x_anterior, y_anterior - TAM_LINEA));
        actualizarXeYPrevios();
        dibujarCirculo();
    }
    public void dibujarLineaDerecha(){
        if(x_anterior == n * TAM_LINEA){
            x_anterior = 0;
            this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior));
        }
        dibujarCirculo();
        this.recorrido.getElements().add(new LineTo(x_anterior + TAM_LINEA, y_anterior));
        actualizarXeYPrevios();
        dibujarCirculo();
    }
    public void dibujarLineaIzquierda(){
        if(x_anterior == 0){
            x_anterior = n * TAM_LINEA;
            this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior));
        }
        dibujarCirculo();
        this.recorrido.getElements().add(new LineTo(x_anterior - TAM_LINEA, y_anterior));
        actualizarXeYPrevios();
        dibujarCirculo();
    }
    public void moverseAbajo(){
        this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior + TAM_LINEA));
        this.y_anterior = y_anterior + TAM_LINEA;
    }
    public void moverseArriba(){
        this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior - TAM_LINEA));
        this.y_anterior = y_anterior - TAM_LINEA;
    }
    public void moverseDerecha(){
        this.recorrido.getElements().add(new MoveTo(x_anterior + TAM_LINEA, y_anterior));
        this.x_anterior = x_anterior + TAM_LINEA;
    }
    public void moverseIzquierda(){
        this.recorrido.getElements().add(new MoveTo(x_anterior - TAM_LINEA, y_anterior));
        this.x_anterior = x_anterior - TAM_LINEA;
    }

    private void actualizarXeYPrevios(){
        LineTo lineaPrevia = (LineTo) this.recorrido.getElements().get(this.recorrido.getElements().size() - 1);
        x_anterior = lineaPrevia.getX();
        y_anterior = lineaPrevia.getY();
    }

    private void dibujarCirculo(){
        Circle circulo = new Circle(x_anterior, y_anterior, 4);
        circulo.setFill(Color.BLACK);
        this.root.getChildren().add(circulo);
    }

    public Pane getPane(){
        return root;
    }
}
