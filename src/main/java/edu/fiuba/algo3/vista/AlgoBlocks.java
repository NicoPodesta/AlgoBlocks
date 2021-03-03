package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AlgoBlocks extends Application{

    private VistaPersonaje vistaPersonaje;
    private VistaAlgoritmo vistaAlgoritmo;
    private ContenedorPrincipal contenedorPrincipal;

    @Override
    public void start(Stage stage) {
        stage.setTitle("AlgoBlocks");
        Personaje personaje = new Personaje();
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        ArrayList<BloquePersonalizado> bloquesPersonalizados = new ArrayList<>();
        Dibujador dibujador = new Dibujador();
        contenedorPrincipal = new ContenedorPrincipal(algoritmo, personaje, bloquesPersonalizados,
                dibujador);

        vistaPersonaje = new VistaPersonaje(dibujador, personaje);
        personaje.addObserver(vistaPersonaje);

        vistaAlgoritmo = new VistaAlgoritmo(algoritmo, contenedorPrincipal);
        algoritmo.addObserver(vistaAlgoritmo);

        Scene escenaPrincipal = new Scene(contenedorPrincipal, 1024, 668); //ver si esta bien pasar estos numeros
        stage.setScene(escenaPrincipal);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}