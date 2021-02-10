package edu.fiuba.algo3.modelo.entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Entrega2Test {


    @Test
    public void laPizarraSeCreaCorrectamente(){
        Tablero tablero = new Tablero();
        HashSet<String> pizarraFinal = new HashSet<>();
        assertTrue(tablero.compararPizarra(pizarraFinal));
    }

    @Test
    public void testMoverElPErsonajeConElLapizLevantadoNoPintaLaPizarra(){
        Tablero tablero = new Tablero();
        tablero.agregarBloqueAlAlgoritmo(new BloqueAbajo());
        tablero.agregarBloqueAlAlgoritmo(new BloqueDerecha());
        tablero.ejecutarAlgoritmo();
        HashSet<String> pizarraFinal = new HashSet<>();
        assertTrue(tablero.compararPizarra(pizarraFinal));
    }

    @Test
    public void testMoverElPersonajeConElLapizAbajoPintaLaPizarra(){
        Tablero tablero = new Tablero();
        tablero.agregarBloqueAlAlgoritmo(new BloqueLapizApoyado());
        tablero.agregarBloqueAlAlgoritmo(new BloqueAbajo());
        tablero.agregarBloqueAlAlgoritmo(new BloqueDerecha());
        tablero.ejecutarAlgoritmo();
        HashSet<String> pizarraFinal = new HashSet<>();
        pizarraFinal.add(new Posicion(0,0).ClaveString());
        pizarraFinal.add(new Posicion(0,1).ClaveString());
        pizarraFinal.add(new Posicion(1,1).ClaveString());
        assertTrue(tablero.compararPizarra(pizarraFinal));
    }

    @Test
    void crearAlgoritmoConBloqueRepeticion2veces(){
        Tablero tablero = new Tablero();
        BloqueLapizApoyado bloqueApoyarLapiz = new BloqueLapizApoyado();
        BloqueRepetirN bloqueRepeticion = new BloqueRepetirN(2);
        bloqueRepeticion.agregarBloque(new BloqueDerecha());
        tablero.agregarBloqueAlAlgoritmo(bloqueApoyarLapiz);
        tablero.agregarBloqueAlAlgoritmo(bloqueRepeticion);
        tablero.ejecutarAlgoritmo();
        HashSet<String> pizarraFinal = new HashSet<>();
        pizarraFinal.add(new Posicion(0,0).ClaveString());
        pizarraFinal.add(new Posicion(1,0).ClaveString());
        pizarraFinal.add(new Posicion(2,0).ClaveString());
        assertTrue(tablero.compararPizarra(pizarraFinal));
    }

    @Test
    void crearAlgoritmoConBloqueRepeticion3veces(){
        Tablero tablero = new Tablero();
        BloqueLapizApoyado bloqueApoyarLapiz = new BloqueLapizApoyado();
        BloqueRepetirN bloqueRepeticion = new BloqueRepetirN(3);
        bloqueRepeticion.agregarBloque(new BloqueAbajo());
        bloqueRepeticion.agregarBloque(new BloqueDerecha());
        tablero.agregarBloqueAlAlgoritmo(bloqueApoyarLapiz);
        tablero.agregarBloqueAlAlgoritmo(bloqueRepeticion);
        tablero.ejecutarAlgoritmo();
        HashSet<String> pizarraFinal = new HashSet<>();
        pizarraFinal.add(new Posicion(0,0).ClaveString());
        pizarraFinal.add(new Posicion(0,1).ClaveString());
        pizarraFinal.add(new Posicion(1,1).ClaveString());
        pizarraFinal.add(new Posicion(1,2).ClaveString());
        pizarraFinal.add(new Posicion(2,2).ClaveString());
        pizarraFinal.add(new Posicion(2,3).ClaveString());
        pizarraFinal.add(new Posicion(3,3).ClaveString());
        assertTrue(tablero.compararPizarra(pizarraFinal));
    }

}