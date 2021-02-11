package edu.fiuba.algo3.modelo;

import java.util.HashSet;
import java.util.Objects;

public class Pizarra {

    private final HashSet<String> posicionesPintadas;

    @Override
    public boolean equals(Object unaPizarra) {
        if (this == unaPizarra) return true;
        HashSet<String> pizarraFinal = (HashSet<String>) unaPizarra;
        return posicionesPintadas.equals(pizarraFinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posicionesPintadas);
    }

    public Pizarra() {
        posicionesPintadas = new HashSet<>();
    }

    public void pintarPosicion(Posicion posicion){
        posicionesPintadas.add(posicion.ClaveString());
    }
}