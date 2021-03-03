package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Pizarra;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Trazo;

public class VistaPizarra implements Observer {

    private Pizarra pizarra;
    private Dibujador dibujador;

    public VistaPizarra(Pizarra pizarra, Dibujador dibujador){
        this.pizarra = pizarra;
        this.dibujador = dibujador;
    }

    public void realizarMovimiento(Posicion anterior, Posicion actual){
        if(actual.getY() > anterior.getY()){
            this.dibujador.dibujarAbajo();
        }
        else if (actual.getY() < anterior.getY()){
            this.dibujador.dibujarArriba();
        }
        else if (actual.getX() > anterior.getX()){
            this.dibujador.dibujarDerecha();
        }
        else if (actual.getX() < anterior.getX()){
            this.dibujador.dibujarIzquierda();
        }
    }

    @Override
    public void update() {
        for ( Trazo trazo : this.pizarra.obtenerTrazos() ) {
            Posicion anterior = trazo.getPosicionA();
            Posicion actual = trazo.getPosicionB();
            this.realizarMovimiento(anterior, actual);
        }
    }
}
