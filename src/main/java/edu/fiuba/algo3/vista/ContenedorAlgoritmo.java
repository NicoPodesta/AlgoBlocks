package edu.fiuba.algo3.vista;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ContenedorAlgoritmo {

    private VBox contenedor;

    public ContenedorAlgoritmo(){
        this.contenedor = new VBox(new Label("Algoritmo Actual"));
    }

    public VBox obtenerContenedor(){
        return contenedor;
    }

    public void agregar(Button button){
        this.contenedor.getChildren().add(button);
    }

    public void removerUltimo(){
        if(this.contenedor.getChildren().size() > 1){
            this.contenedor.getChildren().remove(this.contenedor.getChildren().size()-1);
        }
    }
}
