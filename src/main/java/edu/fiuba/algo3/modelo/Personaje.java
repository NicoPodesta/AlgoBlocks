package edu.fiuba.algo3.modelo;

import java.util.HashSet;

public class Personaje {

    private final Posicion posicion;
    private Lapiz lapiz;
    public Pizarra pizarra;

    public Personaje() {
        this.levantarLapiz();
        this.posicion = new Posicion(0,0);
        this.pizarra = new Pizarra();
    }

    public boolean estaPintando() { //"Corregir"
        return lapiz.estaApoyado();
    }

    public void levantarLapiz(){
        lapiz = new LapizLevantado();
    }

    public void apoyarLapiz() {
        lapiz = new LapizApoyado();
        lapiz.pintarPizarra(posicion, pizarra);
    }

    public void moverHaciaArriba() {
        posicion.arriba();
        actualizarPizarra();
    }

    public void moverHaciaAbajo() {
        posicion.abajo();
        actualizarPizarra();
    }

    public void moverHaciaLaIzquierda() {
        posicion.izquierda();
        actualizarPizarra();
    }

    public void moverHaciaLaDerecha() {
        posicion.derecha();
        actualizarPizarra();
    }

    public void actualizarPizarra(){
        lapiz.pintarPizarra(posicion, pizarra);
    }

    public Posicion posicionActual() {
        return posicion;
    }

    public boolean compararLaPizarra(HashSet<String> pizarra1){
        return pizarra.equals(pizarra1);
    }
}