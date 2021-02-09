package edu.fiuba.algo3.modelo;

import java.util.*;

public class Pizarra {

    private final HashSet<String> pizarra;

    @Override
    public boolean equals(Object unaPizarra) {
        if (this == unaPizarra) return true;
        HashSet<String> pizarraFinal = (HashSet<String>) unaPizarra;
        return pizarra.equals(pizarraFinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizarra);
    }

    public Pizarra() {
        pizarra = new HashSet<String>();
    }

    public void pintarPosicion(Posicion posicion){
        pizarra.add(posicion.ClaveString());
    }
}