package edu.fiuba.algo3.vista;

public interface VistaLapiz {

    int n = 10; //Numero de posibles segmentos
    int TAM_LINEA = 51; //Tamaño de cada linea

    void dibujarArriba();
    void dibujarAbajo();
    void dibujarDerecha();
    void dibujarIzquierda();
    void actualizarXeYPrevios();
}