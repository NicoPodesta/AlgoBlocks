package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoritmoVacioException;
import edu.fiuba.algo3.modelo.ConjuntoBloques;

public class VistaAlgoritmo implements Observer{

    private ConjuntoBloques algoritmo;
    private ContenedorPrincipal contenedor;

    public VistaAlgoritmo(ConjuntoBloques algoritmo, ContenedorPrincipal contenedor){
        this.algoritmo = algoritmo;
        this.contenedor = contenedor;
    }

    public void update(){
        try {
            this.contenedor.agregarNombreBloque(this.algoritmo.obtenerUltimoBloque());
        } catch (AlgoritmoVacioException o){}
    }
}
