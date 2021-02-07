package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
//JOACO: MILPORCIENTO QUE ESTO VA A TERMINAR SIENDO UN TIPO DE ALGORITMO
public class BloqueRepetirN implements Bloque{
    private List<Bloque> listaBloques;
    private final int cantIteraciones;

    public BloqueRepetirN(int cantIteraciones) {
        this.cantIteraciones = cantIteraciones;
        this.listaBloques = new ArrayList<>();
    }

    public void agregarBloque(Bloque bloque){
        listaBloques.add(bloque);
    }
    public void removerBloque(Bloque bloque){
        listaBloques.remove(bloque);
    }

    @Override
    public void ejecutar(Personaje personaje) {
        for (int i = 0; i < cantIteraciones; i++) {
            for (Bloque unBloque : listaBloques) {
                unBloque.ejecutar(personaje);
            }
        }
    }
}
