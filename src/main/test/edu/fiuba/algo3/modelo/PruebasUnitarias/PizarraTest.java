package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.Pizarra;
import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizarraTest {

    @Test
    public void lasPosicionesSePintanCorrectamente(){
        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = new Posicion(4,20);
        Pizarra pizarra1 = new Pizarra();
        Pizarra pizarra2 = new Pizarra();

        pizarra1.pintarPosicion(posicion1);
        pizarra1.pintarPosicion(posicion2);

        pizarra2.pintarPosicion(posicion1);
        pizarra2.pintarPosicion(posicion2);

        assertEquals(pizarra1,pizarra2);

    }

    @Test
    public void lasPosicionesSePintanCorrectamenteNoImportaElOrden(){
        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = new Posicion(4,20);
        Posicion posicion3 = new Posicion(1,2);
        Pizarra pizarra1 = new Pizarra();
        Pizarra pizarra2 = new Pizarra();

        pizarra1.pintarPosicion(posicion3);
        pizarra1.pintarPosicion(posicion2);
        pizarra1.pintarPosicion(posicion1);

        pizarra2.pintarPosicion(posicion1);
        pizarra2.pintarPosicion(posicion3);
        pizarra2.pintarPosicion(posicion2);

        assertEquals(pizarra1,pizarra2);

    }

    @Test
    public void lasPosicionesNoSeRepitenEnLaPizarra(){
        Posicion posicion1 = new Posicion(0,0);
        Pizarra pizarra1 = new Pizarra();
        Pizarra pizarra2 = new Pizarra();

        pizarra1.pintarPosicion(posicion1);

        pizarra2.pintarPosicion(posicion1);
        pizarra2.pintarPosicion(posicion1);
        pizarra2.pintarPosicion(posicion1);
        pizarra2.pintarPosicion(posicion1);


        assertEquals(pizarra1,pizarra2);

    }
}