package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;

import java.util.ArrayList;

public abstract class BotonConjuntoBloquesEventHandler extends BotonBloqueEventHandler {

    protected final ArrayList<BloquePersonalizado> bloquesPersonalizados;

    public BotonConjuntoBloquesEventHandler(ConjuntoBloques algoritmo,
                                            ArrayList<BloquePersonalizado> bloquesPersonalizados) {
        super(algoritmo);
        this.bloquesPersonalizados = bloquesPersonalizados;
    }
}