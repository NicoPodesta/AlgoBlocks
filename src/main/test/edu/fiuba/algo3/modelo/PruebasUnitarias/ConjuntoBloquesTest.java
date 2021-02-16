package edu.fiuba.algo3.modelo.PruebasUnitarias;


import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConjuntoBloquesTest {

    @Test
    public void elAlgoritmoSeCreaCorrectamente(){
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        assertTrue(algoritmo.estaVacio());
    }

    @Test
    public void seAgreganVariosBloquesYSeEjecutan(){
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        algoritmo.agregarBloque(bloqueLapiz);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);

        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);
        pizarra.pintarPosicion(posicion);
        posicion.derecha();
        pizarra.pintarPosicion( posicion);
        posicion.abajo();
        pizarra.pintarPosicion( posicion );


        assertEquals(algoritmo.ejecutar(personaje),pizarra);
    }

    @Test
    public void seAgreganVariosBloquesLuegoSeRemuevenYSeEjecutan(){
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        BloqueArriba arriba = new BloqueArriba();
        Personaje personaje = new Personaje();

        algoritmo.agregarBloque(bloqueLapiz);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);
        algoritmo.agregarBloque(arriba);

        algoritmo.removerBloque(derecha);
        algoritmo.removerBloque(arriba);

        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);
        pizarra.pintarPosicion(posicion);
        posicion.abajo();
        pizarra.pintarPosicion( posicion );


        assertEquals(algoritmo.ejecutar(personaje),pizarra);
    }

    @Test
    public void seEjecutaInvertidoElAlgoritmo(){
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        algoritmo.agregarBloque(bloqueLapiz);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);


        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);

        assertEquals(algoritmo.ejecutarInvertido(personaje),pizarra);
    }


}