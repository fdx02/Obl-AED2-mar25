package tads;

public class NodoABB<T> {
    private T dato;
    private NodoABB<T> der;
    private NodoABB<T> izq;

    public NodoABB(T DATO) {
        this.dato = DATO;
    }

    public NodoABB(T DATO, NodoABB<T> IZQ, NodoABB<T> DER) {
        this.dato = DATO;
        this.izq = IZQ;
        this.der = DER;
    }

    public T getDato() {
        return this.dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoABB<T> getDer() {
        return this.der;
    }

    public void setDer(NodoABB<T> der) {
        this.der = der;
    }

    public NodoABB<T> getIzq() {
        return this.izq;
    }

    public void setIzq(NodoABB<T> izq) {
        this.izq = izq;
    }
}
