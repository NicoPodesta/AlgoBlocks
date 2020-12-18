package edu.fiuba.algo3.modelo.PruebasUnitarias;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;
public class PersonajeTest {
    @Test
    public void testElPersonajeMueveCorrectamenteLaPosicionALaDerecha(){
        Personaje personaje = new Personaje();
        personaje.moverHaciaLaDerecha();
        Vector<Integer> coordenadas = new Vector<>();
        coordenadas.add(1);
        coordenadas.add(0);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeMueveCorrectamenteLaPosicionALaIzquierda(){
        Personaje personaje = new Personaje();
        personaje.moverHaciaLaIzquierda();
        Vector<Integer> coordenadas = new Vector<>();
        coordenadas.add(-1);
        coordenadas.add(0);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeMueveCorrectamenteLaPosicionHaciaArriba(){
        Personaje personaje = new Personaje();
        personaje.moverHaciaArriba();
        Vector<Integer> coordenadas = new Vector<>();
        coordenadas.add(0);
        coordenadas.add(-1);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeMueveCorrectamenteLaPosicionHaciaAbajo(){
        Personaje personaje = new Personaje();
        personaje.moverHaciaAbajo();
        Vector<Integer> coordenadas = new Vector<>();
        coordenadas.add(0);
        coordenadas.add(1);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testELPersonajeConElLapizApoyadoPinta(){
        Personaje personaje = new Personaje();
        personaje.apoyarLapiz();
        assertTrue(personaje.estaPintando());
    }

    @Test
    public void testELPersonajeConElLapizLevantadoNoPinta(){
        Personaje personaje = new Personaje();
        assertFalse(personaje.estaPintando());
    }
}
