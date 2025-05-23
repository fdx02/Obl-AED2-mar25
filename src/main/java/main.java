import comparadores.ComparadorViajeroCedula;
import comparadores.ComparadorViajeroMail;
import comparadores.ComparadorViajeroRango;
import dominio.Viajero;
import interfaz.*;
import jdk.jfr.Category;
import tads.ABBImp;

public class main {
    public static void main(String[] args) {
        ABBImp<Viajero> arbol = new ABBImp(new ComparadorViajeroCedula());
        Viajero v1 = new Viajero("56172803", "Rondro", "choice@gmail.com", 1, Categoria.PLATINO);
        Viajero v2 = new Viajero("53464577", "JuanMartin241", "pantera@gmail.com", 15, Categoria.FRECUENTE);
        Viajero v3 = new Viajero("37489274", "hexe", "santuario@gmail.com", 43, Categoria.PLATINO);
        Viajero v4 = new Viajero("12364365", "calpheon", "choice@gmail.com", 32, Categoria.ESTANDAR);
        Viajero v5 = new Viajero("48934879", "Rondro", "tumbadeestrella@gmail.com", 87, Categoria.PLATINO);
        Viajero v6 = new Viajero("90423849", "Carrusel", "gyfin@gmail.com", 99, Categoria.PLATINO);
        Viajero v7 = new Viajero("99594873", "madozito", "asdsd@gmail.com", 6, Categoria.ESTANDAR);
        Viajero v8 = new Viajero("54982379");
        Viajero v9 = new Viajero("choicedosa@gmail.com", 0);
        arbol.insertar(v1);
        arbol.insertar(v2);
        arbol.insertar(v3);
        arbol.insertar(v4);
        arbol.insertar(v5);
        arbol.insertar(v6);
        arbol.insertar(v7);
        System.out.println(arbol.listarNumero(new Viajero(3), new ComparadorViajeroRango()));
        System.out.println("------------------------------");
//      arbol.listarDesc();
//      System.out.println(arbol.existe(v9));
//        System.out.println("------------------------------");
//        System.out.println("Viajero: " + arbol.buscarPorDato(new Viajero("99594873")));
//        System.out.println("Cantidad recorrida: " + arbol.buscarPorDatoCant(new Viajero("99594873")));


//        int numero = 1205;
//        String numeroString = Integer.toString(numero);
//        String texto = numeroString + "ffadasdd";
//        System.out.println(texto);
//        System.out.println(texto.substring(0, numeroString.length()));
    }
}

