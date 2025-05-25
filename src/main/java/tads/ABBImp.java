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
        if (comp.compare(NODO.getDato(), DATO) < 0) {
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
                if (comp.compare(NODO.getDato(), DATO) < 0) {
                    return existeRec(NODO.getDer(), DATO);
                } else {
                    return existeRec(NODO.getIzq(), DATO);
                }
            }
        }
        return false;
    }


    @Override
    public String buscarPorDato(T DATO) {
        String retorno = buscarPorDatoRec(raiz, DATO);
        if (retorno.isEmpty()){
            return retorno;
        } else {
            return retorno.substring(0, retorno.length() - 1);
        }
    }

    private String buscarPorDatoRec (NodoABB<T> NODO, T DATO) {
        if (NODO != null) {;
            if (comp.compare(NODO.getDato(), DATO) == 0) {
                return NODO.getDato().toString();
            } else {
               if (comp.compare(NODO.getDato(), DATO) < 0){
                   return buscarPorDatoRec(NODO.getDer(), DATO);
               } else {
                   return buscarPorDatoRec(NODO.getIzq(), DATO);
               }
            }
        }
        return "";
    }

    @Override
    public int buscarPorDatoCant(T DATO) {
        return buscarPorDatoCantRec(raiz, DATO, 1);
    }

    private int buscarPorDatoCantRec (NodoABB<T> NODO, T DATO, int CONT) {
        if (NODO != null) {;
            if (comp.compare(NODO.getDato(), DATO) == 0) {
                return CONT;
            } else {
                if (comp.compare(NODO.getDato(), DATO) < 0){
                    return buscarPorDatoCantRec(NODO.getDer(), DATO, CONT + 1);
                } else {
                    return buscarPorDatoCantRec(NODO.getIzq(), DATO, CONT + 1);
                }
            }
        }
        return 0;
    }




    public String listarAscendente() {
        String retorno = listarAscendenteRec(this.raiz);
        if (retorno.isEmpty()){
            return retorno;
        } else {
            return retorno.substring(0, retorno.length() - 1);
        }
    }

    private String listarAscendenteRec(NodoABB<T> NODO) {
        if (NODO == null) {
            return "";
        }
        return listarAscendenteRec(NODO.getIzq()) + NODO.getDato().toString() + listarAscendenteRec(NODO.getDer());
    }

    public String listarDesc() {
        String retorno = listarDescRec(this.raiz);
        if (retorno.isEmpty()){
            return retorno;
        } else {
            return retorno.substring(0, retorno.length() - 1);
        }

    }

    private String listarDescRec(NodoABB<T> NODO) {
        if (NODO == null) {
            return "";
        }
        return listarDescRec(NODO.getDer()) + NODO.getDato().toString() + listarAscendenteRec(NODO.getIzq());
    }

    public String listarCondicion(T DATO) {
        String retorno = listarCondicionRec(this.raiz, DATO);
        if (retorno.isEmpty()){
            return retorno;
        } else {
            return retorno.substring(0, retorno.length() - 1);
        }
    }


    private String listarCondicionRec(NodoABB<T> NODO, T DATO){
        if (NODO == null){
            return "";
        }
        if (NODO.getDato().compareTo(DATO) == 0) {
            return listarCondicionRec(NODO.getIzq(), DATO) + NODO.getDato().toString() + listarCondicionRec(NODO.getDer(), DATO);
        }
        return listarCondicionRec(NODO.getIzq(), DATO) + listarCondicionRec(NODO.getDer(), DATO);
    }

    public String listarComparador(T DATO, Comparator<T> COMP) {
        Comparator<T> temp = this.comp;
        cambiarComparador(COMP);
        String retorno = listarNumeroRec(this.raiz, DATO);
        cambiarComparador(temp);
        if (retorno.isEmpty()){
            return retorno;
        } else {
            return retorno.substring(0, retorno.length() - 1);
        }
    }
    private String listarNumeroRec(NodoABB<T> NODO, T DATO){
        if (NODO == null) {
            return "";
        }
        if (comp.compare(NODO.getDato(), DATO) == 0) {
            return listarNumeroRec(NODO.getIzq(), DATO) + NODO.getDato().toString() + listarNumeroRec(NODO.getDer(), DATO);
        }
        return listarNumeroRec(NODO.getIzq(), DATO) + listarNumeroRec(NODO.getDer(), DATO);
    }

    private void cambiarComparador(Comparator<T> COMP){
        this.comp = COMP;
    }



//    class retornoPer {
//        public int conteo;
//        public String dato;
//        retornoPer(int conteo, String dato) {
//            this.conteo = conteo;
//            this.dato = dato;
//        }
//    }

}