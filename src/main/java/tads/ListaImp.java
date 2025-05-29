package tads;
import tads.*;
public class ListaImp<T> implements Lista<T> {
    private Nodo<T> inicio;
    private int cantElementos;
    private int maxElementos;

    public int getMaxElementos() {
        return maxElementos;
    }

    public ListaImp(int MAXELEMENTOS) {
        cantElementos = 0;
        maxElementos = MAXELEMENTOS;
    }
    @Override
    public void agregar(T DATO) {
        if (cantElementos < maxElementos) {
            if (esVacia()) {
                inicio = new Nodo<>(DATO);
            } else {
                Nodo<T> aux = inicio;
                while (aux.getSig() != null) {
                    aux = aux.getSig();
                }
                Nodo<T> nuevo = new Nodo<>(DATO);
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
    public boolean esVacia(){
        return cantElementos == 0;
        }
    }




//@Override
//public void agregar(T DATO) {
//    if (this.esVacia() || DATO.compareTo(inicio.getDato()) < 0) {
//        inicio = new Nodo<>(DATO, inicio);
//    } else {
//        Nodo<T> aux = inicio;
//        while (aux.getSig() != null && aux.getSig().getDato().compareTo(DATO) < 0) {
//            aux = aux.getSig();
//        }
//        Nodo<T> nuevo = new Nodo(DATO, aux.getSig());
//        aux.setSig(nuevo);
//    }
//    this.cantidadDeElementos++;
//}
