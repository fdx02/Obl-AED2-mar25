package dominio;

import interfaz.Categoria;

public class Viajero implements Comparable<Viajero> {
    private String cedula;
    private String nombre;
    private String correo;
    private int edad;
    private Categoria categoria;

    public Viajero() {
    }

    public Viajero(String CEDULA, String NOMBRE, String CORREO, int EDAD, Categoria CATEGORIA) {
        this.cedula = CEDULA;
        this.nombre = NOMBRE;
        this.correo = CORREO;
        this.edad = EDAD;
        this.categoria = CATEGORIA;
    }

    public Viajero(String CEDULA){
        this.cedula = CEDULA;
    }

    public Viajero(String CORREO, int EDAD){
        this.correo = CORREO;
    }

    public int compareTo(Viajero o) {
        return this.cedula.compareTo(o.cedula);
    }

    @Override
    public String toString() {
        return "Viajero{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", edad=" + edad +
                ", categoria=" + categoria +
                '}';
    }
}
