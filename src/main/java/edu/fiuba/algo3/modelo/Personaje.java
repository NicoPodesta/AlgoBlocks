package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.Observer;
import edu.fiuba.algo3.vista.VistaPersonaje;
import edu.fiuba.algo3.vista.VistaPizarra;

import java.util.ArrayList;

public class Personaje {

    private Lapiz lapiz;
    private Pizarra pizarra;
    private final Posicion posicion;
    private Posicion posicionAnterior;

    private LapizApoyado lapizApoyado;
    private LapizLevantado lapizLevantado;

    public Personaje() {
        this.lapizApoyado = new LapizApoyado();
        this.lapizLevantado = new LapizLevantado();

        this.levantarLapiz();
        this.pizarra = new Pizarra();
        this.posicion = new Posicion(0,0);
    }

    public Pizarra levantarLapiz() {
        lapiz = this.lapizLevantado;
        return pizarra;
    }

    public Pizarra apoyarLapiz() {
        lapiz = this.lapizApoyado;
        return pizarra;
    }

    public Pizarra moverHaciaArriba() {
        this.posicionAnterior = new Posicion(posicion);
        posicion.arriba();
        return actualizarPizarra(new Trazo(posicionAnterior, new Posicion(posicion)));
    }

    public Pizarra moverHaciaAbajo() {
        this.posicionAnterior = new Posicion(posicion);
        posicion.abajo();
        return actualizarPizarra(new Trazo(posicionAnterior, new Posicion(posicion)));
    }

    public Pizarra moverHaciaLaIzquierda() {
        this.posicionAnterior = new Posicion(posicion);
        posicion.izquierda();
        return actualizarPizarra(new Trazo(posicionAnterior, new Posicion(posicion)));
    }

    public Pizarra moverHaciaLaDerecha() {
        this.posicionAnterior = new Posicion(posicion);
        posicion.derecha();
        return actualizarPizarra(new Trazo(posicionAnterior, new Posicion(posicion)));
    }

    private Pizarra actualizarPizarra(Trazo trazo) {
        lapiz.pintar(trazo, pizarra);
        return pizarra;
    }

    public Pizarra obtenerPizarra(){
        return pizarra;
    }

    public Posicion posicionActual() {
        return posicion;
    }

    public int getX(){return this.posicion.getX();}
    public int getY(){return this.posicion.getY();}

    public void agregarObserver(VistaPersonaje vistaPersonaje, VistaPizarra vistaPizarra) {
        this.lapizLevantado.addObserver(vistaPersonaje);
        this.lapizApoyado.addObserver(vistaPizarra);
    }
}