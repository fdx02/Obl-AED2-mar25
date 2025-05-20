package tads;


import java.util.Comparator;

public class ABBImp<T extends Comparable<T>> implements ABB<T> {
    public NodoABB<T> raiz;
    private Comparator<T> comp;

    public ABBImp(Comparator<T> comp) {
        this.comp = comp;
    }

    public void insertar(T DATO) {
        if (this.raiz == null) {
            this.raiz = new NodoABB(DATO);
        } else {
            this.insertarRec(this.raiz, DATO);
        }

    }

    private void insertarRec(NodoABB<T> NODO, T DATO) {
        if (comp.compare(NODO.getDato(), DATO) > 0) { //if (DATO.compareTo(NODO.getDato()) > 0) {
            if (NODO.getDer() == null) {
                NODO.setDer(new NodoABB(DATO));
            } else {
                this.insertarRec(NODO.getDer(), DATO);
            }
        } else if (NODO.getIzq() == null) {
            NODO.setIzq(new NodoABB(DATO));
        } else {
            this.insertarRec(NODO.getIzq(), DATO);
        }

    }

    @Override
    public boolean existe(T DATO) {
        return existeRec(raiz, DATO);
    }
    private boolean existeRec(NodoABB<T> NODO, T DATO) {
        if (NODO != null) {
            if (comp.compare(NODO.getDato(), DATO) == 0) {
                return true;
            } else {
                if (comp.compare(NODO.getDato(), DATO) > 0) {
                    return existeRec(NODO.getDer(), DATO);
                } else {
                    return existeRec(NODO.getIzq(), DATO);
                }
            }
        }
        return false;
    }

    @Override
    public String buscarPorDato(String DATO) {
        return null;
    }

    private retornoPer buscarPorDatoRec (NodoABB<T> NODO, String DATO, int conteo) {
        if (NODO != null) {;
            if (NODO.getDato().equals(DATO)) {
                return new retornoPer(conteo, NODO.getDato().toString());
            } else {
               // if (comp.compare(NODO.getDato(), DATO)) // incompleto
            }
        }
        return null;
    }

    public void listarAscendente() {
        this.listarAscendenteRec(this.raiz);
    }

    private void listarAscendenteRec(NodoABB<T> NODO) {
        if (NODO != null) {
            this.listarAscendenteRec(NODO.getIzq());
            System.out.println((NODO.getDato()).toString());
            this.listarAscendenteRec(NODO.getDer());
        }

    }


    class retornoPer {
        public int conteo;
        public String dato;
        retornoPer(int conteo, String dato) {
            this.conteo = conteo;
            this.dato = dato;
        }
    }

}