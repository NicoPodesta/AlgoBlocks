package edu.fiuba.algo3.vista;

public class VistaPersonaje implements Observer{

    private Dibujador dibujador;

    public VistaPersonaje(Dibujador dibujador){
        this.dibujador = dibujador;
    }

    @Override
    public void update(String s) {
        switch (s){
            case "arriba": this.dibujador.moverseArriba();
            case "abajo": this.dibujador.moverseAbajo();
            case "derecha": this.dibujador.moverseDerecha();
            case "izquierda": this.dibujador.moverseIzquierda();
            case "apoyarLapiz": this.dibujador.apoyarLapiz();
            case "levantarLapiz": this.dibujador.levantarrLapiz();
        }
    }
}