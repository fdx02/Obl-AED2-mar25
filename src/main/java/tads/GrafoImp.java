package tads;

import comparadores.ComparadorCiudad;
import dominio.*;
import interfaz.TipoVueloPermitido;

import javax.swing.*;

public class GrafoImp{
    private Ciudad[] ciudades;
    private Conexion[][] conexiones;
    private int maxCiudades;
    private int cantidad;
    private boolean dirigido;

    public GrafoImp(int maxCiudades, boolean dirigido) {
        this.maxCiudades = maxCiudades;
        this.ciudades = new Ciudad[maxCiudades];
        this.conexiones = new Conexion[maxCiudades][maxCiudades];
        this.cantidad = 0;
        this.dirigido = dirigido;

        if(dirigido){
            for (int i = 0; i < conexiones.length; i++) {
                for (int j = 0; j < conexiones.length; j++) {
                    conexiones[i][j] = new Conexion();
                }
            }
        } else {
            for (int i = 0; i < conexiones.length; i++) {
                for (int j = i; j < conexiones.length; j++) {
                    Conexion conexion = new Conexion();
                    conexiones[i][j] = conexion;
                    conexiones[j][i] = conexion;
                }
            }
        }



        //agregar el chequeo de null (crear conexiones vacias en la matriz)
        //agregar to do lo de arista existe
    }

    public void registrarCiudad(String codigo, String nombre) {
        if (cantidad < maxCiudades) {
            int posLibre = obtenerPosLibre();
            ciudades[posLibre] = new Ciudad(codigo, nombre);
            cantidad++;
        }
    }

    public void registrarConexion(Conexion conexion) {
        int posOrigen = obtenerPos(conexion.getCodigoCiudadOrigen());
        int posDestino = obtenerPos(conexion.getCodigoCiudadDestino());
        conexiones[posOrigen][posDestino] = conexion;
        Conexion aux = conexiones[posOrigen][posDestino];
        aux.setExiste(true);
    }

    public void borrarCiudad(String codigoCiudad) {
        int pos = obtenerPos(codigoCiudad);
        ciudades[pos] = null;
        cantidad--;
        for (int i = 0; i < conexiones.length; i++) {
            conexiones[i][pos] = null; // adyacentes
            conexiones[pos][i] = null; // incidentes
        }
    }

    public void borrarConexion(Conexion conexion) {
        int posOrigen = obtenerPos(conexion.getCodigoCiudadOrigen());
        int posDestino = obtenerPos(conexion.getCodigoCiudadDestino());
        conexiones[posOrigen][posDestino].setExiste(false);
    }

    public Conexion obtenerConexion(Conexion conexion) {
        int posOrigen = obtenerPos(conexion.getCodigoCiudadOrigen());
        int posDestino = obtenerPos(conexion.getCodigoCiudadDestino());
        return conexiones[posOrigen][posDestino];
    }

    public void registrarVuelo(Vuelo VUELO) {
        int posOrigen = obtenerPos(VUELO.getCodigoCiudadOrigen());
        int posDestino = obtenerPos(VUELO.getCodigoCiudadDestino());
        if (conexiones[posOrigen][posDestino].isExiste()) {
            conexiones[posOrigen][posDestino].agregarVuelo(VUELO);
        }
    }

    public void actualizarVuelo(Vuelo VUELO){
        int posOrigen = obtenerPos(VUELO.getCodigoCiudadOrigen());
        int posDestino = obtenerPos(VUELO.getCodigoCiudadDestino());
        if (conexiones[posOrigen][posDestino].isExiste()) {
            conexiones[posOrigen][posDestino].actualizarVuelo(VUELO);
        }
    }


    public int obtenerPosLibre() {
        for (int i = 0; i < ciudades.length; i++) {
            if (ciudades[i] == null) {
                return i;
            }
        }
        return -1;
    }



    public boolean esLleno(){
        return cantidad == maxCiudades;
    }
    public boolean esVacia(){
        return cantidad == 0;
    }

    //chequear
    public int obtenerPos(String codigoCiudad) {
        for (int i = 0; i < ciudades.length; i++) {
            if (ciudades[i] != null && ciudades[i].getCodigo().equals(codigoCiudad)) {
                return i;
            }
        }
        return -1;
    }
    public boolean existe(String CODIGO){
        int pos = obtenerPos(CODIGO);
        if (esVacia() || pos == -1) {
            return false;
        }
        for (int i = 0; i < ciudades.length; i++) {
            if (ciudades[i].equals(ciudades[pos])) {
                return true;
            }
        }
        return false;
    }

    public boolean existeConexion(String ORIGEN, String DESTINO){
        int posOrigen = obtenerPos(ORIGEN);
        int posDestino = obtenerPos(DESTINO);
        if (posOrigen == -1 || posDestino == -1) {
            return false;
        }
        return conexiones[posOrigen][posDestino].isExiste() || conexiones[posDestino][posOrigen].isExiste();
    }

    public boolean existeVuelo(Conexion CONEXION, String CODIGOVUELO){
        Conexion con = obtenerConexion(CONEXION);
        return con.existeVuelo(CODIGOVUELO);
    }

    public String cantEscalas(int ESCALA, String ORIGEN) {
        int posOrigen = obtenerPos(ORIGEN);
        boolean[] visitados = new boolean[maxCiudades];
        ABB<Ciudad> ret = new ABBImp<Ciudad>(new ComparadorCiudad());

        Cola<Integer> cola = new ColaImp<Integer>();//cola general
        Cola<Integer> colaNivel = new ColaImp<Integer>();//cola de Nivel

        visitados[posOrigen] = true;
        cola.encolar(posOrigen);
        int nivel= 0;
        while (!cola.esVacia() && nivel <= ESCALA) {
            int pos = cola.desencolar();
            ret.insertar(ciudades[pos]);
            for (int i = 0; i < conexiones.length; i++) {
                if (conexiones[pos][i].isExiste() && !visitados[i] && conexiones[pos][i].tieneVuelos()) {
                    visitados[i] = true;
                    colaNivel.encolar(i);
                }
            }
            if (cola.esVacia()) {
                cola = colaNivel;
                colaNivel = new ColaImp<Integer>();
                nivel++;
            }
        }
        return ret.listarAscendente();
    }

    public String dijkstraConDestino(String origen, String destino, int indice, TipoVueloPermitido tipo) {
        boolean[] visitados = new boolean[maxCiudades];
        double[] costos = new double[maxCiudades];
        int[] anterior = new int[maxCiudades];

        for (int i = 0; i < visitados.length; i++) {
            costos[i] = Integer.MAX_VALUE;
            anterior[i] = -1;
        }

        int posOrigen = obtenerPos(origen);
        int posDestino = obtenerPos(destino);

        costos[posOrigen] = 0;

        for (int v = 0; v < cantidad; v++) {
            int pos = ciudadNoVisitadaMenorCosto(costos, visitados);

            if (pos != -1) {
                visitados[pos] = true;

                for (int i = 0; i < maxCiudades; i++) {
                    if (conexiones[pos][i].isExiste() && !visitados[i]) {
                        double costoNuevo = costos[pos] + conexiones[pos][i].getPesoMinimo(indice, tipo);
                        if (costoNuevo < costos[i]) {
                            costos[i] = costoNuevo;
                            anterior[i] = pos;
                        }
                    }
                }
            }
        }
        if (costos[posDestino] == Integer.MAX_VALUE){
            return null;
        }
        double costo = costos[posDestino];
        String camino = "";
        int posAux = posDestino;
        while (posAux != -1) {
            camino = ciudades[posAux].toString() + camino;
            posAux = anterior[posAux];
        }

        if(camino.isEmpty()){
            return camino;
        } else {
            return camino.substring(0, camino.length() -1);
        }
    }

    public double dijkstraConDestinoInt(String origen, String destino, int indice, TipoVueloPermitido tipo) {
        boolean[] visitados = new boolean[maxCiudades];
        double[] costos = new double[maxCiudades];
        int[] anterior = new int[maxCiudades];

        for (int i = 0; i < visitados.length; i++) {
            costos[i] = Integer.MAX_VALUE;
            anterior[i] = -1;
        }

        int posOrigen = obtenerPos(origen);
        int posDestino = obtenerPos(destino);

        costos[posOrigen] = 0;

        for (int v = 0; v < cantidad; v++) {
            int pos = ciudadNoVisitadaMenorCosto(costos, visitados);

            if (pos != -1) {
                visitados[pos] = true;

                for (int i = 0; i < maxCiudades; i++) {
                    if (conexiones[pos][i].isExiste() && !visitados[i]) {
                        double costoNuevo = costos[pos] + conexiones[pos][i].getPesoMinimo(indice, tipo);
                        if (costoNuevo < costos[i]) {
                            costos[i] = costoNuevo;
                            anterior[i] = pos;
                        }
                    }
                }
            }
        }

        double costo = costos[posDestino];
        if (costos[posDestino] == Integer.MAX_VALUE){
            return -1;
        }
        return costos[posDestino];
    }

    private int ciudadNoVisitadaMenorCosto(double[] costos, boolean[] visitados) {
        int posMin = -1;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < maxCiudades; i++) {
            if (!visitados[i] && costos[i] < min) {
                min = costos[i];
                posMin = i;
            }
        }
        return posMin;
    }



//    public String cantEscalas(int ESCALA, String ORIGEN){
//        String retorno = "";
//        int nivel= 0;
//        boolean[] visitados = new boolean[maxCiudades];
//        int posOrigen = obtenerPos(ORIGEN);
//        ABB<Ciudad> ret = new ABBImp<Ciudad>(new ComparadorCiudad());
//
//
//        Cola<Integer> cola = new ColaImp<Integer>();
//        visitados[posOrigen] = true;
//        cola.encolar(posOrigen);
//        cola.encolar(-5);
//
//        while (!cola.esVacia() && nivel <= ESCALA) {
//            //manejo el nivel actual
//            int pos = cola.desencolar();
//            if (pos == -5 && !cola.esVacia()){
//                cola.encolar(-5);
//                nivel++;
//            }
//            //hago algo
//            ret.insertar(ciudades[pos]);
//            for (int i = 0; i < conexiones.length; i++) {
//                if (conexiones[pos][i].isExiste() && !visitados[i]) {
//                    visitados[i] = true;
//                    cola.encolar(i);
//                }
//            }
//        }
//
//        if (retorno.isEmpty()){
//            return retorno;
//        } else {
//            return retorno.substring(0, retorno.length() - 1);
//        }
//
//    }
}
