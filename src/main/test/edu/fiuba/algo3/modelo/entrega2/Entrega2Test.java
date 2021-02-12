package edu.fiuba.algo3.modelo.entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega2Test {

    @Test
    public void laPizarraSeCreaCorrectamente(){
        Tablero tablero = new Tablero();
        Pizarra pizarra = new Pizarra();
        assertTrue(tablero.compararPizarra(pizarra));
    }

    @Test
    public void testMoverElPersonajeConElLapizLevantadoNoPintaLaPizarra(){
        Tablero tablero = new Tablero();
        tablero.agregarBloqueAlAlgoritmo(new BloqueAbajo());
        tablero.agregarBloqueAlAlgoritmo(new BloqueDerecha());
        tablero.ejecutarAlgoritmo();
        Pizarra pizarra = new Pizarra();
        assertTrue(tablero.compararPizarra(pizarra));
    }

    @Test
    public void testMoverElPersonajeConElLapizAbajoPintaLaPizarra(){
        Tablero tablero = new Tablero();
        tablero.agregarBloqueAlAlgoritmo(new BloqueLapizApoyado());
        tablero.agregarBloqueAlAlgoritmo(new BloqueAbajo());
        tablero.agregarBloqueAlAlgoritmo(new BloqueDerecha());
        tablero.ejecutarAlgoritmo();
        Pizarra pizarra = new Pizarra();
        pizarra.pintarPosicion(new Posicion(0,0));
        pizarra.pintarPosicion(new Posicion(0,1));
        pizarra.pintarPosicion(new Posicion(1,1));
        assertTrue(tablero.compararPizarra(pizarra));
    }

    @Test
    void crearAlgoritmoConBloqueRepeticion2veces(){
        Tablero tablero = new Tablero();
        BloqueLapizApoyado bloqueApoyarLapiz = new BloqueLapizApoyado();
        BloqueRepetir bloqueRepeticion = new BloqueRepetir(2);
        bloqueRepeticion.agregarBloque(new BloqueDerecha());
        tablero.agregarBloqueAlAlgoritmo(bloqueApoyarLapiz);
        tablero.agregarBloqueAlAlgoritmo(bloqueRepeticion);
        tablero.ejecutarAlgoritmo();
        Pizarra pizarra = new Pizarra();
        pizarra.pintarPosicion(new Posicion(0,0));
        pizarra.pintarPosicion(new Posicion(1,0));
        pizarra.pintarPosicion(new Posicion(2,0));
        assertTrue(tablero.compararPizarra(pizarra));
    }

    @Test
    void crearAlgoritmoConBloqueRepeticion3veces(){
        Tablero tablero = new Tablero();
        BloqueLapizApoyado bloqueApoyarLapiz = new BloqueLapizApoyado();
        BloqueRepetir bloqueRepeticion = new BloqueRepetir(3);
        bloqueRepeticion.agregarBloque(new BloqueAbajo());
        bloqueRepeticion.agregarBloque(new BloqueDerecha());
        tablero.agregarBloqueAlAlgoritmo(bloqueApoyarLapiz);
        tablero.agregarBloqueAlAlgoritmo(bloqueRepeticion);
        tablero.ejecutarAlgoritmo();
        Pizarra pizarra = new Pizarra();
        pizarra.pintarPosicion(new Posicion(0,0));
        pizarra.pintarPosicion(new Posicion(0,1));
        pizarra.pintarPosicion(new Posicion(1,1));
        pizarra.pintarPosicion(new Posicion(1,2));
        pizarra.pintarPosicion(new Posicion(2,2));
        pizarra.pintarPosicion(new Posicion(2,3));
        pizarra.pintarPosicion(new Posicion(3,3));
        assertTrue(tablero.compararPizarra(pizarra));
    }

}