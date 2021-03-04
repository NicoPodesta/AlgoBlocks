package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Trazo {

    private Posicion posicionA;
    private Posicion posicionB;

    public Trazo(Posicion posicionA, Posicion posicionB) {
        this.posicionA = posicionA;
        this.posicionB = posicionB;
    }

    public Posicion getPosicionA() {
        return posicionA;
    }

    public Posicion getPosicionB() {
        return posicionB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trazo trazo = (Trazo) o;
        boolean posicionesIgualesMismoSentido = Objects.equals(posicionA, trazo.posicionA) &&
                Objects.equals(posicionB, trazo.posicionB);
        boolean posicionesIgualesDistintoSentido = Objects.equals(posicionA, trazo.posicionB) &&
                Objects.equals(posicionB, trazo.posicionA);
        return posicionesIgualesMismoSentido || posicionesIgualesDistintoSentido;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posicionA, posicionB);
    }

    public boolean estaDesfasado() {
        return (posicionA.getX() - posicionB.getX() == 0) || (posicionA.getY() - posicionB.getY() == 0);
    }
}