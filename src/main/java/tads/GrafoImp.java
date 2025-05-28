package tads;

import dominio.*;

public class GrafoImp implements Grafo{
    private Ciudad[] ciudades;
    private Vuelo[][] vuelos;
    private int maxCiudades;
    private int cantidad;

    public GrafoImp(int maxCiudades) {
        this.maxCiudades = maxCiudades;
        this.ciudades = new Ciudad[maxCiudades];
        this.vuelos = new Vuelo[maxCiudades][maxCiudades];
        this.cantidad = 0;
    }

    @Override
    public void registrarCiudad(String codigo, String nombre) {

    }
}
