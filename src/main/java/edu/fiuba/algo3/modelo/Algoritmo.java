package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Algoritmo{

    private List<Bloque> listaBloques;

    public Algoritmo() {
        this.listaBloques = new ArrayList<>();
    }

    public void agregarBloque(Bloque bloque){
        listaBloques.add(bloque);
    }
    public void removerBloque(Bloque bloque){
        listaBloques.remove(bloque);
    }

    public void ejecutarAlgoritmo(Personaje personaje){
        for (Bloque unBloque : listaBloques) {
            unBloque.ejecutar(personaje);
        }
    }
}
