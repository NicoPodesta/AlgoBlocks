package edu.fiuba.algo3.modelo.entrega1;

import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega1Test {

    @Test
    public void testSeCreaPersonajeConElLapizArriba() {
        Personaje personaje = new Personaje();
        assert(!personaje.estaPintando());
    }

    @Test
    public void testElPersonajeLevantaElLapizConBloque() {
        Personaje personaje = new Personaje();
        BloqueLapizArriba bloque = new BloqueLapizArriba();
        bloque.ejecutar(personaje);
        assert(!personaje.estaPintando());
    }

    @Test
    public void testElPersonajeBajaElLapizConBloque() {
        Personaje personaje = new Personaje();
        BloqueLapizAbajo bloque = new BloqueLapizAbajo();
        bloque.ejecutar(personaje);
        assert(personaje.estaPintando());
    }

    @Test
    public void testElPersonajeSeMueveHaciaArribaConBloque() {
        Personaje personaje = new Personaje();
        BloqueArriba bloque = new BloqueArriba();
        bloque.ejecutar(personaje);
        Vector<Integer> coordenadas = new Vector<>();
        coordenadas.add(-1);
        coordenadas.add(0);
        assertEquals(personaje.posicionActual(),coordenadas);
    }

    @Test
    public void testElPersonajeSeMueveHaciaAbajoConBloque() {
        Personaje personaje = new Personaje();
        BloqueAbajo bloque = new BloqueAbajo();
        bloque.ejecutar(personaje);
        Vector<Integer> coordenadas = new Vector<>();
        coordenadas.add(1);
        coordenadas.add(0);
        assertEquals(personaje.posicionActual(),coordenadas);
    }

    @Test
    public void testElPersonajeSeMueveHaciaLaIzquierdaConBloque() {
        Personaje personaje = new Personaje();
        BloqueIzquierda bloque = new BloqueIzquierda();
        bloque.ejecutar(personaje);
        Vector<Integer> coordenadas = new Vector<>();
        coordenadas.add(0);
        coordenadas.add(-1);
        assertEquals(personaje.posicionActual(),coordenadas);
    }

    @Test
    public void testElPersonajeSeMueveHaciaLaDerechaConBloque() {
        Personaje personaje = new Personaje();
        BloqueDerecha bloque = new BloqueDerecha();
        bloque.ejecutar(personaje);
        Vector<Integer> coordenadas = new Vector<>();
        coordenadas.add(0);
        coordenadas.add(1);
        assertEquals(personaje.posicionActual(),coordenadas);
    }
}
