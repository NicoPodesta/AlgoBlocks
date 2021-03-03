package edu.fiuba.algo3.vista;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Dibujador{
    private final int n = 10; //Numero de posibles segmentos
    private final int TAM_LINEA = 51; //Tamaño de cada linea

    int posInicialRecorrido = (n * TAM_LINEA)/2;

    public double x_anterior;
    public double y_anterior;

    public Path recorrido;
    public Pane root;

    ImageView playerImage;

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
        this.root.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));

        this.playerImage = new ImageView();
        this.playerImage.setScaleY(1.3);
        this.playerImage.setScaleX(1.3);
        this.playerImage.setFitHeight(64);
        this.playerImage.setFitWidth(64);
        this.playerImage.setX(this.x_anterior - 64);
        this.playerImage.setY(this.y_anterior - 32);
        this.playerImage.setImage(new Image("file:src/main/java/edu/fiuba/algo3/vista/Imagenes/playerTransparente.png"));

        this.x_anterior = posInicialRecorrido;
        this.y_anterior = posInicialRecorrido;
        inicializarRecorrido();
        actualizarugadorEnPantalla();
    }

    private void actualizarugadorEnPantalla(){
        this.playerImage.setX(this.x_anterior - 64);
        this.playerImage.setY(this.y_anterior - 28);
        this.root.getChildren().remove(playerImage);
        this.root.getChildren().add(playerImage);
    }

    private void inicializarRecorrido(){
        this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior)); //Posicion inicial del recorrido
    }

    public void dibujarArriba(){
        if(y_anterior == 0){
            y_anterior = n * TAM_LINEA;
            this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior));
        }
        dibujarCirculo();
        this.recorrido.getElements().add(new LineTo(x_anterior, y_anterior - TAM_LINEA));
        actualizarXeYPrevios();
        dibujarCirculo();
        actualizarugadorEnPantalla();
    }

    public void dibujarAbajo() {
        if(y_anterior == n * TAM_LINEA){
            y_anterior = 0;
            this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior));
        }
        dibujarCirculo();
        this.recorrido.getElements().add(new LineTo(x_anterior, y_anterior + TAM_LINEA));
        actualizarXeYPrevios();
        dibujarCirculo();
        actualizarugadorEnPantalla();
    }

    public void dibujarDerecha() {
        if(x_anterior == n * TAM_LINEA){
            x_anterior = 0;
            this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior));
        }
        dibujarCirculo();
        this.recorrido.getElements().add(new LineTo(x_anterior + TAM_LINEA, y_anterior));
        actualizarXeYPrevios();
        dibujarCirculo();
        actualizarugadorEnPantalla();
    }
    public void dibujarIzquierda() {
        if(x_anterior == 0){
            x_anterior = n * TAM_LINEA;
            this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior));
        }
        dibujarCirculo();
        this.recorrido.getElements().add(new LineTo(x_anterior - TAM_LINEA, y_anterior));
        actualizarXeYPrevios();
        dibujarCirculo();
        actualizarugadorEnPantalla();
    }

    public void moverArriba() {
        this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior - TAM_LINEA));
        this.y_anterior = y_anterior - TAM_LINEA;
        actualizarugadorEnPantalla();
    }

    public void moverAbajo() {
        this.recorrido.getElements().add(new MoveTo(x_anterior, y_anterior + TAM_LINEA));
        this.y_anterior = y_anterior + TAM_LINEA;
        actualizarugadorEnPantalla();
    }

    public void moverDerecha() {
        this.recorrido.getElements().add(new MoveTo(x_anterior + TAM_LINEA, y_anterior));
        this.x_anterior = x_anterior + TAM_LINEA;
        actualizarugadorEnPantalla();
    }

    public void moverIzquierda() {
        this.recorrido.getElements().add(new MoveTo(x_anterior - TAM_LINEA, y_anterior));
        this.x_anterior = x_anterior - TAM_LINEA;
        actualizarugadorEnPantalla();
    }


    public Pane getPane(){
        return this.root;
    }

    private void dibujarCirculo(){
        Circle circulo = new Circle(x_anterior, y_anterior, 4);
        circulo.setFill(Color.BLACK);
        this.root.getChildren().add(circulo);
    }

    public void actualizarXeYPrevios() {
        LineTo lineaPrevia = (LineTo) this.recorrido.getElements().get(this.recorrido.getElements().size() - 1);
        this.x_anterior = lineaPrevia.getX();
        this.y_anterior = lineaPrevia.getY();
    }
}
