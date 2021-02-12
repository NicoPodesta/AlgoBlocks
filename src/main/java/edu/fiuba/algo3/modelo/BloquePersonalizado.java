package edu.fiuba.algo3.modelo;

public class BloquePersonalizado extends ConjuntoBloques {

    private String nombre;

    public BloquePersonalizado(String nombre) {
        super();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}