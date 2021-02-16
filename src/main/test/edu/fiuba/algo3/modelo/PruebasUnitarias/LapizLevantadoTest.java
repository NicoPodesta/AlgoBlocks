package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.LapizLevantado;
import edu.fiuba.algo3.modelo.Pizarra;
import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LapizLevantadoTest {

    @Test
    public void elLapizLevantadoNoPintaSobreLaPizarra(){
        LapizLevantado lapiz = new LapizLevantado();
        Posicion posicion = new Posicion(1,1);
        Pizarra pizarra1 = new Pizarra();
        lapiz.pintar(posicion,pizarra1);

        Pizarra pizarra2 = new Pizarra();

        assertEquals(pizarra1,pizarra2);

    }
}