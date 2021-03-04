package edu.fiuba.algo3.modelo;

public class BloquePersonalizado extends ConjuntoBloques {

    private String nombre;

    public BloquePersonalizado(String nombre, ConjuntoBloques algoritmo) {
        super();
        bloques = algoritmo.bloques;
        this.nombre = nombre;
    }

    @Override
    public String obtenerNombre() {
        return nombre;
    }
}