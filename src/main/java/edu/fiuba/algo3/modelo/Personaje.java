package edu.fiuba.algo3.modelo;

import java.util.Vector;

public class Personaje {

    private final Posicion posicion;
    private Lapiz lapiz;

    public Personaje() {
        this.levantarLapiz();
        this.posicion = new Posicion(0,0);
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
        this.posicion.arriba();
    }

    public void moverHaciaAbajo() {
        this.posicion.abajo();
    }

    public void moverHaciaLaIzquierda() {
        this.posicion.izquierda();
    }

    public void moverHaciaLaDerecha() {
        this.posicion.derecha();
    }

    public Posicion posicionActual() {
        return posicion;
    }
}