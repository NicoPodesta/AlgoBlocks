package edu.fiuba.algo3.vista;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

public class Dibujador {
    private final int n = 10; //Numero de posibles segmentos
    private final int TAM_LINEA = 51; //Tamaño de cada linea

    int posInicialRecorrido = (n * TAM_LINEA)/2;

    public double x_anterior;
    public double y_anterior;

    public Path recorrido;
    public Pane root;

    private VistaLapiz vistaLapiz;
    private VistaLapizLevantado vistaLapizLevantado;
    private VistaLapizApoyado vistaLapizApoyado;

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

        this.x_anterior = posInicialRecorrido;
        this.y_anterior = posInicialRecorrido;

        this.vistaLapizLevantado = new VistaLapizLevantado(this.recorrido, this.root, this.x_anterior, this.y_anterior);
        this.vistaLapizApoyado = new VistaLapizApoyado(this.recorrido, this.root, this.x_anterior, this.y_anterior);

        //Se setea como vista inicial la vista lapiz levantado
        this.vistaLapiz = this.vistaLapizApoyado;
    }

    public void moverseArriba(){
        this.vistaLapiz.dibujarArriba();
    }

    public void moverseAbajo(){
        this.vistaLapiz.dibujarAbajo();
    }

    public void moverseDerecha(){
        this.vistaLapiz.dibujarDerecha();
    }

    public void moverseIzquierda(){
        this.vistaLapiz.dibujarIzquierda();
    }

    public void apoyarLapiz(){
        this.vistaLapiz = this.vistaLapizApoyado;
    }

    public void levantarrLapiz(){
        this.vistaLapiz = this.vistaLapizLevantado;
    }

    public Pane getPane(){
        return this.root;
    }
}
