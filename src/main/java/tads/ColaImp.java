package tads;

public class ColaImp<T extends Comparable<T>> implements Cola<T> {

    private Nodo<T> frente;
    private Nodo<T> finalCola;
    private int cantidadElementos;

    public ColaImp() {
        this.frente = null;
        this.finalCola = null;
        this.cantidadElementos = 0;
    }

    @Override
    public void encolar(T DATO) {
        Nodo<T> nuevoNodo = new Nodo<>(DATO);
        if (esVacia()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.setSig(nuevoNodo);
            finalCola = nuevoNodo;
        }
        cantidadElementos++;
    }

    @Override
    public T desencolar() {
        T aux = this.frente.getDato();
        frente = this.frente.getSig();
        this.cantidadElementos--;
        if (this.frente == null) {
            finalCola = null;
        }
        return aux;
    }

    @Override
    public boolean esVacia() {
        return cantidadElementos == 0;
    }

    @Override
    public int cantElementos() {
        return cantidadElementos;
    }

    @Override
    public T frente() {
        return frente.getDato();
    }

}
