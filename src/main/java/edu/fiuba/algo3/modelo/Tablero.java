package edu.fiuba.algo3.modelo;

public class Tablero {

    private ConjuntoBloques algoritmoCompleto;
    //private ConjuntoBloques bloquesDisponibles;
    private Personaje personaje;

    public Tablero() {
        this.algoritmoCompleto = new ConjuntoBloques();
        //this.bloquesDisponibles = new ConjuntoBloques();
        this.personaje = new Personaje();
    }

    /*Debemos pensar como solucionar la creacion de bloques, si los crea el tablero
    o si los crea el algoritmo, tal vez haya que usar algun patron creacional ?*/

    public void agregarBloqueAlAlgoritmo(Bloque unBloque) {
        algoritmoCompleto.agregarBloque(unBloque);
    }

    public void ejecutarAlgoritmo() {
        algoritmoCompleto.ejecutar(this.personaje);
    }

    public boolean compararPizarra(Pizarra pizarra) {
        return personaje.contieneLaPizarra(pizarra);
    }
}