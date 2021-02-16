package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.Pizarra;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.LapizApoyado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LapizApoyadoTest {

    @Test
    public void elLapizApoyadoPintaSobreLaPizarra(){
        LapizApoyado lapiz = new LapizApoyado();
        Posicion posicion = new Posicion(1,1);
        Pizarra pizarra1 = new Pizarra();
        lapiz.pintar(posicion,pizarra1);

        Pizarra pizarra2 = new Pizarra();
        pizarra2.pintarPosicion(posicion);

        assertEquals(pizarra1,pizarra2);

    }

}