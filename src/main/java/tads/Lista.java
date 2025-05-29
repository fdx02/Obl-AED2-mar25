package tads;

public interface Lista<T> {
    void agregar(T DATO);

    T obtener(int INDICE);

    boolean esVacia();

    //String listar();
}
