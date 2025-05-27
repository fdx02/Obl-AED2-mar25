package sistema;

import comparadores.*;
import dominio.Viajero;
import interfaz.*;
import tads.ABBImp;

public class ImplementacionSistema implements Sistema  {
    private ABBImp<Viajero> viajerosCedula;
    private ABBImp<Viajero> viajerosMail;
    private ABBImp<Viajero> viajerosCategoria;

    @Override
    public Retorno inicializarSistema(int maxCiudades) {
        viajerosCedula = new ABBImp<Viajero>(new ComparadorViajeroCedula());
        viajerosMail = new ABBImp<Viajero>(new ComparadorViajeroMail());
        viajerosCategoria = new ABBImp<Viajero>(new ComparadorViajeroCategoria());
        return Retorno.noImplementada();
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
        viajerosCedula.insertar(new Viajero(cedula,nombre,correo,edad,categoria));
        viajerosMail.insertar(new Viajero(cedula,nombre,correo,edad,categoria));
        viajerosCategoria.insertar(new Viajero(cedula,nombre,correo,edad,categoria));
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
        return Retorno.ok(viajerosCedula.listarCondicion(new Viajero(unaCategoria)));
    }
    @Override
    public Retorno listarViajerosDeUnRangoAscendente(int rango) {
        if (rango < 0){
            return Retorno.error1("");
        }
        if (rango > 13){
            return Retorno.error2("");
        }
        return Retorno.ok(viajerosCedula.listarComparador(new Viajero(rango), new ComparadorViajeroRango()));
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
