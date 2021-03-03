package edu.fiuba.algo3.vista;

public class VistaPersonaje implements Observer {

    private Dibujador dibujador;

    public VistaPersonaje(Dibujador dibujador){
        this.dibujador = dibujador;
    }

    @Override
    public void update() {
    }
}