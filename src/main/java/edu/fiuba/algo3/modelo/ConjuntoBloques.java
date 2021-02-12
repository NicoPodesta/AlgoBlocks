package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ConjuntoBloques implements Bloque {

    protected ArrayList<Bloque> bloques;

    public ConjuntoBloques() {
        this.bloques = new ArrayList<>();
    }

    public void agregarBloque(Bloque bloque){
        bloques.add(bloque);
    }

    public void removerBloque(Bloque bloque){
        bloques.remove(bloque);
    }

    @Override
    public void ejecutar(Personaje personaje){
        for (Bloque unBloque : bloques) {
            unBloque.ejecutar(personaje);
        }
    }

    @Override
    public void ejecutarInvertido(Personaje personaje) {
        for (Bloque unBloque : bloques) {
            unBloque.ejecutarInvertido(personaje);
        }
    }
}