import dominio.Viajero;
import interfaz.Categoria;
import tads.ABBImp;

public class main {
    public static void main(String[] args) {
        ABBImp<Viajero> arbol = new ABBImp();
        Viajero v1 = new Viajero("56172803", "Rondro", "choice@gmail.com", 30, Categoria.PLATINO);
        Viajero v2 = new Viajero("53464577", "JuanMartin241", "pantera@gmail.com", 15, Categoria.FRECUENTE);
        Viajero v3 = new Viajero("37489274", "hexe", "santuario@gmail.com", 43, Categoria.PLATINO);
        Viajero v4 = new Viajero("12364365", "calpheon", "choice@gmail.com", 30, Categoria.ESTANDAR);
        Viajero v5 = new Viajero("48934879", "Rondro", "choice@gmail.com", 31, Categoria.PLATINO);
        Viajero v6 = new Viajero("90423849", "Carrusel", "choice@gmail.com", 31, Categoria.PLATINO);
        arbol.insertar(v1);
        arbol.insertar(v2);
        arbol.insertar(v3);
        arbol.insertar(v4);
        arbol.insertar(v5);
        arbol.listarAscendente();
    }
}

