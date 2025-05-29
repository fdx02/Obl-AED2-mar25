package comparadores;

import dominio.Viajero;

import java.util.Comparator;

public class ComparadorViajeroEdad implements Comparator<Viajero> {
    @Override
    public int compare(Viajero o1, Viajero o2) {
        return o1.getEdad() - o2.getEdad();
    }
}
