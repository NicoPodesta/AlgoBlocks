package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AlgoBlocks extends Application{

    @Override
    public void start(Stage stage) {
        stage.setTitle("AlgoBlocks");
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        Personaje personaje = new Personaje();
        ArrayList<BloquePersonalizado> bloquesPersonalizados = new ArrayList<>();
        Dibujador dibujador = new Dibujador();
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(algoritmo, personaje, bloquesPersonalizados,
                dibujador);
        Scene escenaPrincipal = new Scene(contenedorPrincipal, 1024, 668); //ver si esta bien pasar estos numeros
        stage.setScene(escenaPrincipal);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}