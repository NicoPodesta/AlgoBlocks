package edu.fiuba.algo3.modelo;

public class Tablero {

    private Personaje personaje;
    //private final BloquesDisponibles = ListaDeBloques new;
    private Algoritmo algoritmo;

    public Tablero() {
        this.personaje = new Personaje();
        this.algoritmo = new Algoritmo();
    }

    //"Debemos pensar como solucionar la creacion de bloques, si los crea el tablero o si los crea el algoritmo, tal vez haya que usar algun patron creacional ?"

    public void agregarBloqueAlAlgoritmo(Bloque unBloque) {
        algoritmo.agregarBloque(unBloque);
    }

    public void ejecutarAlgoritmo(){
        algoritmo.ejecutarAlgoritmo(this.personaje);
    }
    public Pizarra getPizarra(){
        return personaje.pizarra;
    }
}