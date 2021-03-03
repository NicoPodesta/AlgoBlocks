package edu.fiuba.algo3.modelo.entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

public class Entrega2Test {

    @Test
    public void laPizarraSeCreaCorrectamente(){
        Tablero tablero = new Tablero();
        Pizarra pizarra = new Pizarra();
        assertEquals(tablero.ejecutarAlgoritmo(),pizarra);
    }

    @Test
    public void testMoverElPersonajeConElLapizLevantadoNoPintaLaPizarra(){
        Tablero tablero = new Tablero();
        tablero.agregarBloqueAlAlgoritmo(new BloqueAbajo());
        tablero.agregarBloqueAlAlgoritmo(new BloqueDerecha());
        Pizarra pizarra = new Pizarra();
        assertEquals(tablero.ejecutarAlgoritmo(),pizarra);
    }

    @Test
    public void testMoverElPersonajeConElLapizAbajoPintaLaPizarra(){
        Tablero tablero = new Tablero();
        tablero.agregarBloqueAlAlgoritmo(new BloqueLapizApoyado());
        tablero.agregarBloqueAlAlgoritmo(new BloqueAbajo());
        tablero.agregarBloqueAlAlgoritmo(new BloqueDerecha());
        Pizarra pizarra = new Pizarra();
        pizarra.pintarTrazo(new Posicion(0,0));
        pizarra.pintarTrazo(new Posicion(0,1));
        pizarra.pintarTrazo(new Posicion(1,1));
        assertEquals(tablero.ejecutarAlgoritmo(),pizarra);
    }

    @Test
    public void crearAlgoritmoConBloqueRepeticion2veces(){
        Tablero tablero = new Tablero();
        BloqueLapizApoyado bloqueApoyarLapiz = new BloqueLapizApoyado();
        BloqueRepetir bloqueRepeticion = new BloqueRepetir(2);
        bloqueRepeticion.agregarBloque(new BloqueDerecha());
        tablero.agregarBloqueAlAlgoritmo(bloqueApoyarLapiz);
        tablero.agregarBloqueAlAlgoritmo(bloqueRepeticion);
        Pizarra pizarra = new Pizarra();
        pizarra.pintarTrazo(new Posicion(0,0));
        pizarra.pintarTrazo(new Posicion(1,0));
        pizarra.pintarTrazo(new Posicion(2,0));
        assertEquals(tablero.ejecutarAlgoritmo(),pizarra);
    }

    @Test
    public void crearAlgoritmoConBloqueRepeticion3veces(){
        Tablero tablero = new Tablero();
        BloqueLapizApoyado bloqueApoyarLapiz = new BloqueLapizApoyado();
        BloqueRepetir bloqueRepeticion = new BloqueRepetir(3);
        bloqueRepeticion.agregarBloque(new BloqueAbajo());
        bloqueRepeticion.agregarBloque(new BloqueDerecha());
        tablero.agregarBloqueAlAlgoritmo(bloqueApoyarLapiz);
        tablero.agregarBloqueAlAlgoritmo(bloqueRepeticion);
        Pizarra pizarra = new Pizarra();
        pizarra.pintarTrazo(new Posicion(0,0));
        pizarra.pintarTrazo(new Posicion(0,1));
        pizarra.pintarTrazo(new Posicion(1,1));
        pizarra.pintarTrazo(new Posicion(1,2));
        pizarra.pintarTrazo(new Posicion(2,2));
        pizarra.pintarTrazo(new Posicion(2,3));
        pizarra.pintarTrazo(new Posicion(3,3));
        assertEquals(tablero.ejecutarAlgoritmo(),pizarra);
    }
}