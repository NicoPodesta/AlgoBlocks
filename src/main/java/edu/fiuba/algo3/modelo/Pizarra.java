package edu.fiuba.algo3.modelo;

import java.util.*;

public class Pizarra {

    private final HashSet<String> pizarra;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        HashSet<String> pizarra1 = (HashSet<String>) o;
        return pizarra.equals(pizarra1);
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