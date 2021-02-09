package edu.fiuba.algo3.modelo.entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;


import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class Entrega2Test {


    @Test
    public void laPizarraSeCreaCorrectamente(){
        Pizarra pizzarra = new Pizarra();
        HashSet<String> pizarraFinal = new HashSet<>();
        assertEquals(pizzarra,pizarraFinal);
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
        Posicion pos1 = new Posicion(0,0);
        pizarraFinal.add(pos1.ClaveString());
        Posicion pos2 = new Posicion(0,1);
        pizarraFinal.add(pos2.ClaveString());
        Posicion pos3 = new Posicion(1,1);
        pizarraFinal.add(pos3.ClaveString());
        assertTrue(tablero.compararPizarra(pizarraFinal));
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