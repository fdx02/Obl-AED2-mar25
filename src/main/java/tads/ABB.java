package tads;

public interface ABB<T> {
    void insertar(T DATO);
    boolean existe(T DATO);
    String buscarPorDato(String DATO);
}
