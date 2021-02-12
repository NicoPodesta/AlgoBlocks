package edu.fiuba.algo3.modelo;

import java.util.HashSet;
import java.util.Objects;

public class Pizarra {

    private final HashSet<String> posicionesPintadas;

    @Override
    public boolean equals(Object unaPizarra) {
        Pizarra o = (Pizarra) unaPizarra;
        return o.posicionesPintadas.equals(this.posicionesPintadas);
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