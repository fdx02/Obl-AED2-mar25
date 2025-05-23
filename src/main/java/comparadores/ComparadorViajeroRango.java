package comparadores;

import dominio.Viajero;

import java.util.Comparator;

public class ComparadorViajeroRango implements Comparator<Viajero> {
    @Override
    public int compare(Viajero VIAJERO, Viajero RANGO) {
        if (RANGO.getEdad() == 0 && VIAJERO.getEdad() >= 0 && VIAJERO.getEdad() <= 9){
            return 0;
        }
        if (RANGO.getEdad() == 1 && VIAJERO.getEdad() >= 10 && VIAJERO.getEdad() <= 19){
            return 0;
        }
        if (RANGO.getEdad() == 2 && VIAJERO.getEdad() >= 20 && VIAJERO.getEdad() <= 29){
            return 0;
        }
        if (RANGO.getEdad() == 3 && VIAJERO.getEdad() >= 30 && VIAJERO.getEdad() <= 39){
            return 0;
        }
        if (RANGO.getEdad() == 4 && VIAJERO.getEdad() >= 40 && VIAJERO.getEdad() <= 49){
            return 0;
        }
        if (RANGO.getEdad() == 5 && VIAJERO.getEdad() >= 50 && VIAJERO.getEdad() <= 59){
            return 0;
        }
        if (RANGO.getEdad() == 6 && VIAJERO.getEdad() >= 60 && VIAJERO.getEdad() <= 69){
            return 0;
        }
        if (RANGO.getEdad() == 7 && VIAJERO.getEdad() >= 70 && VIAJERO.getEdad() <= 79){
            return 0;
        }
        if (RANGO.getEdad() == 8 && VIAJERO.getEdad() >= 80 && VIAJERO.getEdad() <= 89){
            return 0;
        }
        if (RANGO.getEdad() == 9 && VIAJERO.getEdad() >= 90 && VIAJERO.getEdad() <= 99){
            return 0;
        }
        if (RANGO.getEdad() == 10 && VIAJERO.getEdad() >= 100 && VIAJERO.getEdad() <= 109){
            return 0;
        }
        if (RANGO.getEdad() == 11 && VIAJERO.getEdad() >= 110 && VIAJERO.getEdad() <= 119){
            return 0;
        }
        if (RANGO.getEdad() == 12 && VIAJERO.getEdad() >= 120 && VIAJERO.getEdad() <= 129){
            return 0;
        }
        if (RANGO.getEdad() == 13 && VIAJERO.getEdad() >= 130 && VIAJERO.getEdad() <= 139){
            return 0;
        }
        return 1;
    }
}