package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Personaje;

public class VistaPersonaje implements Observer {

    private Dibujador dibujador;
    private Personaje personaje;

    private int xAnterior;
    private int yAnterior;

    public VistaPersonaje(Dibujador dibujador, Personaje personaje){
        this.dibujador = dibujador;
        this.personaje = personaje;
        this.xAnterior = this.personaje.getX();
        this.yAnterior = this.personaje.getY();
    }

    @Override
    public void update() {
        int xActual = this.personaje.getX();
        int yActual = this.personaje.getY();
        if(yActual > yAnterior){
            this.dibujador.moverAbajo();
        }
        else if (yActual < yAnterior){
            this.dibujador.moverArriba();
        }
        else if (xActual > xAnterior){
            this.dibujador.moverDerecha();
        }
        else if (xActual < xAnterior){
            this.dibujador.moverIzquierda();
        }
        this.xAnterior = xActual;
        this.yAnterior = yActual;
    }
}