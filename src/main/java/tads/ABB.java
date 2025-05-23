package tads;

import java.util.Comparator;

public interface ABB<T> {
    void insertar(T DATO);
    boolean existe(T DATO);
    String buscarPorDato(T DATO);
    int buscarPorDatoCant(T DATO);
    String listarAscendente();
    String listarDesc();
    String listarCondicion(T DATO);
    String listarNumero(T DATO, Comparator<T> COMP);
}
