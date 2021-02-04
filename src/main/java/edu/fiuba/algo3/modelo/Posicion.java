package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Posicion {

    private static final int LARGO = 5;
    private int x;
    private int y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return x == posicion.x && y == posicion.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public void arriba() {
        if(y - 1 < 0){
            y = LARGO - 1;
        }else {
            y = y - 1;
        }
    }

    public void abajo() {
        if(y + 1 > LARGO - 1){
            y = 0;
        }else {
            y = y + 1;
        }
    }

    public void izquierda() {
        if(x - 1 < 0){
            x = LARGO - 1;
        }else {
            x = x - 1;
        }
    }

    public void derecha() {

        if( x + 1 > LARGO - 1){
            x = 0;
        }else {
            x = x + 1;
        }
    }

    public int x() {
        return x ;
    }

    public int y() {
        return y ;
    }
    public int dimension(){
        return LARGO;
    }
}