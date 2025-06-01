package sistema;

import comparadores.*;
import dominio.Conexion;
import dominio.Viajero;
import dominio.Vuelo;
import interfaz.*;
import tads.ABB;
import tads.ABBImp;
import tads.GrafoImp;
import tads.ListaImp;

public class ImplementacionSistema implements Sistema  {
    private ABB<Viajero> viajerosCedula;
    private ABB<Viajero> viajerosMail;
    private ABB<Viajero> viajerosEstandar;
    private ABB<Viajero> viajerosFrecuente;
    private ABB<Viajero> viajerosPlatino;
    private ListaImp<ABBImp<Viajero>> viajerosRango;
    private GrafoImp grafoCiudades;

    @Override
    public Retorno inicializarSistema(int maxCiudades) {
        viajerosCedula = new ABBImp<Viajero>(new ComparadorViajeroCedula());
        viajerosMail = new ABBImp<Viajero>(new ComparadorViajeroMail());
        viajerosEstandar = new ABBImp<Viajero>(new ComparadorViajeroCedula());
        viajerosFrecuente = new ABBImp<Viajero>(new ComparadorViajeroCedula());
        viajerosPlatino = new ABBImp<Viajero>(new ComparadorViajeroCedula());
        viajerosRango = new ListaImp<ABBImp<Viajero>>(14);
        for (int i = 0; i < viajerosRango.getMaxElementos(); i++) {
            viajerosRango.agregar(new ABBImp<Viajero>(new ComparadorViajeroCedula()));
        }
        if (maxCiudades > 4) {
            grafoCiudades = new GrafoImp(maxCiudades, true);
            return Retorno.ok();
        }
        return Retorno.error1("");
    }

    @Override
    public Retorno registrarViajero(String cedula, String nombre, String correo, int edad, Categoria categoria) {
        if (cedula == null || cedula.trim().isEmpty() || nombre == null || nombre.trim().isEmpty() || correo == null || correo.trim().isEmpty() || categoria == null) {
            return Retorno.error1("");
        }
        if (!cedula.matches("^\\d{1}\\.\\d{3}\\.\\d{3}-\\d$|^\\d{3}\\.\\d{3}-\\d$")){
            return Retorno.error2("");
        }
        if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            return Retorno.error3("");
        }
        if (edad <= 0 || edad >= 139){
            return Retorno.error4("");
        }
        if (viajerosCedula.existe(new Viajero(cedula))) {
            return Retorno.error5("");
        }
        if (viajerosMail.existe(new Viajero(correo, edad))) {
            return Retorno.error6("");
        }
        Viajero V = new Viajero(cedula,nombre,correo,edad,categoria);

        if (categoria.equals(Categoria.PLATINO)) {
            viajerosPlatino.insertar(V);
        } else if (categoria.equals(Categoria.FRECUENTE)){
            viajerosFrecuente.insertar(V);
        } else {
            viajerosEstandar.insertar(V);
        }
        viajerosRango.obtener(V.getEdad() / 10).insertar(V);
        viajerosCedula.insertar(V);
        viajerosMail.insertar(V);
        return Retorno.ok();
    }

    @Override
    public Retorno buscarViajeroPorCedula(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            return Retorno.error1("");
        }
        if (!cedula.matches("^\\d{1}\\.\\d{3}\\.\\d{3}-\\d$|^\\d{3}\\.\\d{3}-\\d$")){
            return Retorno.error2("");
        }
        if (viajerosCedula.existe(new Viajero(cedula))) {
            return Retorno.ok(viajerosCedula.buscarPorDatoCant(new Viajero(cedula)), viajerosCedula.buscarPorDato(new Viajero(cedula)));
        } else {
            return Retorno.error3("");
        }
    }

    @Override
    public Retorno buscarViajeroPorCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            return Retorno.error1("");
        }
        if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
            return Retorno.error2("");
        }
        if(viajerosMail.existe(new Viajero(correo, 0))) {
            return Retorno.ok(viajerosMail.buscarPorDatoCant(new Viajero(correo, 0)), viajerosMail.buscarPorDato(new Viajero(correo, 0)));
        } else {
            return Retorno.error3("");
        }
    }

    @Override
    public Retorno listarViajerosPorCedulaAscendente() {
        return Retorno.ok(viajerosCedula.listarAscendente());
    }

    @Override
    public Retorno listarViajerosPorCedulaDescendente() {
        return Retorno.ok(viajerosCedula.listarDesc());
    }

    @Override
    public Retorno listarViajerosPorCorreoAscendente() {
        return Retorno.ok(viajerosMail.listarAscendente());
    }

    @Override
    public Retorno listarViajerosPorCategoria(Categoria unaCategoria) {
        if (unaCategoria.equals(Categoria.PLATINO)) {
            return Retorno.ok(viajerosPlatino.listarAscendente());
        } else if (unaCategoria.equals(Categoria.FRECUENTE)) {
            return Retorno.ok(viajerosFrecuente.listarAscendente());
        } else {
            return Retorno.ok(viajerosEstandar.listarAscendente());
        }
    }
    @Override
    public Retorno listarViajerosDeUnRangoAscendente(int rango) {
        if (rango < 0){
            return Retorno.error1("");
        }
        if (rango > 13){
            return Retorno.error2("");
        }
        return Retorno.ok(viajerosRango.obtener(rango).listarAscendente());
        //return Retorno.ok(viajerosRango.obtener(rango).listarCondicion(new Viajero(rango)));
        //return Retorno.ok(viajerosRango[rango].listarCondicion(new Viajero(rango), new ComparadorViajeroRango()));
    }

    @Override
    public Retorno registrarCiudad(String codigo, String nombre) {
        if (grafoCiudades.esLleno()){
            return Retorno.error1("");
        }
        if (codigo == null || codigo.trim().isEmpty() || nombre == null || nombre.trim().isEmpty()) {
            return Retorno.error2("");
        }
        if (grafoCiudades.existe(codigo)) {
            return Retorno.error3("");
        }
        grafoCiudades.registrarCiudad(codigo, nombre);
        return Retorno.ok();
    }

    @Override
    public Retorno registrarConexion(String codigoCiudadOrigen, String codigoCiudadDestino) {
        if (codigoCiudadOrigen == null || codigoCiudadOrigen.trim().isEmpty() || codigoCiudadDestino == null || codigoCiudadDestino.trim().isEmpty()) {
            return Retorno.error1("");
        }
        if (!grafoCiudades.existe(codigoCiudadOrigen)) {
            return Retorno.error2("");
        }
        if (!grafoCiudades.existe(codigoCiudadDestino)) {
            return Retorno.error3("");
        }
        if (grafoCiudades.existeConexion(codigoCiudadOrigen, codigoCiudadDestino)) {
            return Retorno.error4("");
        }
        grafoCiudades.registrarConexion(new Conexion(codigoCiudadOrigen, codigoCiudadDestino));
        return Retorno.ok();
    }

    @Override
    public Retorno registrarVuelo(String codigoCiudadOrigen, String codigoCiudadDestino, String codigoDeVuelo, double combustible, double minutos, double costoEnDolares, TipoVuelo tipoDeVuelo) {
        if (combustible <= 0 || costoEnDolares <= 0 || minutos <= 0){
            return Retorno.error1("");
        }
        if (tipoDeVuelo == null || codigoCiudadOrigen == null || codigoCiudadOrigen.trim().isEmpty() || codigoCiudadDestino == null || codigoCiudadDestino.trim().isEmpty() || codigoDeVuelo == null || codigoDeVuelo.trim().isEmpty()){
            return Retorno.error2("");
        }
        if (!grafoCiudades.existe(codigoCiudadOrigen)) {
            return Retorno.error3("");
        }
        if (!grafoCiudades.existe(codigoCiudadDestino)) {
            return Retorno.error4("");
        }
        if (!grafoCiudades.existeConexion(codigoCiudadOrigen, codigoCiudadDestino)) {
            return Retorno.error5("");
        }
        if (grafoCiudades.existeVuelo(new Conexion(codigoCiudadOrigen,codigoCiudadDestino), codigoDeVuelo)){
            return Retorno.error6("");
        }
        grafoCiudades.registrarVuelo(new Vuelo(codigoCiudadOrigen,codigoCiudadDestino,codigoDeVuelo,combustible,minutos,costoEnDolares,tipoDeVuelo));
        return Retorno.ok();
    }

    @Override
    public Retorno actualizarVuelo(String codigoCiudadOrigen, String codigoCiudadDestino, String codigoDeVuelo, double combustible, double minutos, double costoEnDolares, TipoVuelo tipoDeVuelo) {
        if (combustible <= 0 || costoEnDolares <= 0 || minutos <= 0){
            return Retorno.error1("");
        }
        if (tipoDeVuelo == null || codigoCiudadOrigen == null || codigoCiudadOrigen.trim().isEmpty() || codigoCiudadDestino == null || codigoCiudadDestino.trim().isEmpty() || codigoDeVuelo == null || codigoDeVuelo.trim().isEmpty()){
            return Retorno.error2("");
        }
        if (!grafoCiudades.existe(codigoCiudadOrigen)) {
            return Retorno.error3("");
        }
        if (!grafoCiudades.existe(codigoCiudadDestino)) {
            return Retorno.error4("");
        }
        if (!grafoCiudades.existeConexion(codigoCiudadOrigen, codigoCiudadDestino)) {
            return Retorno.error5("");
        }
        if (!grafoCiudades.existeVuelo(new Conexion(codigoCiudadOrigen,codigoCiudadDestino), codigoDeVuelo)){
            return Retorno.error6("");
        }
        grafoCiudades.actualizarVuelo(new Vuelo(codigoCiudadOrigen,codigoCiudadDestino,codigoDeVuelo,combustible,minutos,costoEnDolares,tipoDeVuelo));
        return Retorno.ok();
    }

    @Override
    public Retorno listadoCiudadesCantDeEscalas(String codigoCiudadOrigen, int cantidad) {
        if (cantidad < 0){
            return Retorno.error1("");
        }
        if (codigoCiudadOrigen == null || codigoCiudadOrigen.trim().isEmpty()){
            return Retorno.error2("");
        }
        if (!grafoCiudades.existe(codigoCiudadOrigen)) {
            return Retorno.error3("");
        }
        return Retorno.ok(grafoCiudades.cantEscalas(cantidad,codigoCiudadOrigen));
    }

    @Override
    public Retorno viajeCostoMinimoMinutos(String codigoCiudadOrigen, String codigoCiudadDestino, TipoVueloPermitido tipoVueloPermitido) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno viajeCostoMinimoDolares(String codigoCiudadOrigen, String codigoCiudadDestino, TipoVueloPermitido tipoVueloPermitido) {
        return Retorno.noImplementada();
    }

}
