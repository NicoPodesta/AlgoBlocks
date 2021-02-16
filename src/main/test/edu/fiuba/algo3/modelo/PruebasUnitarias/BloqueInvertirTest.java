package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloqueInvertirTest {

    @Test
    public void elBloqueInvertirSeCreaCorrectamente(){
        BloqueInvertir invertir = new BloqueInvertir();
        assertTrue(invertir.estaVacio());
    }

    @Test
    public void seAgreganVariosBloquesYSeEjecutan(){
        BloqueInvertir invertir = new BloqueInvertir();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        bloqueLapiz.ejecutar(personaje);
        invertir.agregarBloque(derecha);
        invertir.agregarBloque(abajo);

        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);
        pizarra.pintarPosicion(posicion);
        posicion.izquierda();
        pizarra.pintarPosicion( posicion);
        posicion.arriba();
        pizarra.pintarPosicion( posicion );


        assertEquals(invertir.ejecutar(personaje),pizarra);
    }

    @Test
    public void seEjecutaInvertidoElBloqueInvertir(){
        BloqueInvertir invertir = new BloqueInvertir();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        invertir.agregarBloque(bloqueLapiz);
        invertir.agregarBloque(derecha);
        invertir.agregarBloque(abajo);


        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);
        pizarra.pintarPosicion(posicion);
        posicion.derecha();
        pizarra.pintarPosicion( posicion);
        posicion.abajo();
        pizarra.pintarPosicion( posicion );

        assertEquals(invertir.ejecutarInvertido(personaje),pizarra);
    }

    @Test
    public void seAnidanBloquesInvertirYSeCancelan(){
        BloqueInvertir invertirA = new BloqueInvertir();
        BloqueInvertir invertirB = new BloqueInvertir();
        BloqueLapizLevantado bloqueLapiz = new BloqueLapizLevantado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        invertirA.agregarBloque(bloqueLapiz);
        invertirB.agregarBloque(derecha);
        invertirB.agregarBloque(abajo);
        invertirA.agregarBloque(invertirB);


        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);
        pizarra.pintarPosicion(posicion);
        posicion.derecha();
        pizarra.pintarPosicion( posicion );
        posicion.abajo();
        pizarra.pintarPosicion( posicion );

        assertEquals(invertirA.ejecutar(personaje),pizarra);
    }

}