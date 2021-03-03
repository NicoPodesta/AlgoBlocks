package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.Observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Pizarra  {

    private final HashSet<Trazo> trazosPintados;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizarra pizarra = (Pizarra) o;
        return pizarra.trazosPintados.equals(this.trazosPintados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trazosPintados);
    }

    public Pizarra() {
        trazosPintados = new HashSet<>();
    }

    public void pintarTrazo(Trazo trazo) {
        trazosPintados.add(trazo);
    }

    public HashSet<Trazo> obtenerTrazos(){
        return trazosPintados;
    }

}