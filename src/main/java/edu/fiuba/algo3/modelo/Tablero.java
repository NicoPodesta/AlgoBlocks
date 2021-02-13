package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Tablero {

    private ConjuntoBloques algoritmo;
    private ArrayList<BloquePersonalizado> bloquesPersonalizados;
    private Personaje personaje;

    public Tablero() {
        this.algoritmo = new ConjuntoBloques();
        this.bloquesPersonalizados = new ArrayList<>();
        this.personaje = new Personaje();
    }

    public void agregarBloqueAlAlgoritmo(Bloque unBloque) {
        algoritmo.agregarBloque(unBloque);
    }

    public void ejecutarAlgoritmo() {
        algoritmo.ejecutar(personaje);
    }

    public boolean compararPizarra(Pizarra pizarra) {
        return personaje.contieneLaPizarra(pizarra);
    }

    public void guardarBloquePersonalizado(String nombre, ConjuntoBloques algoritmo) throws Exception {
        BloquePersonalizado bloque = new BloquePersonalizado(nombre, algoritmo);
        bloquesPersonalizados.add(bloque);
    }
}