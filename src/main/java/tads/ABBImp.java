package tads;

public class ABBImp<T extends Comparable<T>> implements ABB<T> {
    public NodoABB<T> raiz;

    public ABBImp() {
    }

    public void insertar(T DATO) {
        if (this.raiz == null) {
            this.raiz = new NodoABB(DATO);
        } else {
            this.insertarRec(this.raiz, DATO);
        }

    }

    @Override
    public boolean existe(T DATO) {
        //implementar
        return true;
    }

    private void insertarRec(NodoABB<T> NODO, T DATO) {
        if (DATO.compareTo(NODO.getDato()) > 0) {
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
}