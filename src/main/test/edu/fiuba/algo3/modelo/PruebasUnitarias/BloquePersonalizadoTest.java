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
        Trazo trazo1 = new Trazo( new Posicion(0,0),  new Posicion(1,0));
        Trazo trazo2 = new Trazo( new Posicion(1,0),  new Posicion(1,1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);


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
        Trazo trazo1 = new Trazo( new Posicion(0,0),  new Posicion(1,0));
        Trazo trazo2 = new Trazo( new Posicion(1,0),  new Posicion(1,1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);


        assertEquals(personalizado.ejecutar(personaje), pizarra);
    }

    /*@Test
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
        Trazo trazo = new Trazo( new Posicion(0,0),  new Posicion(0,1));
        pizarra.pintarTrazo(trazo);

        assertEquals(personalizado.ejecutar(personaje), pizarra);
    }*/

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
        Trazo trazo1 = new Trazo( new Posicion(0,0),  new Posicion(-1,0));
        Trazo trazo2 = new Trazo( new Posicion(-1,0),  new Posicion(-1,-1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);

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
        Trazo trazo1 = new Trazo( new Posicion(0,0),  new Posicion(1,0));
        Trazo trazo2 = new Trazo( new Posicion(1,0),  new Posicion(1,1));
        Trazo trazo3 = new Trazo( new Posicion(1,1),  new Posicion(2,1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);
        pizarra.pintarTrazo(trazo3);

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

        try {
            personalizado.removerUltimoBloque();
        }catch (AlgoritmoVacioException o){
            fail();
        }
        try {
            personalizado.removerUltimoBloque();
        }catch (AlgoritmoVacioException o){
            fail();
        }

        Pizarra pizarra = new Pizarra();
        Trazo trazo = new Trazo( new Posicion(0,0),  new Posicion(1,0));
        pizarra.pintarTrazo(trazo);

        assertEquals(personalizado.ejecutar(personaje), pizarra);
    }

    @Test
    public void quitarUltimoBloqueABloqueVacioNoHaceNada() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo", algoritmo);

        assertThrows(AlgoritmoVacioException.class, () -> {
            personalizado.removerUltimoBloque();
        });
    }

    @Test
    public void seAgregaYsequitaUltimoAlgoritmoQuedaVacio() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueAbajo abajo = new BloqueAbajo();
        algoritmo.agregarBloque(abajo);

        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo", algoritmo);
        try {
            personalizado.removerUltimoBloque();
        }catch (AlgoritmoVacioException o){
            fail();
        }
        assertTrue(personalizado.estaVacio());
    }

    /*@Test
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
    }*/

}