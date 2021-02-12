package edu.fiuba.algo3.modelo;

public class Personaje {

    private Lapiz lapiz;
    private Pizarra pizarra;
    private final Posicion posicion;

    public Personaje() {
        this.levantarLapiz();
        this.pizarra = new Pizarra();
        this.posicion = new Posicion(0,0);
    }

    public void levantarLapiz() {
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

    private void actualizarPizarra() {
        lapiz.pintarPizarra(posicion, pizarra);
    }

    public Posicion posicionActual() {
        return posicion;
    }

    public boolean contieneLaPizarra(Pizarra pizarra) {
        return this.pizarra.equals(pizarra);
    }
}