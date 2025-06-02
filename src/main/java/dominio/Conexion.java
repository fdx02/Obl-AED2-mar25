package dominio;
import comparadores.ComparadorVueloCodigo;
import comparadores.ComparadorVueloDolares;
import comparadores.ComparadorVueloMinutos;
import comparadores.ComparadorVueloTipo;
import interfaz.TipoVueloPermitido;
import tads.*;

public class Conexion {
    private String codigoCiudadOrigen;
    private String codigoCiudadDestino;
    private ABB<Vuelo> vuelos;
    private ABB<Vuelo> vuelosMinutos;
    private ABB<Vuelo> vuelosDolares;

    private boolean existe;

    public Conexion(){

    }

    public Conexion(String ORIGEN, String DESTINO){
        codigoCiudadOrigen = ORIGEN;
        codigoCiudadDestino = DESTINO;
        vuelos = new ABBImp<Vuelo>(new ComparadorVueloCodigo());
        vuelosMinutos = new ABBImp<Vuelo>(new ComparadorVueloMinutos());
        vuelosDolares = new ABBImp<Vuelo>(new ComparadorVueloDolares());
    }

    public void agregarVuelo(Vuelo V){
        vuelos.insertar(V);
        vuelosMinutos.insertar(V);
        vuelosDolares.insertar(V);
    }

    public void actualizarVuelo(Vuelo V){
        Vuelo aux = vuelos.obtener(V);
        aux.setCombustible(V.getCombustible());
        aux.setMinutos(V.getMinutos());
        aux.setCostoEnDolares(V.getCostoEnDolares());
        aux.setTipoVuelo(V.getTipoVuelo());

        Vuelo auxMinutos = vuelosMinutos.obtener(V);
        auxMinutos.setCombustible(V.getCombustible());
        auxMinutos.setMinutos(V.getMinutos());
        auxMinutos.setCostoEnDolares(V.getCostoEnDolares());
        auxMinutos.setTipoVuelo(V.getTipoVuelo());

        Vuelo auxDolares = vuelosDolares.obtener(V);
        auxDolares.setCombustible(V.getCombustible());
        auxDolares.setMinutos(V.getMinutos());
        auxDolares.setCostoEnDolares(V.getCostoEnDolares());
        auxDolares.setTipoVuelo(V.getTipoVuelo());
    }

    public double getPesoMinimo(int indice, TipoVueloPermitido tipo) {
        Vuelo v;
        if(vuelos.esVacio()){
            return Integer.MAX_VALUE;
        }
        if (indice == 1) {
            v = this.vuelosMinutos.getMenor(new ComparadorVueloTipo(), new Vuelo(tipo));
            if(v != null){
                return v.getMinutos();
            }
        } else {
            v = this.vuelosDolares.getMenor(new ComparadorVueloTipo(), new Vuelo(tipo));
            if(v != null){
                return v.getCostoEnDolares();
            }
        }
        return Integer.MAX_VALUE;
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
