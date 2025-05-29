package dominio;

public class Conexion {
    private String codigoCiudadOrigen;
    private String codigoCiudadDestino;
    private boolean existe;

    public Conexion(){

    }

    public Conexion(String codigoCiudadOrigen, String codigoCiudadDestino){
        codigoCiudadOrigen = codigoCiudadOrigen;
        codigoCiudadDestino = codigoCiudadDestino;
    }

    public String getCodigoCiudadDestino() {
        return codigoCiudadDestino;
    }

    public void setCodigoCiudadDestino(String codigoCiudadDestino) {
        this.codigoCiudadDestino = codigoCiudadDestino;
    }

    public String getCodigoCiudadOrigen() {
        return codigoCiudadOrigen;
    }

    public void setCodigoCiudadOrigen(String codigoCiudadOrigen) {
        this.codigoCiudadOrigen = codigoCiudadOrigen;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

}
