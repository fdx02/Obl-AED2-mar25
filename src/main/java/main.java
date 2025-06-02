import comparadores.*;
import dominio.Viajero;
import interfaz.*;
import jdk.jfr.Category;
import tads.ABBImp;

public class main {
    public static void main(String[] args) {
//        ABBImp<Viajero> arbol = new ABBImp(new ComparadorViajeroCedula());
//        Viajero v1 = new Viajero("56172803", "Rondro", "choice@gmail.com", 1, Categoria.PLATINO);
//        Viajero v2 = new Viajero("53464577", "JuanMartin241", "pantera@gmail.com", 15, Categoria.FRECUENTE);
//        Viajero v3 = new Viajero("37489274", "hexe", "santuario@gmail.com", 43, Categoria.PLATINO);
//        Viajero v4 = new Viajero("12364365", "calpheon", "choice@gmail.com", 32, Categoria.ESTANDAR);
//        Viajero v5 = new Viajero("48934879", "Rondro", "tumbadeestrella@gmail.com", 87, Categoria.PLATINO);
//        Viajero v6 = new Viajero("90423849", "Carrusel", "gyfin@gmail.com", 99, Categoria.PLATINO);
//        Viajero v7 = new Viajero("99594873", "madozito", "asdsd@gmail.com", 6, Categoria.ESTANDAR);
//        Viajero v8 = new Viajero("54982379");
//        Viajero v9 = new Viajero("choicedosa@gmail.com", 0);
//        arbol.insertar(v1);
//        arbol.insertar(v2);
//        arbol.insertar(v3);
//        arbol.insertar(v4);
//        arbol.insertar(v5);
//        arbol.insertar(v6);
//        arbol.insertar(v7);
////        System.out.println(arbol.listarNumero(new Viajero(3), new ComparadorViajeroRango()));
////        System.out.println("------------------------------");
//        String cedula = "1.234.567-8";
//        String soloNumeros = cedula.replaceAll("\\D", "");
//        System.out.println(soloNumeros); // Imprime: 12345678

          ABBImp<Viajero> arbol = new ABBImp(new ComparadorViajeroCedula());
          Viajero v1 = new Viajero("56172803", "Rondro", "choice@gmail.com", 1, Categoria.PLATINO);
          Viajero v2 = new Viajero("53464577", "JuanMartin241", "pantera@gmail.com", 15, Categoria.PLATINO);
          Viajero v3 = new Viajero("72324535", "niggy", "apstor@gmail.com", 15, Categoria.ESTANDAR);
          arbol.insertar(v1);
          arbol.insertar(v2);
          arbol.insertar(v3);

          Viajero aux = arbol.obtener(new Viajero("53464577"));
          aux.setCedula("hijodepunga");



    }
}

