package edu.fiuba.algo3.modelo;

import java.util.Vector;

public class Personaje {

    private Lapiz lapiz;
    private int posicionX;
    private int posicionY;

    public Personaje() {
        this.levantarLapiz();
        posicionX = 0;
        posicionY = 0;
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

    public void moverHaciaArriba() {
        posicionY = posicionY - 1;
    }

    public void moverHaciaAbajo() {
        posicionY = posicionY + 1;
    }

    public void moverHaciaLaIzquierda() {
        posicionX = posicionX - 1;
    }

    public void moverHaciaLaDerecha() {
        posicionX = posicionX + 1;
    }

    public Vector<Integer> posicionActual() {
        Vector<Integer> posicion = new Vector<>();
        posicion.add(posicionX);
        posicion.add(posicionY);
        return posicion;
    }
}