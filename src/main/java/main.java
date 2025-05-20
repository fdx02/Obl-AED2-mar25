import comparadores.ComparadorViajeroCedula;
import comparadores.ComparadorViajeroMail;
import dominio.Viajero;
import interfaz.Categoria;
import tads.ABBImp;

public class main {
    public static void main(String[] args) {
        ABBImp<Viajero> arbol = new ABBImp(new ComparadorViajeroMail());
        Viajero v1 = new Viajero("56172803", "Rondro", "choice@gmail.com", 30, Categoria.PLATINO);
        Viajero v2 = new Viajero("53464577", "JuanMartin241", "pantera@gmail.com", 15, Categoria.FRECUENTE);
        Viajero v3 = new Viajero("37489274", "hexe", "santuario@gmail.com", 43, Categoria.PLATINO);
        Viajero v4 = new Viajero("12364365", "calpheon", "choice@gmail.com", 30, Categoria.ESTANDAR);
        Viajero v5 = new Viajero("48934879", "Rondro", "choice@gmail.com", 31, Categoria.PLATINO);
        Viajero v6 = new Viajero("90423849", "Carrusel", "choice@gmail.com", 31, Categoria.PLATINO);
        Viajero v7 = new Viajero("54982379", "madozito", "asdsd@gmail.com", 31, Categoria.ESTANDAR);
        Viajero v8 = new Viajero("54982379");
        Viajero v9 = new Viajero("choicedosa@gmail.com", 0);
        arbol.insertar(v1);
        arbol.insertar(v2);
        arbol.insertar(v3);
        arbol.insertar(v4);
        arbol.insertar(v5);
        arbol.insertar(v6);
        arbol.insertar(v7);
        arbol.listarAscendente();
        System.out.println(arbol.existe(v9));


//        int numero = 1205;
//        String numeroString = Integer.toString(numero);
//        String texto = numeroString + "ffadasdd";
//        System.out.println(texto);
//        System.out.println(texto.substring(0, numeroString.length()));
    }
}

