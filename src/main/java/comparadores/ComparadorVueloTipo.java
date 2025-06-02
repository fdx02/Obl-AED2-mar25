package comparadores;
import dominio.*;
import interfaz.TipoVueloPermitido;

import java.util.Comparator;

public class ComparadorVueloTipo implements Comparator<Vuelo> {
    @Override
    public int compare(Vuelo o1, Vuelo o2) {
        if(o2.getTipoVueloPermitido() == TipoVueloPermitido.AMBOS || o1.getTipoVueloPermitido() == o2.getTipoVueloPermitido()) {
            return 0;
        }
        return 1;
    }
}