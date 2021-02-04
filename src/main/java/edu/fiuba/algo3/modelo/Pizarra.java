package edu.fiuba.algo3.modelo;

import java.util.Arrays;

public class Pizarra {

    private boolean[][] pizarra;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizarra pizarra1 = (Pizarra) o;
        return Arrays.equals(pizarra, pizarra1.pizarra);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(pizarra);
    }

    public Pizarra(int dimension) {
        pizarra = new boolean[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                pizarra[i][j] = false;
            }
        }
    }

    public void pintarPosicion(Posicion posicion){
        pizarra[posicion.x()][posicion.y()] = true;
    }

    /*public void printear(){
        int dimension = 5;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(pizarra[j][i] + " ");
            }
            System.out.println();
        }
    }*/
}