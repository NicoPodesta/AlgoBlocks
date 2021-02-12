package edu.fiuba.algo3.modelo;

public class LapizApoyado implements Lapiz {

    public void pintarPizarra(Posicion posicion, Pizarra pizarra){
        pizarra.pintarPosicion(posicion);
    }
}