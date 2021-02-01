package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Posicion {

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
        y = y - 1;
    }

    public void abajo() {
        y = y + 1;
    }

    public void izquierda() {
        x = x - 1;
    }

    public void derecha() {
        x = x + 1;
    }

    public int x() {
        return x ;
    }

    public int y() {
        return y ;
    }
}