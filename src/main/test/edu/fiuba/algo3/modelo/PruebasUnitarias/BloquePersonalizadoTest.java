package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloquePersonalizadoTest {

    @Test
    public void elAlgoritmoPersonalizadoSeCreaCorrectamente() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueDerecha derecha = new BloqueDerecha();
        algoritmo.agregarBloque(derecha);
        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo", algoritmo);
        assertEquals(personalizado.obtenerNombre(), "Nuevo Algoritmo");

    }


    @Test
    public void seCreaUnNuevoAlgoritmoySeEjecuta() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        algoritmo.agregarBloque(bloqueLapiz);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);

        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo", algoritmo);

        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);
        pizarra.pintarTrazo(posicion);
        posicion.derecha();
        pizarra.pintarTrazo(posicion);
        posicion.abajo();
        pizarra.pintarTrazo(posicion);


        assertEquals(personalizado.ejecutar(personaje),pizarra);
    }

    @Test
    public void seCreaUnNuevoAlgoritmoySeModifica() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        algoritmo.agregarBloque(bloqueLapiz);
        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo", algoritmo);
        personalizado.agregarBloque(derecha);
        personalizado.agregarBloque(abajo);


        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);
        pizarra.pintarTrazo(posicion);
        posicion.derecha();
        pizarra.pintarTrazo(posicion);
        posicion.abajo();
        pizarra.pintarTrazo(posicion);


        assertEquals(personalizado.ejecutar(personaje), pizarra);
    }

    @Test
    public void seCreaNuevoAlgorimoySeRemuevenBloques() {
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
        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo", algoritmo);

        try {
            personalizado.removerBloque(derecha);
        }catch (BloqueInexistenteException e){
            fail();
        }
        try {
            personalizado.removerBloque(arriba);
        } catch (BloqueInexistenteException e){
            fail();
        }


        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);
        pizarra.pintarTrazo(posicion);
        posicion.abajo();
        pizarra.pintarTrazo(posicion);


        assertEquals(personalizado.ejecutar(personaje), pizarra);
    }

    @Test
    public void seEjecutaInvertidoElAlgoritmo() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizLevantado bloqueLapiz = new BloqueLapizLevantado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        algoritmo.agregarBloque(bloqueLapiz);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);

        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo", algoritmo);


        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);
        pizarra.pintarTrazo(posicion);
        posicion.izquierda();
        pizarra.pintarTrazo(posicion);
        posicion.arriba();
        pizarra.pintarTrazo(posicion);

        assertEquals(personalizado.ejecutarInvertido(personaje), pizarra);
    }

    @Test
    public void seAnidanAlgoritmosPersonalizados() {
        ConjuntoBloques algoritmoA = new ConjuntoBloques();
        ConjuntoBloques algoritmoB = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();


        algoritmoA.agregarBloque(bloqueLapiz);
        algoritmoA.agregarBloque(derecha);
        BloquePersonalizado personalizadoA = new BloquePersonalizado("Bajar Lapiz y mover derecha", algoritmoA);

        algoritmoB.agregarBloque(abajo);
        algoritmoB.agregarBloque(derecha);
        BloquePersonalizado personalizadoB = new BloquePersonalizado("Abajo y Derecha", algoritmoB);

        personalizadoA.agregarBloque(personalizadoB);

        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);
        pizarra.pintarTrazo(posicion);
        posicion.derecha();
        pizarra.pintarTrazo(posicion);
        posicion.abajo();
        pizarra.pintarTrazo(posicion);
        posicion.derecha();
        pizarra.pintarTrazo(posicion);

        assertEquals(algoritmoA.ejecutar(personaje), pizarra);
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
        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo", algoritmo);

        personalizado.removerUltimoBloque();
        personalizado.removerUltimoBloque();

        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(0,0);
        pizarra.pintarTrazo(posicion);
        posicion.derecha();
        pizarra.pintarTrazo(posicion);


        assertEquals(personalizado.ejecutar(personaje), pizarra);
    }

    @Test
    public void quitarUltimoBloqueABloqueVacioNoHaceNada() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo", algoritmo);
        personalizado.removerUltimoBloque();
        assertTrue(personalizado.estaVacio());
    }

    @Test
    public void seAgregaYsequitaUltimoAlgoritmoQuedaVacio() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueAbajo abajo = new BloqueAbajo();
        algoritmo.agregarBloque(abajo);

        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo", algoritmo);
        personalizado.removerUltimoBloque();
        assertTrue(personalizado.estaVacio());
    }

    @Test
    public void seRemueveBloqueInexistenteYSeLanzaExcepcionCorrecta() {
        try {
            ConjuntoBloques algoritmo = new ConjuntoBloques();
            BloqueLapizLevantado bloqueLapiz = new BloqueLapizLevantado();
            BloqueDerecha derecha = new BloqueDerecha();
            BloqueAbajo abajo = new BloqueAbajo();

            algoritmo.agregarBloque(bloqueLapiz);
            algoritmo.agregarBloque(abajo);

            BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo", algoritmo);
            personalizado.removerBloque(derecha);
        }
        catch (BloqueInexistenteException expected){ }
    }
}