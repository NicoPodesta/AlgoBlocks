package edu.fiuba.algo3.modelo.entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.Dictionary;
import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.*;

class Entrega2Test {

    @Test
    void moverPersonajeConPincelArribaActualizaCorrectamente(){
        Personaje personaje = new Personaje();
        BloqueArriba bloque = new BloqueArriba();
        bloque.ejecutar(personaje);
    }

    @Test
    void a(){
        Tablero tablero = new Tablero();
        tablero.agregarBloqueAlAlgoritmo(new BloqueLapizApoyado());
        //tablero.agregarBloqueAlAlgoritmo(new BloqueAbajo());
        //tablero.agregarBloqueAlAlgoritmo(new BloqueDerecha());
        tablero.ejecutarAlgoritmo();
        Dictionary<String, Posicion> pizarra1 = new Hashtable<String, Posicion>();
        Posicion pos1 = new Posicion(0,0);
        pizarra1.put(pos1.ClaveString(), pos1);
        //assertEquals(tablero.getPizarra(),pizarra1);
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