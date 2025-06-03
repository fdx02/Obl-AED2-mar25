package tads;

public interface Cola<T> {
    void encolar(T DATO);
    T desencolar();
    public boolean esVacia();
    public int cantElementos();
    public T frente();
}
