package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Trazo {

    private Posicion posicionA;
    private Posicion posicionB;

    public Trazo(Posicion posicionA, Posicion posicionB) {
        this.posicionA = posicionA;
        this.posicionB = posicionB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trazo trazo = (Trazo) o;
        return (Objects.equals(posicionA, trazo.posicionA) && Objects.equals(posicionB, trazo.posicionB))
                || (Objects.equals(posicionA, trazo.posicionB) && Objects.equals(posicionB, trazo.posicionA));
    }

    @Override
    public int hashCode() {
        return Objects.hash(posicionA, posicionB);
    }
}