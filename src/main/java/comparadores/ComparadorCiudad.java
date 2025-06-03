package comparadores;

import dominio.*;

import java.util.Comparator;

public class ComparadorCiudad implements Comparator<Ciudad> {
    @Override
    public int compare(Ciudad o1, Ciudad o2) {
        return o1.getCodigo().compareTo(o2.getCodigo());
    }
}
