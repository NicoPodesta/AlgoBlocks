package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BloqueLapizApoyadoTest {

    @Test
    public void ejecutarElBloqueLapizApoyadoPintaSobreLaPizarra(){
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        Personaje personaje = new Personaje();
        bloqueDerecha.ejecutar(personaje);
        Pizarra pizarra = new Pizarra();
        Posicion posicion = new Posicion(1,0);
        pizarra.pintarPosicion(posicion);
        assertEquals(bloqueLapiz.ejecutar(personaje),pizarra);
    }

    @Test
    public void ejecutarInvertidoElBloqueLapizApoyadoNoPintaSobreLaPizarra(){
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        Personaje personaje = new Personaje();
        bloqueDerecha.ejecutar(personaje);
        Pizarra pizarra = new Pizarra();
        assertEquals(bloqueLapiz.ejecutarInvertido(personaje),pizarra);
    }

}