package tads;

public interface Lista<T> {
    void agregar(T DATO);

    void eliminar(T DATO);

    T obtener(int INDICE);

    T obtener(T DATO);

    boolean existe(T DATO);

    int largo();

    void vaciar();

    boolean esVacia();

    String listar();
}
