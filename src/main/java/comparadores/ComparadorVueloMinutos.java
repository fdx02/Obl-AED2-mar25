package comparadores;
import dominio.*;
import java.util.Comparator;

public class ComparadorVueloMinutos implements Comparator<Vuelo> {
    @Override
    public int compare(Vuelo o1, Vuelo o2) {
        return Double.compare(o1.getMinutos(), o2.getMinutos());
    }
}