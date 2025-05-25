package comparadores;

import dominio.Viajero;

import java.util.Comparator;

public class ComparadorViajeroCedula implements Comparator<Viajero> {
    @Override
    public int compare(Viajero o1, Viajero o2) {
        int cedula1 = Integer.valueOf(o1.getCedula().replaceAll("\\D", ""));
        int cedula2 = Integer.valueOf(o2.getCedula().replaceAll("\\D", ""));
        return cedula1 - cedula2;
    }
}
