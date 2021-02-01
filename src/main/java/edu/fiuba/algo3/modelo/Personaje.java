package edu.fiuba.algo3.modelo;

import java.util.Vector;

public class Personaje {

    private final Posicion posicion;
    private Lapiz lapiz;

    public Personaje() {
        this.levantarLapiz();
        posicion = new Posicion(0,0);
    }

    public boolean estaPintando() { "Corregir"
        return lapiz.estaApoyado();
    }

    public void levantarLapiz(){
        lapiz = new LapizLevantado();
    }

    public void apoyarLapiz() {
        lapiz = new LapizApoyado();
    }

    public void moverHaciaArriba() {
        posicion.arriba();
    }

    public void moverHaciaAbajo() {
        posicion.abajo();
    }

    public void moverHaciaLaIzquierda() {
        posicion.izquierda();
    }

    public void moverHaciaLaDerecha() {
        posicion.derecha();
    }

    public Posicion posicionActual() {
        return posicion;
    }
}