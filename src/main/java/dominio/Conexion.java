package dominio;
import comparadores.ComparadorVuelo;
import tads.*;

public class Conexion {
    private String codigoCiudadOrigen;
    private String codigoCiudadDestino;
    private ABB<Vuelo> vuelos;
    private boolean existe;

    public Conexion(){

    }

    public Conexion(String ORIGEN, String DESTINO){
        codigoCiudadOrigen = ORIGEN;
        codigoCiudadDestino = DESTINO;
        vuelos = new ABBImp<Vuelo>(new ComparadorVuelo());
    }

    public void agregarVuelo(Vuelo V){
        vuelos.insertar(V);
    }

    public void actualizarVuelo(Vuelo V){
        Vuelo aux = vuelos.obtener(V);
        aux.setCombustible(V.getCombustible());
        aux.setMinutos(V.getMinutos());
        aux.setCostoEnDolares(V.getCostoEnDolares());
        aux.setTipoVuelo(V.getTipoVuelo());
    }

    public boolean tieneVuelos(){
        return !vuelos.esVacio();
    }

    public boolean existeVuelo(String codigoVuelo){
        return vuelos.existe(new Vuelo(codigoVuelo));
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
