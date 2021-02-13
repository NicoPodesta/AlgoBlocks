package edu.fiuba.algo3.modelo;

public class BloqueInvertir extends ConjuntoBloques {

    @Override
    public void ejecutar(Personaje personaje) {
        super.ejecutarInvertido(personaje);
    }

    @Override
    public void ejecutarInvertido(Personaje personaje) {
        super.ejecutar(personaje);
    }
}