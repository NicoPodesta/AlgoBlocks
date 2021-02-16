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


    public void guardarBloquePersonalizado(String nombre, ConjuntoBloques algoritmo) throws AlgoritmoVacioException {
        if (algoritmo.estaVacio()) {
            throw new AlgoritmoVacioException();
        }
        bloquesPersonalizados.put(nombre, algoritmo);
    }

    public ConjuntoBloques obtenerBloquePersonalizado(String nombre) throws BloqueInexistenteException {
        if (!bloquesPersonalizados.containsKey(nombre)) {
            throw new BloqueInexistenteException();
        }
        return bloquesPersonalizados.get(nombre);
    }

    public void removerBloquePersonalizado(String nombre) throws BloqueInexistenteException {
        if (bloquesPersonalizados.remove(nombre) == null){
            throw new BloqueInexistenteException();
        }
    }

    /*public Set<String> obtenerNombresBloquesPersonalizados() {
        return bloquesPersonalizados.keySet();
    }*/
}