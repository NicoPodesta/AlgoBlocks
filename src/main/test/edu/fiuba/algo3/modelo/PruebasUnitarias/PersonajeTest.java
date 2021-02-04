package edu.fiuba.algo3.modelo.PruebasUnitarias;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    @Test
    public void testElPersonajeMueveCorrectamenteLaPosicionALaDerecha(){
        Personaje personaje = new Personaje();
        personaje.moverHaciaLaDerecha();
        Posicion coordenadas = new Posicion(0,-1);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeMueveCorrectamenteLaPosicionALaIzquierda(){
        Personaje personaje = new Personaje();
        personaje.moverHaciaLaIzquierda();
        Posicion coordenadas = new Posicion(-1,0);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeMueveCorrectamenteLaPosicionHaciaArriba(){
        Personaje personaje = new Personaje();
        personaje.moverHaciaArriba();
        Posicion coordenadas = new Posicion(0,-1);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeMueveCorrectamenteLaPosicionHaciaAbajo(){
        Personaje personaje = new Personaje();
        personaje.moverHaciaAbajo();
        Posicion coordenadas = new Posicion(0,1);
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