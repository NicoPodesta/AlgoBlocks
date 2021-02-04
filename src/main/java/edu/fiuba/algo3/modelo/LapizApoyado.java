package edu.fiuba.algo3.modelo;

public class LapizApoyado implements Lapiz {

    @Override
    public boolean estaApoyado() {
        return true;
    }
    public void pintarPizarra(Posicion posicion, Pizarra pizarra){
        //pizarra.actualizarPosicionPersonaje(posicion);
        pizarra.pintarPosicion(posicion);
    }
}