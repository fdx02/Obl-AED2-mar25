package tads;

public interface ABB<T> {
    void insertar(T DATO);
    boolean existe(T DATO);
    String buscarPorDato(T DATO);
    int buscarPorDatoCant(T DATO);
    String listarAscendente();
    String listarDesc();
}
