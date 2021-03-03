package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.Pizarra;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Trazo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizarraTest {

    @Test
    public void losTrazosSePintanCorrectamente() {
        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = new Posicion(4,20);
        Pizarra pizarra1 = new Pizarra();
        Pizarra pizarra2 = new Pizarra();
        Trazo trazo1 = new Trazo(posicion1,posicion2);
        Trazo trazo2 = new Trazo(posicion1,posicion2);

        pizarra1.pintarTrazo(trazo1);
        pizarra2.pintarTrazo(trazo2);

        assertEquals(pizarra1, pizarra2);
    }

    @Test
    public void loTrazosPintanCorrectamenteNoImportaElOrden() {
        Trazo trazo1 = new Trazo(new Posicion(0,0),new Posicion(4,20));
        Trazo trazo2 = new Trazo(new Posicion(1,2),new Posicion(2,22));
        Trazo trazo3 = new Trazo(new Posicion(2,3),new Posicion(4,20));
        Pizarra pizarra1 = new Pizarra();
        Pizarra pizarra2 = new Pizarra();

        pizarra1.pintarTrazo(trazo3);
        pizarra1.pintarTrazo(trazo2);
        pizarra1.pintarTrazo(trazo1);

        pizarra2.pintarTrazo(trazo1);
        pizarra2.pintarTrazo(trazo3);
        pizarra2.pintarTrazo(trazo2);

        assertEquals(pizarra1, pizarra2);
    }

    @Test
    public void losTrazosNoSeRepitenEnLaPizarra() {
        Trazo trazo = new Trazo(new Posicion(0,0),new Posicion(4,20));
        Pizarra pizarra1 = new Pizarra();
        Pizarra pizarra2 = new Pizarra();

        pizarra1.pintarTrazo(trazo);

        pizarra2.pintarTrazo(trazo);
        pizarra2.pintarTrazo(trazo);
        pizarra2.pintarTrazo(trazo);
        pizarra2.pintarTrazo(trazo);


        assertEquals(pizarra1, pizarra2);
    }

    @Test
    public void laPizarraNoDistingueDireccionDeLosTrazos() {
        Trazo trazo1 = new Trazo(new Posicion(0,0),new Posicion(1,0));
        Trazo trazo2 = new Trazo(new Posicion(1,0),new Posicion(0,0));
        Pizarra pizarra1 = new Pizarra();
        Pizarra pizarra2 = new Pizarra();

        pizarra1.pintarTrazo(trazo1);

        pizarra2.pintarTrazo(trazo2);

        assertEquals(pizarra1, pizarra2);
    }


}