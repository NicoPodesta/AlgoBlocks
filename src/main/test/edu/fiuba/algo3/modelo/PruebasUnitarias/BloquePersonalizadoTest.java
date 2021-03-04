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
        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo");
        try{
            personalizado.agregarAlgoritmo(algoritmo);
        }catch (AlgoritmoVacioException o){
            fail();
        }
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

        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo");
        try{
            personalizado.agregarAlgoritmo(algoritmo);
        }catch (AlgoritmoVacioException o){
            fail();
        }

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
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);

        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo");
        try{
            personalizado.agregarAlgoritmo(algoritmo);
        }catch (AlgoritmoVacioException o){
            fail();
        }


        Pizarra pizarra = new Pizarra();
        Trazo trazo1 = new Trazo( new Posicion(0,0),  new Posicion(1,0));
        Trazo trazo2 = new Trazo( new Posicion(1,0),  new Posicion(1,1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);


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

        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo");
        try{
            personalizado.agregarAlgoritmo(algoritmo);
        }catch (AlgoritmoVacioException o){
            fail();
        }


        Pizarra pizarra = new Pizarra();
        Trazo trazo1 = new Trazo( new Posicion(0,0),  new Posicion(-1,0));
        Trazo trazo2 = new Trazo( new Posicion(-1,0),  new Posicion(-1,-1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);

        assertEquals(personalizado.ejecutarInvertido(personaje), pizarra);
    }

    /*@Test
    public void seAnidanAlgoritmosPersonalizados() {
        ConjuntoBloques algoritmoA = new ConjuntoBloques();
        ConjuntoBloques algoritmoB = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();


        algoritmoA.agregarBloque(bloqueLapiz);
        algoritmoA.agregarBloque(derecha);
        BloquePersonalizado personalizadoA = new BloquePersonalizado("Nuevo Algoritmo");
        personalizadoA.agregarAlgoritmo(algoritmoA);

        algoritmoB.agregarBloque(abajo);
        algoritmoB.agregarBloque(derecha);
        BloquePersonalizado personalizadoB = new BloquePersonalizado("Nuevo Algoritmo");
        personalizadoB.agregarAlgoritmo(algoritmoB);

        personalizadoA.agregarBloque(personalizadoB); //una vez que se guarda el añgpritmo no se puede volver a agregar

        Pizarra pizarra = new Pizarra();
        Trazo trazo1 = new Trazo( new Posicion(0,0),  new Posicion(1,0));
        Trazo trazo2 = new Trazo( new Posicion(1,0),  new Posicion(1,1));
        Trazo trazo3 = new Trazo( new Posicion(1,1),  new Posicion(2,1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);
        pizarra.pintarTrazo(trazo3);

        assertEquals(algoritmoA.ejecutar(personaje), pizarra);
    }*/

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
        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo");
        try{
            personalizado.agregarAlgoritmo(algoritmo);
        }catch (AlgoritmoVacioException o){
            fail();
        }

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
    public void agregarAlgoritmoVacioLanzaExcepcion() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo");
        try{
            personalizado.agregarAlgoritmo(algoritmo);
        }catch (AlgoritmoVacioException o){
            assertTrue(true);
        }


    }

}