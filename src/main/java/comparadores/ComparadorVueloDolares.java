package comparadores;
import dominio.*;
import java.util.Comparator;

public class ComparadorVueloDolares implements Comparator<Vuelo> {
    @Override
    public int compare(Vuelo o1, Vuelo o2) {
        return Double.compare(o1.getCostoEnDolares(), o2.getCostoEnDolares());
    }
}