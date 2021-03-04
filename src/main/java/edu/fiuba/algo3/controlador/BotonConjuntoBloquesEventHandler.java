package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;

import java.util.ArrayList;

public abstract class BotonConjuntoBloquesEventHandler extends BotonBloqueEventHandler {

    protected final BloquePersonalizado bloquePersonalizado;

    public BotonConjuntoBloquesEventHandler(ConjuntoBloques algoritmo,
                                            BloquePersonalizado bloquePersonalizado) {
        super(algoritmo);
        this.bloquePersonalizado = bloquePersonalizado;
    }
}