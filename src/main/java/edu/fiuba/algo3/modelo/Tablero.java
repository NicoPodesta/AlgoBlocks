package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Tablero {

    private ConjuntoBloques algoritmo;
    private HashMap<String, ConjuntoBloques> bloquesPersonalizados;
    private Personaje personaje;

    public Tablero() {
        this.algoritmo = new ConjuntoBloques();
        this.bloquesPersonalizados = new HashMap<>();
        this.personaje = new Personaje();
    }

    public void agregarBloqueAlAlgoritmo(Bloque unBloque) {
        algoritmo.agregarBloque(unBloque);
    }

    public Pizarra ejecutarAlgoritmo() {
        return algoritmo.ejecutar(personaje);
    }


    public void guardarBloquePersonalizado(String nombre, ConjuntoBloques algoritmo) throws Exception {
        if (algoritmo.estaVacio()) throw new Exception(); //crear excepcion personalizada
        bloquesPersonalizados.put(nombre, algoritmo);
    }

    /*public ConjuntoBloques obtenerBloquePersonalizado(String nombre) {
        return bloquesPersonalizados.get(nombre);
    }

    public Set<String> obtenerNombresBloquesPersonalizados() {
        return bloquesPersonalizados.keySet();
    }*/
}