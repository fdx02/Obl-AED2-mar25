package comparadores;

import dominio.Viajero;

import java.util.Comparator;

public class ComparadorViajeroCedula implements Comparator<Viajero> {
    @Override
    public int compare(Viajero o1, Viajero o2) {
        return o1.getCedula().compareTo(o2.getCedula());
    }
}
