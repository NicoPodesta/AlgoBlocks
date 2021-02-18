package edu.fiuba.algo3.modelo.entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        BloqueArriba bloqueArriba = new BloqueArriba();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        bloqueArriba.ejecutar(personaje);
        bloqueDerecha.ejecutar(personaje);
        Pizarra pizarra = new Pizarra();
        assertEquals(personaje.pizarraActual(),pizarra);
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
        Pizarra pizarra = new Pizarra();
        pizarra.pintarPosicion(new Posicion(0,0));
        pizarra.pintarPosicion(new Posicion(0,-1));
        pizarra.pintarPosicion(new Posicion(1,-1));
        assertEquals(personaje.pizarraActual(), pizarra);
    }

    @Test
    public void testElPersonajeSeMuevePrimeroConElLapizArribaYDespuesConElLapizAbajo() {
        Personaje personaje = new Personaje();
        Pizarra pizarra = new Pizarra();

        BloqueAbajo bloqueAbajo = new BloqueAbajo();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        bloqueAbajo.ejecutar(personaje);
        bloqueDerecha.ejecutar(personaje);

        assertEquals(personaje.pizarraActual(), pizarra);

        BloqueLapizApoyado bloqueApoyado = new BloqueLapizApoyado();
        bloqueApoyado.ejecutar(personaje);
        bloqueDerecha.ejecutar(personaje);
        pizarra.pintarPosicion(new Posicion(1, 1));
        pizarra.pintarPosicion(new Posicion(2,1));

        assertEquals(personaje.pizarraActual(), pizarra);
    }
}
