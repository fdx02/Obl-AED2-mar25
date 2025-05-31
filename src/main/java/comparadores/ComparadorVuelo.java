package comparadores;
import dominio.*;
import java.util.Comparator;

public class ComparadorVuelo implements Comparator<Vuelo> {
    @Override
    public int compare(Vuelo o1, Vuelo o2) {
        return o1.compareTo(o2);
    }
}