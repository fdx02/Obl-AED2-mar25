package dominio;

import interfaz.TipoVuelo;

public class Vuelo implements Comparable<Vuelo>{
    String codigoCiudadOrigen;
    String codigoCiudadDestino;
    String codigoVuelo;
    double combustible;
    double minutos;
    double costoEnDolares;
    TipoVuelo tipoVuelo;

    public Vuelo() {

    }
    public Vuelo(String ORIGEN, String DESTINO, String CODIGO, double COMBUSTIBLE, double MINUTOS, double COSTO, TipoVuelo TIPO) {
        codigoCiudadOrigen = ORIGEN;
        codigoCiudadDestino = DESTINO;
        codigoVuelo = CODIGO;
        combustible = COMBUSTIBLE;
        minutos = MINUTOS;
        costoEnDolares = COSTO;
        tipoVuelo = TIPO;
    }
    public Vuelo(String CODIGO){
        codigoVuelo = CODIGO;
    }

    @Override
    public int compareTo(Vuelo o) {
        return this.codigoVuelo.compareTo(o.codigoVuelo);
    }

    public String getCodigoCiudadOrigen() {
        return codigoCiudadOrigen;
    }

    public void setCodigoCiudadOrigen(String codigoCiudadOrigen) {
        this.codigoCiudadOrigen = codigoCiudadOrigen;
    }

    public String getCodigoCiudadDestino() {
        return codigoCiudadDestino;
    }

    public void setCodigoCiudadDestino(String codigoCiudadDestino) {
        this.codigoCiudadDestino = codigoCiudadDestino;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public double getCombustible() {
        return combustible;
    }

    public void setCombustible(double combustible) {
        this.combustible = combustible;
    }

    public double getMinutos() {
        return minutos;
    }

    public void setMinutos(double minutos) {
        this.minutos = minutos;
    }

    public double getCostoEnDolares() {
        return costoEnDolares;
    }

    public void setCostoEnDolares(double costoEnDolares) {
        this.costoEnDolares = costoEnDolares;
    }

    public TipoVuelo getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(TipoVuelo tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }
}
