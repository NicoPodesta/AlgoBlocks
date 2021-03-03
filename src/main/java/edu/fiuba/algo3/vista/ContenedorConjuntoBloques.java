package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ContenedorConjuntoBloques extends BorderPane {

    final private ConjuntoBloques algoritmo;
    final private ContenedorBotones contenedor;
    private ContenedorAlgoritmo contenedorAlgoritmos;

    public ContenedorConjuntoBloques(ConjuntoBloques algoritmo, ConjuntoBloques conjunto){
        this.algoritmo = algoritmo;
        this.contenedor = new ContenedorBotones();
        this.contenedorAlgoritmos = new ContenedorAlgoritmo();
        this.agregarBotones(this.contenedor.crearContenedorBotones(algoritmo)); //ver para los dos de setear el tamaño correcto
        this.agregarAlgoritmo(contenedorAlgoritmos);
    }

    private void agregarBotones(VBox contenedorBotones){
        contenedorBotones.setPrefWidth(256);
        contenedorBotones.setSpacing(10);
        contenedorBotones.setPadding(new Insets(15 , 0,0,60));
        contenedorBotones.setStyle("-fx-border-color: black;-fx-border-width: 2;");

        this.setLeft(contenedorBotones);
    }

    private void agregarAlgoritmo(VBox contenedorAlgoritmo){

        contenedorAlgoritmo.setPrefWidth(256);
        contenedorAlgoritmo.setSpacing(10);
        contenedorAlgoritmo.setPadding(new Insets(15 , 0,0,85));
        contenedorAlgoritmo.setStyle("-fx-border-color: black;-fx-border-width: 2 1");

        this.setCenter(contenedorAlgoritmo);
    }

    public void agregarNombreBloque(Bloque bloque){
        this.contenedorAlgoritmos.agregar(new Button(bloque.obtenerNombre()));
    }

    public void eliminarUltimoNombreBloque(){
        this.contenedorAlgoritmos.removerUltimo();
    }
}
