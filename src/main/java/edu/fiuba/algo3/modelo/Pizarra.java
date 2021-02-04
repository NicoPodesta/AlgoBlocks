package edu.fiuba.algo3.modelo;

public class Pizarra {

    private static final int LARGO = 10 ;
    private boolean[][] pizarra = new boolean[LARGO][LARGO];

    public Pizarra() {
        for (int i = 0; i < LARGO; i++) {
            for (int j = 0; j < LARGO; j++) {
                pizarra[i][j] = false;
            }
        }
    }

    public void pintarPosicion(Posicion posicion){
        pizarra[posicion.x()][posicion.y()] = true;
    }

}