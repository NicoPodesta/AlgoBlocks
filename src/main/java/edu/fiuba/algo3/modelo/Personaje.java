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
        return pizarra;
    }

    public Pizarra moverHaciaArriba() {
        Posicion posicionAnterior = new Posicion(posicion);
        posicion.arriba();
        notifyObserver("arriba");
        return actualizarPizarra(new Trazo(posicionAnterior, new Posicion(posicion)));
    }

    public Pizarra moverHaciaAbajo() {
        Posicion posicionAnterior = new Posicion(posicion);
        posicion.abajo();
        notifyObserver("abajo");
        return actualizarPizarra(new Trazo(posicionAnterior, new Posicion(posicion)));
    }

    public Pizarra moverHaciaLaIzquierda() {
        Posicion posicionAnterior = new Posicion(posicion);
        posicion.izquierda();
        notifyObserver("izquierda");
        return actualizarPizarra(new Trazo(posicionAnterior, new Posicion(posicion)));
    }

    public Pizarra moverHaciaLaDerecha() {
        Posicion posicionAnterior = new Posicion(posicion);
        posicion.derecha();
        notifyObserver("derecha");
        return actualizarPizarra(new Trazo(posicionAnterior, new Posicion(posicion)));
    }

    private Pizarra actualizarPizarra(Trazo trazo) {
        lapiz.pintar(trazo, pizarra);
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