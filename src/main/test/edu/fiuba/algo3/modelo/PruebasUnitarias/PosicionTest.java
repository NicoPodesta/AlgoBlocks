package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PosicionTest {

    @Test
    public void lasPosicionesSeComparanCorrectamente(){
        Posicion coordenadas1 = new Posicion(0,0);
        Posicion coordenadas2 = new Posicion(0,0);
        assertEquals(coordenadas1,coordenadas2);
    }

    @Test
    public void alMoverHaciaAbajoLasCoordenadasSeActualizanCorrectamente(){
        Posicion posicion = new Posicion(0,0);
        posicion.abajo();
        Posicion nuevaPosicion = new Posicion(0,1);
        assertEquals(posicion,nuevaPosicion);
    }

    @Test
    public void alMoverHaciaArribaLasCoordenadasSeActualizanCorrectamente(){
        Posicion posicion = new Posicion(0,0);
        posicion.arriba();
        Posicion nuevaPosicion = new Posicion(0,-1);
        assertEquals(posicion,nuevaPosicion);
    }

    @Test
    public void alMoverHaciaLaDerechaLasCoordenadasSeActualizanCorrectamente(){
        Posicion posicion = new Posicion(0,0);
        posicion.derecha();
        Posicion nuevaPosicion = new Posicion(1,0);
        assertEquals(posicion,nuevaPosicion);
    }

    @Test
    public void alMoverHaciaLaIzquierdaLasCoordenadasSeActualizanCorrectamente(){
        Posicion posicion = new Posicion(0,0);
        posicion.izquierda();
        Posicion nuevaPosicion = new Posicion(-1,0);
        assertEquals(posicion,nuevaPosicion);
    }

    @Test
    public void moverEnDireccionesOpuestasDevuelveAlOrigen(){
        Posicion posicion = new Posicion(0,0);
        posicion.izquierda();
        posicion.derecha();
        posicion.abajo();
        posicion.arriba();
        Posicion nuevaPosicion = new Posicion(0,0);
        assertEquals(posicion,nuevaPosicion);
    }

    @Test
    public void moverEnMultiplesDirecciones(){
        Posicion posicion = new Posicion(0,0);
        for (int i = 0; i < 5; ++i) {
            posicion.izquierda();
        }
        for (int i = 0; i < 10; ++i) {
            posicion.derecha();
        }
        for (int i = 0; i < 5; ++i) {
            posicion.arriba();
        }
        for (int i = 0; i < 10; ++i) {
            posicion.abajo();
        }
        Posicion nuevaPosicion = new Posicion(5,5);
        assertEquals(posicion,nuevaPosicion);
    }


}