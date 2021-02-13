package edu.fiuba.algo3.modelo;
// Analizar si es necesaria esta clase
public class BloquePersonalizado extends ConjuntoBloques {

    private String nombre;

    public BloquePersonalizado(String nombre, ConjuntoBloques algoritmo) throws Exception {
        super();
        bloques = algoritmo.bloques;
        this.nombre = nombre;
    }

    public String obtenerNombre() {
        return nombre;
    }
}