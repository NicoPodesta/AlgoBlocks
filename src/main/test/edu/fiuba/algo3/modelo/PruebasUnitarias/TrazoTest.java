package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Trazo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrazoTest {

    @Test
    public void losTrazoSeComparanCorrectamente() {
        Posicion coordenadas1 = new Posicion(0,0);
        Posicion coordenadas2 = new Posicion(0,1);
        Trazo trazo1 = new Trazo(coordenadas1,coordenadas2);
        Trazo trazo2 = new Trazo(coordenadas1,coordenadas2);
        assertEquals(trazo1,trazo2);
    }

    @Test
    public void losTrazoSeComparanCorrectamenteNoImportaSuDireccion() {
        Posicion coordenadas1 = new Posicion(0,0);
        Posicion coordenadas2 = new Posicion(0,1);
        Trazo trazo1 = new Trazo(coordenadas1,coordenadas2);
        Trazo trazo2 = new Trazo(coordenadas2,coordenadas1);
        assertEquals(trazo1,trazo2);
    }

}