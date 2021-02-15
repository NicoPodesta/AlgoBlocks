package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ConjuntoBloques implements Bloque {

    protected ArrayList<Bloque> bloques;

    public ConjuntoBloques() {
        this.bloques = new ArrayList<>();
    }

    public void agregarBloque(Bloque bloque) {
        bloques.add(bloque);
    }

    public void removerBloque(Bloque bloque) {
        bloques.remove(bloque);
    }

    @Override
    public Pizarra ejecutar(Personaje personaje) {
        Pizarra pizarra = new Pizarra();
        for (Bloque unBloque : bloques) {
            pizarra = unBloque.ejecutar(personaje);
        }
        return pizarra;
    }

    @Override
    public Pizarra ejecutarInvertido(Personaje personaje) {
        Pizarra pizarra = new Pizarra();
        for (Bloque unBloque : bloques) {
             pizarra = unBloque.ejecutarInvertido(personaje);
        }
        return pizarra;
    }

    public boolean estaVacio() {
        return bloques.isEmpty();
    }
}