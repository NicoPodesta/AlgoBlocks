package edu.fiuba.algo3.modelo;

public class BloquePersonalizado extends ConjuntoBloques {

    private String nombre;

    public BloquePersonalizado(String nombre, ConjuntoBloques algoritmo) throws Exception {
        super();
        if (algoritmo.estaVacio()) throw new Exception(); //crear excepcion personalizada
        bloques = algoritmo.bloques;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}