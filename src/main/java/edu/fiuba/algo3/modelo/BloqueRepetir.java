package edu.fiuba.algo3.modelo;

public class BloqueRepetir extends ConjuntoBloques {

    private final int cantIteraciones;

    public BloqueRepetir(int cantIteraciones) {
        super();
        this.cantIteraciones = cantIteraciones;
    }

    @Override
    public void ejecutar(Personaje personaje) {
        for (int i = 0; i < cantIteraciones; i++) {
            super.ejecutar(personaje);
        }
    }

    @Override
    public void ejecutarInvertido(Personaje personaje) {
        for (int i = 0; i < cantIteraciones; i++) {
            super.ejecutarInvertido(personaje);
        }
    }
}