package edu.fiuba.algo3.modelo.entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.*;

class Entrega2Test {


    @Test
    void laPizarraSeCreaCorrectamente(){
        Pizarra pizzarra = new Pizarra();
        HashSet<String> pizarra1 = new HashSet<String>();
        assertEquals(pizzarra,pizarra1);
    }

    @Test
    void moverElPErsonajeConElLapizLevantadoNoPintaLaPizarra(){
        Tablero tablero = new Tablero();
        tablero.agregarBloqueAlAlgoritmo(new BloqueAbajo());
        tablero.agregarBloqueAlAlgoritmo(new BloqueDerecha());
        tablero.ejecutarAlgoritmo();
        HashSet<String> pizarra1 = new HashSet<String>();
        assertTrue(tablero.compararPizarra(pizarra1));
    }

    @Test
    void moverElPersonajeConElLapizAbajoPintaLaPizarra(){
        Tablero tablero = new Tablero();
        tablero.agregarBloqueAlAlgoritmo(new BloqueLapizApoyado());
        tablero.agregarBloqueAlAlgoritmo(new BloqueAbajo());
        tablero.agregarBloqueAlAlgoritmo(new BloqueDerecha());
        tablero.ejecutarAlgoritmo();
        HashSet<String> pizarra1 = new HashSet<String>();
        Posicion pos1 = new Posicion(0,0);
        pizarra1.add(pos1.ClaveString());
        Posicion pos2 = new Posicion(0,1);
        pizarra1.add(pos2.ClaveString());
        Posicion pos3 = new Posicion(1,1);
        pizarra1.add(pos3.ClaveString());
        assertTrue(tablero.compararPizarra(pizarra1));
    }

    @Test
    void crearAlgoritmoConBloqueRepeticion(){
        Tablero tablero = new Tablero();
        BloqueLapizApoyado bloqueApoyarLapiz = new BloqueLapizApoyado();
        BloqueRepetirN bloqueRepeticion = new BloqueRepetirN(2);
        bloqueRepeticion.agregarBloque(new BloqueAbajo());
        bloqueRepeticion.agregarBloque(new BloqueDerecha());
        tablero.agregarBloqueAlAlgoritmo(bloqueApoyarLapiz);
        tablero.agregarBloqueAlAlgoritmo(bloqueRepeticion);
        tablero.ejecutarAlgoritmo();
    }

}