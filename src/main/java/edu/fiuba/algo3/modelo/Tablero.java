package edu.fiuba.algo3.modelo;

public class Tablero {

    private Personaje personaje;
    //private final BloquesDisponibles = ListaDeBloques new;

    private ConjuntoBloques conjuntoBloques;

    public Tablero() {
        this.personaje = new Personaje();
        this.conjuntoBloques = new ConjuntoBloques();
    }

    /*Debemos pensar como solucionar la creacion de bloques, si los crea el tablero
    o si los crea el algoritmo, tal vez haya que usar algun patron creacional ?*/

    public void agregarBloqueAlAlgoritmo(Bloque unBloque) {
        conjuntoBloques.agregarBloque(unBloque);
    }

    public void ejecutarAlgoritmo(){
        conjuntoBloques.ejecutar(this.personaje);
    }

    public boolean compararPizarra(Pizarra pizarra){
        return personaje.contieneLaPizarra(pizarra);
    }
}