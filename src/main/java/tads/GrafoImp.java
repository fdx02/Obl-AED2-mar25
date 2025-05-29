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


    public int obtenerPosLibre() {
        for (int i = 0; i < ciudades.length; i++) {
            if (ciudades[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public int obtenerPos(String codigoCiudad) {
        for (int i = 0; i < ciudades.length; i++) {
            if (ciudades[i].getCodigo().equals(codigoCiudad)) {
                return i;
            }
        }
        return -1;
    }

    public boolean esLleno(){
        return cantidad == maxCiudades;
    }
}
