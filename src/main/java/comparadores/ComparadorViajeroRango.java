package comparadores;

import dominio.Viajero;

import java.util.Comparator;

public class ComparadorViajeroRango implements Comparator<Viajero> {
    @Override
    public int compare(Viajero VIAJERO, Viajero RANGO) {
        //borrar si no uso
        if (VIAJERO.getEdad() / 10 == RANGO.getEdad()){
            return 0;
        } else if (VIAJERO.getEdad() / 10 < RANGO.getEdad()){
            return -1;
        } else {
            return 1;
        }
    }
}