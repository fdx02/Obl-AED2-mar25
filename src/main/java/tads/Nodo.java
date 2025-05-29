package tads;

public class Nodo<T> {

    private T dato;
    private Nodo<T> sig;

    public Nodo(T dato){
        this.dato = dato;
        this.sig = null;
    }

    public Nodo(T DATO, Nodo SIG){
        this.dato = DATO;
        this.sig = SIG;
    }
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSig() {
        return sig;
    }

    public void setSig(Nodo<T> sig) {
        this.sig = sig;
    }

}