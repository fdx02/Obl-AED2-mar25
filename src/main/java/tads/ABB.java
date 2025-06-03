package tads;

import dominio.Viajero;

import java.util.Comparator;

public interface ABB<T> {
    void insertar(T DATO);
    boolean existe(T DATO);
    String buscarPorDato(T DATO);
    T obtener(T DATO);
    int buscarPorDatoCant(T DATO);
    String listarAscendente();
    String listarDesc();
    String listarCondicion(T DATO, Comparator<T> COMP);
    boolean esVacio();
    T getMenor(Comparator<T> COMP, T DATO);


    //String listarComparador(T DATO, Comparator<T> COMP);
}
