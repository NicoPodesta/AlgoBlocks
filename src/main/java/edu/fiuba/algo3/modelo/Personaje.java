package edu.fiuba.algo3.modelo;

public class Personaje {

    private Lapiz lapiz;

    public Personaje() {
        lapiz = new LapizLevantado();
    }

    public boolean estaPintando() {
        return lapiz.estaLevantado();
    }
}