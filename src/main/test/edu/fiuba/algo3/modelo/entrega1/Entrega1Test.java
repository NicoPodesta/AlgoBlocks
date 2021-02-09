package edu.fiuba.algo3.modelo.entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega1Test {

    @Test
    public void testElPersonajeSeMueveHaciaArribaConBloque() {
        Personaje personaje = new Personaje();
        BloqueArriba bloque = new BloqueArriba();
        bloque.ejecutar(personaje);
        Posicion coordenadas = new Posicion(0,-1);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeSeMueveHaciaAbajoConBloque() {
        Personaje personaje = new Personaje();
        BloqueAbajo bloque = new BloqueAbajo();
        bloque.ejecutar(personaje);
        Posicion coordenadas = new Posicion(0,1);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeSeMueveHaciaLaIzquierdaConBloque() {
        Personaje personaje = new Personaje();
        BloqueIzquierda bloque = new BloqueIzquierda();
        bloque.ejecutar(personaje);
        Posicion coordenadas = new Posicion(-1,0);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeSeMueveHaciaLaDerechaConBloque() {
        Personaje personaje = new Personaje();
        BloqueDerecha bloque = new BloqueDerecha();
        bloque.ejecutar(personaje);
        Posicion coordenadas = new Posicion(1,0);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testSeCreaPersonajeConElLapizLevantado() {
        Personaje personaje = new Personaje();
        BloqueArriba bloque = new BloqueArriba();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        bloque.ejecutar(personaje);
        bloqueDerecha.ejecutar(personaje);
        HashSet <String> pizarraFinal = new HashSet<>();
        assertTrue(personaje.compararLaPizarra(pizarraFinal));
    }

    @Test
    public void testElPersonajeDibujaConElLapizAbajo() {
        Personaje personaje = new Personaje();
        BloqueLapizApoyado bloque = new BloqueLapizApoyado();
        BloqueArriba bloqueArriba = new BloqueArriba();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        bloque.ejecutar(personaje);
        bloqueArriba.ejecutar(personaje);
        bloqueDerecha.ejecutar(personaje);
        bloque.ejecutar(personaje);
        HashSet <String> pizarraFinal = new HashSet<>();
        pizarraFinal.add((new Posicion(0,0)).ClaveString());
        pizarraFinal.add((new Posicion(0,-1)).ClaveString());
        pizarraFinal.add((new Posicion(1,-1)).ClaveString());
        assertTrue(personaje.compararLaPizarra(pizarraFinal));
    }

    @Test
    public void testElPersonajeSeMuevePrimeroConElLapizArribaYDespuesConElLapizAbajo() {
        Personaje personaje = new Personaje();
        HashSet <String> pizarraFinal = new HashSet<>();

        BloqueAbajo bloqueAbajo = new BloqueAbajo();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        bloqueAbajo.ejecutar(personaje);
        bloqueDerecha.ejecutar(personaje);

        assertTrue(personaje.compararLaPizarra(pizarraFinal));

        BloqueLapizApoyado bloqueApoyado = new BloqueLapizApoyado();
        bloqueApoyado.ejecutar(personaje);
        bloqueDerecha.ejecutar(personaje);
        pizarraFinal.add((new Posicion(1, 1)).ClaveString());
        pizarraFinal.add((new Posicion(2,1)).ClaveString());

        assertTrue(personaje.compararLaPizarra(pizarraFinal));
    }
}
