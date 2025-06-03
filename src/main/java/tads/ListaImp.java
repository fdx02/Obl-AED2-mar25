package tads;
import tads.*;

import java.util.Comparator;

public class ListaImp<T> implements Lista<T> {
    private Nodo<T> inicio;
    private Comparator<T> comp;
    private int cantElementos;
    private final int maxElementos;


    public ListaImp(Comparator<T> COMP, int MAXELEMENTOS) {
        this.cantElementos = 0;
        this.maxElementos = MAXELEMENTOS;
        this.comp = COMP;
    }
    public ListaImp(int MAXELEMENTOS) {
        this.cantElementos = 0;
        this.maxElementos = MAXELEMENTOS;
    }

    @Override
    public T getInicio() {
        return inicio.getDato();
    }

    @Override
    public void agregar(T DATO) {
        if (cantElementos < maxElementos) {
            Nodo<T> nuevo = new Nodo(DATO);
            if (esVacia() || comp.compare(inicio.getDato(), DATO) > 0) {
                nuevo.setSig(inicio);
                inicio = nuevo;
            } else {
                Nodo<T> aux = inicio;
                while (aux.getSig() != null && comp.compare(aux.getSig().getDato(), DATO) > 0) {
                    aux = aux.getSig();
                }
                nuevo.setSig(aux.getSig());
                aux.setSig(nuevo);
            }
            cantElementos++;
        }
    }
    @Override
    public void agregarDesordenado(T DATO) {
        if (cantElementos < maxElementos) {
            Nodo<T> nuevo = new Nodo(DATO);
            if (esVacia()) {
                inicio = nuevo;
            } else {
                Nodo<T> aux = inicio;
                while (aux.getSig() != null) {
                    aux = aux.getSig();
                }
                aux.setSig(nuevo);
            }
            cantElementos++;
        }
    }

    @Override
    public T obtener(int INDICE) {
        Nodo<T> aux = inicio;
        int cont = 0;
        while (cont < INDICE){
            cont ++;
            aux = aux.getSig();
        }
        return aux.getDato();
    }

    @Override
    public T obtener(T DATO) {
        Nodo<T> aux = inicio;
        int cont = 0;
        while (comp.compare(DATO, aux.getDato()) != 0){
            cont ++;
            aux = aux.getSig();
        }
        return aux.getDato();
    }

    @Override
    public boolean existe(T DATO) {
        if (!esVacia()){
            Nodo<T> aux = inicio;
            if (comp.compare(DATO, aux.getDato()) == 0){
                return true;
            }
            while (aux.getSig() != null) {
                if (comp.compare(DATO, aux.getDato()) == 0){
                    return true;
                }
                aux = aux.getSig();
            }
        }
        return false;
    }

    @Override
    public T obtenerCondicion(T DATO, Comparator<T> COMP) {
        Comparator<T> temp = comp;
        cambiarComparador(COMP);
        T aux = obtenerCondicionRec(inicio, DATO);
        cambiarComparador(temp);
        return aux;
    }

    private T obtenerCondicionRec(Nodo<T> NODO, T DATO) {
        if (comp.compare(NODO.getDato(), DATO) == 0) {
            return NODO.getDato();
        }
        if (NODO.getSig() != null) {
            if (comp.compare(NODO.getDato(), DATO) == 0) {
                return NODO.getDato();
            } else {
                return obtenerCondicionRec(NODO.getSig(), DATO);
            }
        }
        return null;
    }

    @Override
    public boolean esVacia(){
        return cantElementos == 0;
    }

    private void cambiarComparador(Comparator<T> comp){
        this.comp = comp;
    }


    public int getMaxElementos() {
        return maxElementos;
    }
}





