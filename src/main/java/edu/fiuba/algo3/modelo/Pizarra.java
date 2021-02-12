package edu.fiuba.algo3.modelo;

import java.util.HashSet;
import java.util.Objects;

public class Pizarra {

    private final HashSet<Posicion> posicionesPintadas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizarra pizarra = (Pizarra) o;
        return pizarra.posicionesPintadas.equals(this.posicionesPintadas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posicionesPintadas);
    }

    public Pizarra() {
        posicionesPintadas = new HashSet<>();
    }

    public void pintarPosicion(Posicion posicion) {
        posicionesPintadas.add(posicion);
    }
}