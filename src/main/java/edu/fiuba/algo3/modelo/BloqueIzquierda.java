package edu.fiuba.algo3.modelo;

public class BloqueIzquierda implements Bloque {

    @Override
    public void ejecutar(Personaje personaje) {
        personaje.moverHaciaLaIzquierda();
    }

    @Override
    public void ejecutarInvertido(Personaje personaje) {
        personaje.moverHaciaLaDerecha();
    }
}