package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {

    @Test
    public void guardaCorrectamenteLosBloquesPersonalizados() {
        Tablero tablero = new Tablero();
        ConjuntoBloques algoritmo = new ConjuntoBloques ();
        BloqueAbajo bloqueAbajo = new BloqueAbajo();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        algoritmo.agregarBloque(bloqueAbajo);
        algoritmo.agregarBloque(bloqueAbajo);
        algoritmo.agregarBloque(bloqueDerecha);
        try {
            tablero.guardarBloquePersonalizado("Letra L", algoritmo);
        } catch (AlgoritmoVacioException e){
            fail();
        }
        try {
            ConjuntoBloques algoritmoPersonalizado = tablero.obtenerBloquePersonalizado("Letra L");
            assertEquals(algoritmoPersonalizado, algoritmo);
        } catch (BloqueInexistenteException e){
            fail();
        }

    }
    @Test
    public void remueveCorrectamenteUnBloquePersonalizado() {
        Tablero tablero = new Tablero();
        ConjuntoBloques algoritmo = new ConjuntoBloques ();
        BloqueAbajo bloqueAbajo = new BloqueAbajo();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        algoritmo.agregarBloque(bloqueAbajo);
        algoritmo.agregarBloque(bloqueAbajo);
        algoritmo.agregarBloque(bloqueDerecha);
        try {
            tablero.guardarBloquePersonalizado("Letra L", algoritmo);
        } catch (AlgoritmoVacioException e){
            fail();
        }
        try {
            tablero.removerBloquePersonalizado("Letra L");
        } catch (BloqueInexistenteException e){
            fail();
        }
        try {
            tablero.obtenerBloquePersonalizado("Letra L");
        } catch (BloqueInexistenteException e){
            //se lanza correctamente la exception
            assertTrue(true);
        }
    }

    @Test
    public void guardarUnbloquePersonalizadoVacioLanzaUnaException() {
        Tablero tablero = new Tablero();
        ConjuntoBloques algoritmo = new ConjuntoBloques ();

        try{
            tablero.guardarBloquePersonalizado("Algoritmo", algoritmo);
        }catch (AlgoritmoVacioException e){
            //se lanza correctamente la exception
            assertTrue(true);
        }
    }

    @Test
    public void removerUnBloquePersonalizadoInexitenteLanzaUnaException() {
        Tablero tablero = new Tablero();

        try {
            tablero.removerBloquePersonalizado("Letra L");
        } catch (BloqueInexistenteException e){
            //se lanza correctamente la exception
            assertTrue(true);
        }
    }

    @Test
    public void obtenerUnBloqueNoGuardadoLanzaUnaExcpetion() {
        Tablero tablero = new Tablero();

        try {
            tablero.obtenerBloquePersonalizado("Letra L");
        } catch (BloqueInexistenteException e){
            //se lanza correctamente la exception
            assertTrue(true);
        }
    }

    @Test
    public void seEjecutaCorrectamenteUnBloquePersonalizadoYaGuardado() {
        Tablero tablero = new Tablero();
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueAbajo bloqueAbajo = new BloqueAbajo();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        tablero.agregarBloqueAlAlgoritmo(new BloqueLapizApoyado());
        algoritmo.agregarBloque(bloqueAbajo);
        algoritmo.agregarBloque(bloqueAbajo);
        algoritmo.agregarBloque(bloqueDerecha);
        try {
            tablero.guardarBloquePersonalizado("Letra L", algoritmo);
        } catch (AlgoritmoVacioException e){
            fail();
        }

        Pizarra pizarraFinal = new Pizarra();
        pizarraFinal.pintarTrazo(new Posicion(0,0));
        pizarraFinal.pintarTrazo(new Posicion(0,1));
        pizarraFinal.pintarTrazo(new Posicion(0,2));
        pizarraFinal.pintarTrazo(new Posicion(1,2));

        try {
            tablero.agregarBloqueAlAlgoritmo(tablero.obtenerBloquePersonalizado("Letra L"));
        } catch (BloqueInexistenteException e){
            fail();
        }

        assertEquals(tablero.ejecutarAlgoritmo(), pizarraFinal);
    }
}