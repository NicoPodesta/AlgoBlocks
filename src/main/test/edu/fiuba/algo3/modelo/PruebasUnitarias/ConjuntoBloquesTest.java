package edu.fiuba.algo3.modelo.PruebasUnitarias;


import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConjuntoBloquesTest {

    @Test
    public void elAlgoritmoSeCreaCorrectamente() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        assertTrue(algoritmo.estaVacio());
    }

    @Test
    public void seAgreganVariosBloquesYSeEjecutan() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        algoritmo.agregarBloque(bloqueLapiz);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);

        Pizarra pizarra = new Pizarra();
        pizarra.pintarTrazo(new Trazo(new Posicion(0,0),new Posicion(1,0)));
        pizarra.pintarTrazo(new Trazo(new Posicion(1,0),new Posicion(1,1)));


        assertEquals(algoritmo.ejecutar(personaje), pizarra);
    }

    /*@Test
    public void seAgreganVariosBloquesLuegoSeRemuevenYSeEjecutan() {
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

        try {
            algoritmo.removerBloque(derecha);
        } catch(BloqueInexistenteException e){
            fail();
        }
        try {
            algoritmo.removerBloque(arriba);
        } catch(BloqueInexistenteException e){
            fail();
        }

        Pizarra pizarra = new Pizarra();
        pizarra.pintarTrazo(new Trazo(new Posicion(0,0),new Posicion(0,1)));


        assertEquals(algoritmo.ejecutar(personaje), pizarra);
    }*/

    @Test
    public void seEjecutaInvertidoElAlgoritmo() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        algoritmo.agregarBloque(bloqueLapiz);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);

        Pizarra pizarra = new Pizarra();

        assertEquals(algoritmo.ejecutarInvertido(personaje), pizarra);
    }

    @Test
    public void seAnidanConjuntos() {
        ConjuntoBloques algoritmoA = new ConjuntoBloques();
        ConjuntoBloques algoritmoB = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        algoritmoA.agregarBloque(bloqueLapiz);
        algoritmoB.agregarBloque(derecha);
        algoritmoB.agregarBloque(abajo);
        algoritmoA.agregarBloque(algoritmoB);


        Pizarra pizarra = new Pizarra();
        pizarra.pintarTrazo(new Trazo(new Posicion(0,0),new Posicion(1,0)));
        pizarra.pintarTrazo(new Trazo(new Posicion(1,0),new Posicion(1,1)));

        assertEquals(algoritmoA.ejecutar(personaje), pizarra);
    }

    /*@Test
    public void removerUnBloqueInesxistenteLanzaUnaException() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        try {
            algoritmo.removerBloque(new BloqueDerecha());
        } catch (BloqueInexistenteException e){
            //se lanza correctamente la exception
            assertTrue(true);
        }
    }*/

    @Test
    public void elNombreDelBloqueEsElCorrecto() {
        ConjuntoBloques bloque = new ConjuntoBloques();
        assertEquals(bloque.obtenerNombre(), "Conjunto Bloques");
    }

    @Test
    public void elUltimoBloqueSeRemueveCorrectamente() {
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
        try {
            algoritmo.removerUltimoBloque();
        }catch (AlgoritmoVacioException o){
            fail();
        }
        try {
            algoritmo.removerUltimoBloque();
        }catch (AlgoritmoVacioException o){
            fail();
        }

        Pizarra pizarra = new Pizarra();
        pizarra.pintarTrazo(new Trazo(new Posicion(0,0),new Posicion(1,0)));

        assertEquals(algoritmo.ejecutar(personaje), pizarra);
    }

    @Test
    public void quitarUltimoBloqueABloqueVacioNoHaceNada() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        try {
            algoritmo.removerUltimoBloque();
        }catch (AlgoritmoVacioException o){
            fail();
        }
        assertTrue(algoritmo.estaVacio());
    }

    @Test
    public void seAgregaYsequitaUltimoAlgoritmoQuedaVacio() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueDerecha derecha = new BloqueDerecha();
        algoritmo.agregarBloque(derecha);
        try {
            algoritmo.removerUltimoBloque();
        }catch (AlgoritmoVacioException o){
            fail();
        }
        assertTrue(algoritmo.estaVacio());
    }

    /*@Test
    public void seRemueveBloqueInexistenteYSeLanzaExcepcionCorrecta() {
        try {
            ConjuntoBloques algoritmo = new ConjuntoBloques();
            BloqueDerecha derecha = new BloqueDerecha();
            algoritmo.removerBloque(derecha);
        }
        catch (BloqueInexistenteException expected){ }
    }*/

}







