package edu.fiuba.algo3.modelo.entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Entrega2Test {

    @Test
    void moverPersonajeConPincelArribaActualizaCorrectamente(){
        Personaje personaje = new Personaje();
        BloqueArriba bloque = new BloqueArriba();
        bloque.ejecutar(personaje);
        Pizarra pizarra = new Pizarra(10);
    }
    @Test
    void moverPersonajeConPincelabajoActualizaCorrectamente(){
        Personaje personaje = new Personaje();
        BloqueLapizApoyado bloquelapiz = new BloqueLapizApoyado();
        System.out.println("Pizarra 1");
    }
}