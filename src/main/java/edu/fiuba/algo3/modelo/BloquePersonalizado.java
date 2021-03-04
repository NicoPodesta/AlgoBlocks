package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.Observer;

public class BloquePersonalizado extends ConjuntoBloques{

    private String nombre;
    private ConjuntoBloques algoritmo;

    public BloquePersonalizado(String nombre) {
        this.nombre = nombre;
        this.algoritmo = new ConjuntoBloques();
    }

    public void agregarAlgoritmo(ConjuntoBloques algoritmoNuevo) throws AlgoritmoVacioException{
        if (algoritmoNuevo.estaVacio()){
            throw new AlgoritmoVacioException();
        }
        algoritmoNuevo.clonar(algoritmo);
    }

    public String obtenerNombre() {
        return nombre;
    }

    public void agregarObserver(Observer observer){
        algoritmo.addObserver(observer);
    }

    public ConjuntoBloques obtenerAlgoritmo(){
        return algoritmo;
    }

    public Pizarra ejecutar(Personaje personaje){
        return algoritmo.ejecutar(personaje);
    }
}