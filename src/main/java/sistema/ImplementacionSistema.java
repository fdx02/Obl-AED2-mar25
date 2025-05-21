package sistema;

import comparadores.*;
import dominio.Viajero;
import interfaz.*;
import tads.ABBImp;

public class ImplementacionSistema implements Sistema  {
    private ABBImp<Viajero> viajerosCedula;
    private ABBImp<Viajero> viajerosMail;

    @Override
    public Retorno inicializarSistema(int maxCiudades) {
        viajerosCedula = new ABBImp<Viajero>(new ComparadorViajeroCedula());
        viajerosMail = new ABBImp<Viajero>(new ComparadorViajeroMail());
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarViajero(String cedula, String nombre, String correo, int edad, Categoria categoria) {
        if (cedula == null || cedula.isEmpty() || nombre == null || nombre.isEmpty() || correo == null || correo.isEmpty() || categoria == null) {
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
        viajerosCedula.insertar(new Viajero(cedula,nombre,correo,edad,categoria));
        viajerosMail.insertar(new Viajero(cedula,nombre,correo,edad,categoria));
        return Retorno.ok();
    }

    @Override
    public Retorno buscarViajeroPorCedula(String cedula) {
        if (cedula == null || cedula.isEmpty()) {
            return Retorno.error1("");
        }
        if (!cedula.matches("^\\d{1}\\.\\d{3}\\.\\d{3}-\\d$|^\\d{3}\\.\\d{3}-\\d$")){
            return Retorno.error2("");
        }
        if (!viajerosCedula.existe(new Viajero(cedula))) {
            return Retorno.error3("");
        }
        return Retorno.ok(viajerosCedula.buscarPorDatoCant(new Viajero(cedula)), viajerosCedula.buscarPorDato(new Viajero(cedula)));
    }

    @Override
    public Retorno buscarViajeroPorCorreo(String correo) {
        if (correo == null || correo.isEmpty()) {
            return Retorno.error1("");
        }
        if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
            return Retorno.error2("");
        }
        if (!viajerosMail.existe(new Viajero(correo))) {
            return Retorno.error3("");
        }
        return Retorno.ok(viajerosMail.buscarPorDatoCant(new Viajero(correo, 0)), viajerosMail.buscarPorDato(new Viajero(correo, 0)));
    }

    @Override
    public Retorno listarViajerosPorCedulaAscendente() {
        return Retorno.ok(viajerosCedula.listarAscendente());
    }

    @Override
    public Retorno listarViajerosPorCedulaDescendente() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarViajerosPorCorreoAscendente() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarViajerosPorCategoria(Categoria unaCategoria) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarViajerosDeUnRangoAscendente(int rango) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarCiudad(String codigo, String nombre) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarConexion(String codigoCiudadOrigen, String codigoCiudadDestino) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarVuelo(String codigoCiudadOrigen, String codigoCiudadDestino, String codigoDeVuelo, double combustible, double minutos, double costoEnDolares, TipoVuelo tipoDeVuelo) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno actualizarVuelo(String codigoCiudadOrigen, String codigoCiudadDestino, String codigoDeVuelo, double combustible, double minutos, double costoEnDolares, TipoVuelo tipoDeVuelo) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listadoCiudadesCantDeEscalas(String codigoCiudadOrigen, int cantidad) {
        return Retorno.noImplementada();
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
