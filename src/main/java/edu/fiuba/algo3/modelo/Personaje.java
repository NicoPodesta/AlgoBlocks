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

    public Pizarra levantarLapiz() {
        lapiz = new LapizLevantado();
        return pizarra;
    }

    public Pizarra apoyarLapiz() {
        lapiz = new LapizApoyado();
        return actualizarPizarra();
    }

    public Pizarra moverHaciaArriba() {
        posicion.arriba();
        return actualizarPizarra();
    }

    public Pizarra moverHaciaAbajo() {
        posicion.abajo();
        return actualizarPizarra();
    }

    public Pizarra moverHaciaLaIzquierda() {
        posicion.izquierda();
        return actualizarPizarra();
    }

    public Pizarra moverHaciaLaDerecha() {
        posicion.derecha();
        return actualizarPizarra();
    }

    private Pizarra actualizarPizarra() {
        lapiz.pintar(posicion, pizarra);
        return pizarra;
    }

    public Posicion posicionActual() {
        return posicion;
    }

    public Pizarra pizarraActual() {
        return pizarra;
    }

}