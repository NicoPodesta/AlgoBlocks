package edu.fiuba.algo3.modelo;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Objects;

public class Pizarra {

    private final Dictionary<String, Posicion> pizarra;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dictionary<String, Posicion> pizarra1 = (Hashtable<String, Posicion>) o;
        return pizarra.equals(pizarra1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizarra);
    }

    public Pizarra() {
        pizarra = new Hashtable<String, Posicion>();
    }

    public void pintarPosicion(Posicion posicion){
        pizarra.put(posicion.ClaveString(), posicion);
    }
}