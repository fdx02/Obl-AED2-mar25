package tads;

import dominio.*;

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

//    public boolean existe(String codigoCiudad){
//        boolean[] visitados = new boolean[maxCiudades];
//        int posV = obtenerPos(codigoCiudad);
//        return existeRec(posV,visitados,codigoCiudad);
//    }
//
//    private boolean existeRec(int POS, boolean[] visitados, String codigoCiudad){
//        if (ciudades[POS].getCodigo().equals(codigoCiudad)) {
//            return true;
//        }
//        visitados[POS] = true;
//        for (int i = 0; i < conexiones.length; i++) {
//            if (conexiones[POS][i].isExiste() && !visitados[i]){
//                existeRec(i,visitados,codigoCiudad);
//            }
//        }
//        return false;
//    }
}
