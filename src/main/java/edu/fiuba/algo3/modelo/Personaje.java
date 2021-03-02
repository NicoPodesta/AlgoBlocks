package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.Observer;

import java.util.ArrayList;


public class Personaje implements Observable {

    private Lapiz lapiz;
    private Pizarra pizarra;
    private final Posicion posicion;
    private ArrayList<Observer> listaObserver;

    public Personaje() {
        listaObserver = new ArrayList<>();
        this.levantarLapiz();
        this.pizarra = new Pizarra();
        this.posicion = new Posicion(0,0);
    }

    public Pizarra levantarLapiz() {
        lapiz = new LapizLevantado();
        notifyObserver("levantarLapiz");
        return pizarra;
    }

    public Pizarra apoyarLapiz() {
        lapiz = new LapizApoyado();
        notifyObserver("apoyarLapiz");
        return actualizarPizarra();
    }

    public Pizarra moverHaciaArriba() {
        posicion.arriba();
        notifyObserver("arriba");
        return actualizarPizarra();
    }

    public Pizarra moverHaciaAbajo() {
        posicion.abajo();
        notifyObserver("abajo");
        return actualizarPizarra();
    }

    public Pizarra moverHaciaLaIzquierda() {
        posicion.izquierda();
        notifyObserver("izquierda");
        return actualizarPizarra();
    }

    public Pizarra moverHaciaLaDerecha() {
        posicion.derecha();
        notifyObserver("derecha");
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

    @Override
    public void addObserver(Observer observer) {
        listaObserver.add(observer);
    }

    @Override
    public void notifyObserver(String s) {
        listaObserver.stream().forEach(observer -> observer.update(s));
    }
}