package edu.fiuba.algo3.modelo.entrega1;

import edu.fiuba.algo3.modelo.BloqueLapizApoyado;
import edu.fiuba.algo3.modelo.BloqueLapizLevantado;
import edu.fiuba.algo3.modelo.Personaje;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega1Test {

    @Test
    public void testSeCreaPersonajeConElLapizLevantado() {
        Personaje personaje = new Personaje();
        assertFalse(personaje.estaPintando());
    }

    @Test
    public void testElPersonajeLevantaElLapizConBloque() {
        Personaje personaje = new Personaje();
        BloqueLapizLevantado bloque = new BloqueLapizLevantado();
        bloque.ejecutar(personaje);
        assertFalse(personaje.estaPintando());
    }

    @Test
    public void testElPersonajeBajaElLapizConBloque() {
        Personaje personaje = new Personaje();
        BloqueLapizApoyado bloque = new BloqueLapizApoyado();
        bloque.ejecutar(personaje);
        assertTrue(personaje.estaPintando());
    }

    @Test
    public void testElPersonajeSeMueveHaciaArribaConBloque() {
        Personaje personaje = new Personaje();
        BloqueArriba bloque = new BloqueArriba();
        bloque.ejecutar(personaje);
        Vector<Integer> coordenadas = new Vector<>();
        coordenadas.add(-1);
        coordenadas.add(0);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeSeMueveHaciaAbajoConBloque() {
        Personaje personaje = new Personaje();
        BloqueAbajo bloque = new BloqueAbajo();
        bloque.ejecutar(personaje);
        Vector<Integer> coordenadas = new Vector<>();
        coordenadas.add(1);
        coordenadas.add(0);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeSeMueveHaciaLaIzquierdaConBloque() {
        Personaje personaje = new Personaje();
        BloqueIzquierda bloque = new BloqueIzquierda();
        bloque.ejecutar(personaje);
        Vector<Integer> coordenadas = new Vector<>();
        coordenadas.add(0);
        coordenadas.add(-1);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeSeMueveHaciaLaDerechaConBloque() {
        Personaje personaje = new Personaje();
        BloqueDerecha bloque = new BloqueDerecha();
        bloque.ejecutar(personaje);
        Vector<Integer> coordenadas = new Vector<>();
        coordenadas.add(0);
        coordenadas.add(1);
        assertEquals(personaje.posicionActual(), coordenadas);
    }
}