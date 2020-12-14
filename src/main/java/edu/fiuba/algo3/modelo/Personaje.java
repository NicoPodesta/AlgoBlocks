package edu.fiuba.algo3.modelo;

public class Personaje {

    private Lapiz lapiz;

    public Personaje() {
        this.levantarLapiz();
    }

    public boolean estaPintando() {
        return lapiz.estaApoyado();
    }

    public void levantarLapiz(){
        lapiz = new LapizLevantado();
    }

    public void apoyarLapiz() {
        lapiz = new LapizApoyado();
    }
}