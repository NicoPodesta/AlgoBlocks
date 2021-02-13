package edu.fiuba.algo3.modelo;

public class BloqueLapizApoyado implements Bloque {

    @Override
    public void ejecutar(Personaje personaje) {
        personaje.apoyarLapiz();
    }

    @Override
    public void ejecutarInvertido(Personaje personaje) {
        personaje.levantarLapiz();
    }
}