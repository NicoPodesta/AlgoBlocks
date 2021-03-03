package edu.fiuba.algo3.vista;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ContenedorAlgoritmo extends VBox {

    public ContenedorAlgoritmo(){
        super(new Label("Algoritmo Actual"));
    }

    public void agregar(Button button){
        this.getChildren().add(button);
    }

    public void removerUltimo(){
        if(this.getChildren().size() > 1){
            this.getChildren().remove(this.getChildren().size()-1);
        }
    }
}