package dominio;

import interfaz.Categoria;

import java.util.Objects;

public class Viajero implements Comparable<Viajero> {
    private String cedula;
    private String nombre;
    private String correo;
    private int edad;
    private Categoria categoria;
    private int conteo;
    public Viajero() {
    }


    public Viajero(String CEDULA, String NOMBRE, String CORREO, int EDAD, Categoria CATEGORIA) {
        this.cedula = CEDULA;
        this.nombre = NOMBRE;
        this.correo = CORREO;
        this.edad = EDAD;
        this.categoria = CATEGORIA;
        this.conteo = 0;
    }

    public Viajero(String CEDULA){
        this.cedula = CEDULA;
    }

    public Viajero(String CORREO, int EDAD){
        this.correo = CORREO;
    }
    public Viajero(Categoria CATEGORIA){
        this.categoria = CATEGORIA;
    }
    public Viajero(int RANGO){
        this.edad = RANGO;
    }

    public int compareTo(Viajero o) {
        return this.categoria.getTexto().compareTo(o.categoria.getTexto());
    }

    //ARREGLAR EL TOSTRING PORQUE SE ROMPE EN LISTAS
    @Override
    public String toString() {
        return cedula + ";" + nombre + ";" + correo + ";" + edad + ";" + categoria.getTexto() + "|";
        //“cedula;nombre;correo;edad;categoria”
    }

    public int getConteo() {
        return conteo;
    }

    public void setConteo(int conteo) {
        this.conteo = conteo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Viajero viajero = (Viajero) o;
        return Objects.equals(cedula, viajero.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cedula);
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
