package tads;
import java.util.Comparator;


public interface Lista<T> {
    void agregar(T DATO);
    void agregarDesordenado(T DATO);
    int getMaxElementos();

    T obtener(int INDICE);

    T obtener(T DATO);

    boolean existe(T DATO);

    T obtenerCondicion(T DATO, Comparator<T> COMP);
    T getInicio();
    boolean esVacia();

    //String listar();
}
