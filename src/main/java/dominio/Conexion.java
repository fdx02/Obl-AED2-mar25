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
    private Lista<Vuelo> vuelos;
    private Lista<Vuelo> vuelosMinutos;
    private Lista<Vuelo> vuelosDolares;

    private boolean existe;

    public Conexion(){

    }

    public Conexion(String ORIGEN, String DESTINO){
        codigoCiudadOrigen = ORIGEN;
        codigoCiudadDestino = DESTINO;
        vuelos = new ListaImp<Vuelo>(new ComparadorVueloCodigo(), Integer.MAX_VALUE);
        vuelosMinutos = new ListaImp<Vuelo>(new ComparadorVueloMinutos(), Integer.MAX_VALUE);
        vuelosDolares = new ListaImp<Vuelo>(new ComparadorVueloDolares(), Integer.MAX_VALUE);
    }

    public void agregarVuelo(Vuelo V){
        vuelos.agregar(V);
        vuelosMinutos.agregar(V);
        vuelosDolares.agregar(V);
    }

    public void actualizarVuelo(Vuelo V){
        Vuelo aux = vuelos.obtener(V);
        aux.setCombustible(V.getCombustible());
        aux.setMinutos(V.getMinutos());
        aux.setCostoEnDolares(V.getCostoEnDolares());
        aux.setTipoVuelo(V.getTipoVuelo());
        aux.setTipoVueloPermitido(V.getTipoVueloPermitido());
    }

    public double getPesoMinimo(int indice, TipoVueloPermitido tipo) {
        Vuelo v;
        if(vuelos.esVacia()){
            return Integer.MAX_VALUE;
        }
        if (indice == 1) {
            v = this.vuelosMinutos.obtenerCondicion(new Vuelo(tipo), new ComparadorVueloTipo());
            if(v != null){
                return v.getMinutos();
            }
        } else {
            v = this.vuelosDolares.obtenerCondicion(new Vuelo(tipo), new ComparadorVueloTipo());
            if(v != null){
                return v.getCostoEnDolares();
            }
        }
        return Integer.MAX_VALUE;
    }

    public boolean tieneVuelos(){
        return !vuelos.esVacia();
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
