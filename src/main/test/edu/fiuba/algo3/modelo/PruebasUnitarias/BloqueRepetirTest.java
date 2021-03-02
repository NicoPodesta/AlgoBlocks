package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloqueRepetirTest {

    @Test
    public void elBloqueRepetirSeCreaCorrectamente() {
        BloqueRepetir repeticion = new BloqueRepetir(2);
        assertTrue(repeticion.estaVacio());
    }

    @Test
    public void seAgreganVariosBloquesYSeRepiten2Veces() {
        BloqueRepetir repeticion = new BloqueRepetir(2);
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();
        bloqueLapiz.ejecutar(personaje);
        repeticion.agregarBloque(derecha);
        repeticion.agregarBloque(abajo);

        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);
        pizarra.pintarPosicion(posicion);
        for (int i = 0; i < 2; ++i){
            posicion.derecha();
            pizarra.pintarPosicion(posicion);
            posicion.abajo();
            pizarra.pintarPosicion(posicion);
        }

        assertEquals(repeticion.ejecutar(personaje),pizarra);
    }

    @Test
    public void seAgreganVariosBloquesYSeRemueven() {
        BloqueRepetir repeticion = new BloqueRepetir(3);
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        BloqueArriba arriba = new BloqueArriba();
        Personaje personaje = new Personaje();
        bloqueLapiz.ejecutar(personaje);
        repeticion.agregarBloque(derecha);
        repeticion.agregarBloque(abajo);
        repeticion.agregarBloque(arriba);
        try {
            repeticion.removerBloque(derecha);
        } catch (BloqueInexistenteException e) {
            fail();
        }
        try {
            repeticion.removerBloque(arriba);
        } catch (BloqueInexistenteException e) {
            fail();
        }

        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);
        pizarra.pintarPosicion(posicion);
        for (int i = 0; i < 3; ++i) {
            posicion.abajo();
            pizarra.pintarPosicion(posicion);
        }

        assertEquals(repeticion.ejecutar(personaje), pizarra);
    }

    @Test
    public void ejecutarInvertidoInvierteLosBloquesEItera() {
        BloqueRepetir repeticion = new BloqueRepetir(2);
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();
        bloqueLapiz.ejecutar(personaje);
        repeticion.agregarBloque(derecha);
        repeticion.agregarBloque(abajo);

        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);
        pizarra.pintarPosicion(posicion);
        for (int i = 0; i < 2; ++i) {
            posicion.izquierda();
            pizarra.pintarPosicion( posicion);
            posicion.arriba();
            pizarra.pintarPosicion(posicion);
        }

        assertEquals(repeticion.ejecutarInvertido(personaje), pizarra);
    }

    @Test
    public void seAnidanDosBloquesDeRepeticion() {
        BloqueRepetir repeticionI = new BloqueRepetir(2);
        BloqueRepetir repeticionJ = new BloqueRepetir(3);
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();
        bloqueLapiz.ejecutar(personaje);
        repeticionI.agregarBloque(derecha);
        repeticionJ.agregarBloque(abajo);
        repeticionI.agregarBloque(repeticionJ);

        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);
        pizarra.pintarPosicion(posicion);
        for (int i = 0; i < 2; ++i) {
            posicion.derecha();
            pizarra.pintarPosicion(posicion);
            for (int j = 0; j < 3; ++j) {
                posicion.abajo();
                pizarra.pintarPosicion(posicion);
            }
        }

        assertEquals(repeticionI.ejecutar(personaje), pizarra);
    }

    @Test
    public void elNombreDelBloqueEsElCorrecto() {
        BloqueRepetir bloque = new BloqueRepetir(3);
        assertEquals(bloque.obtenerNombre(), "RepetirX3");
    }

    @Test
    public void elUltimoBloqueSeRemueveCorrectamente() {
        BloqueRepetir repeticion = new BloqueRepetir(3);
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        BloqueArriba arriba = new BloqueArriba();
        Personaje personaje = new Personaje();
        bloqueLapiz.ejecutar(personaje);
        repeticion.agregarBloque(derecha);
        repeticion.agregarBloque(abajo);
        repeticion.agregarBloque(arriba);
        repeticion.removerUltimoBloque();
        repeticion.removerUltimoBloque();

        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);
        pizarra.pintarPosicion(posicion);
        for (int i = 0; i < 3; ++i) {
            posicion.derecha();
            pizarra.pintarPosicion(posicion);
        }

        assertEquals(repeticion.ejecutar(personaje), pizarra);
    }

    @Test
    public void quitarUltimoBloqueABloqueVacioNoHaceNada() {
        BloqueRepetir repeticion = new BloqueRepetir(3);
        repeticion.removerUltimoBloque();
        assertTrue(repeticion.estaVacio());
    }

    @Test
    public void seAgregaYsequitaUltimoAlgoritmoQuedaVacio() {
        BloqueRepetir repeticion = new BloqueRepetir(3);
        BloqueDerecha derecha = new BloqueDerecha();
        repeticion.agregarBloque(derecha);
        repeticion.removerUltimoBloque();
        assertTrue(repeticion.estaVacio());
    }

    @Test
    public void seRemueveBloqueInexistenteYSeLanzaExcepcionCorrecta() {
        try {
            BloqueRepetir repeticion = new BloqueRepetir(3);
            BloqueDerecha derecha = new BloqueDerecha();
            repeticion.removerBloque(derecha);
        }
        catch (BloqueInexistenteException expected){ }
    }


}