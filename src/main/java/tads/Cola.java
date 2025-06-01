package tads;

public interface Cola<T> {

    //Inserta el elemento al final de la cola
    void encolar(T DATO);
    //Elimina el primer elemento (frente) de la cola
    T desencolar();
    //Indica si la cola esta vacía
    public boolean esVacia();
    //Indica si la cola esta llena
    //public boolean esllena();
    //Retorna la cantidad de elementos
    public int cantElementos();
    //Retorna el primer elemento de la cola (al frente)
    public T frente();
}
