package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorGuardarAlgoritmo extends GridPane {

    ConjuntoBloques algoritmo;
    ArrayList<BloquePersonalizado> bloquePersonalizados;
    TextField texto;

    public ContenedorGuardarAlgoritmo(ConjuntoBloques algoritmo,
                                      ArrayList<BloquePersonalizado> bloquesPersonalizados, Stage stage) {
        this.algoritmo = algoritmo;
        this.bloquePersonalizados = bloquesPersonalizados;
        this.setHgap(10);
        this.setVgap(10);
        this.add(new Text("Agregar Nobre del Algoritmo"),0,0);
        this.texto = crearTextField();
        this.add(texto, 1,0);
        Button agregar = new Button("Agregar");
        //agregar handler del boton.
        this.add(agregar, 1, 1);
        this.setAlignment(Pos.CENTER);
    }

    private TextField crearTextField(){
        TextField texto = new TextField();
        texto.setPrefColumnCount(20);
        return texto;
    }

    public String nombreBloque(){
        return this.texto.getText();
    }
}