package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BloqueInvertirTest {

    @Test
    public void elBloqueInvertirSeCreaCorrectamente() {
        BloqueInvertir invertir = new BloqueInvertir();
        assertTrue(invertir.estaVacio());
    }

    @Test
    public void seAgreganVariosBloquesYSeEjecutan() {
        BloqueInvertir invertir = new BloqueInvertir();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        bloqueLapiz.ejecutar(personaje);
        invertir.agregarBloque(derecha);
        invertir.agregarBloque(abajo);

        Pizarra pizarra = new Pizarra();
        Trazo trazo1 = new Trazo( new Posicion(0,0),  new Posicion(-1,0));
        Trazo trazo2 = new Trazo( new Posicion(-1,0),  new Posicion(-1,-1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);


        assertEquals(invertir.ejecutar(personaje), pizarra);
    }

    @Test
    public void seEjecutaInvertidoElBloqueInvertir() {
        BloqueInvertir invertir = new BloqueInvertir();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        invertir.agregarBloque(bloqueLapiz);
        invertir.agregarBloque(derecha);
        invertir.agregarBloque(abajo);


        Pizarra pizarra = new Pizarra();
        Trazo trazo1 = new Trazo( new Posicion(0,0),  new Posicion(1,0));
        Trazo trazo2 = new Trazo( new Posicion(1,0),  new Posicion(1,1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);

        assertEquals(invertir.ejecutarInvertido(personaje), pizarra);
    }

    @Test
    public void seAnidanBloquesInvertirYSeCancelan() {
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
        Trazo trazo1 = new Trazo( new Posicion(0,0),  new Posicion(1,0));
        Trazo trazo2 = new Trazo( new Posicion(1,0),  new Posicion(1,1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);

        assertEquals(invertirA.ejecutar(personaje), pizarra);
    }

    @Test
    public void elNombreDelBloqueEsElCorrecto() {
        BloqueInvertir bloque = new BloqueInvertir();
        assertEquals(bloque.obtenerNombre(), "Invertir Comportamiento");
    }

    @Test
    public void elUltimoBloqueSeRemueveCorrectamente() {
        BloqueInvertir invertir = new BloqueInvertir();
        BloqueLapizLevantado bloqueLapiz = new BloqueLapizLevantado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        BloqueArriba arriba = new BloqueArriba();
        Personaje personaje = new Personaje();

        invertir.agregarBloque(bloqueLapiz);
        invertir.agregarBloque(derecha);
        invertir.agregarBloque(abajo);
        invertir.agregarBloque(arriba);
        invertir.removerUltimoBloque();
        invertir.removerUltimoBloque();

        Pizarra pizarra = new Pizarra();
        Trazo trazo = new Trazo( new Posicion(0,0),  new Posicion(-1,0));
        pizarra.pintarTrazo(trazo);

        assertEquals(invertir.ejecutar(personaje), pizarra);
    }

    @Test
    public void quitarUltimoBloqueABloqueVacioNoHaceNada() {
        BloqueInvertir invertir = new BloqueInvertir();
        invertir.removerUltimoBloque();
        assertTrue(invertir.estaVacio());
    }

    @Test
    public void seAgregaYsequitaUltimoAlgoritmoQuedaVacio() {
        BloqueInvertir invertir = new BloqueInvertir();
        BloqueDerecha derecha = new BloqueDerecha();
        invertir.agregarBloque(derecha);
        invertir.removerUltimoBloque();
        assertTrue(invertir.estaVacio());
    }

    @Test
    public void seRemueveBloqueInexistenteYSeLanzaExcepcionCorrecta() {
        try {
            BloqueInvertir invertir = new BloqueInvertir();
            BloqueDerecha derecha = new BloqueDerecha();
            invertir.removerBloque(derecha);
        }
        catch (BloqueInexistenteException expected){ }
    }

}