package sistema;

import interfaz.Retorno;
import interfaz.Sistema;
import interfaz.TipoVuelo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test13ActualizarVueloValidaciones {
    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @BeforeEach
    public void setUp() {
        s.inicializarSistema(15);
    }

    @Test
    void actualizarVueloOk() {
        s.registrarCiudad("COD01", "Ciudad1");
        s.registrarCiudad("COD02", "Ciudad2");
        s.registrarConexion("COD01", "COD02");
        s.registrarVuelo("COD01", "COD02", "codigo1", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        retorno = s.actualizarVuelo("COD01", "COD02", "codigo1", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }

    @Test
    void actualizarVueloError1() {
        retorno = s.actualizarVuelo("COD01", "COD02", "codigo1", -10, 360, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.actualizarVuelo("COD01", "COD02", "codigo1", 0, 360, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.actualizarVuelo("COD01", "COD02", "codigo1", 5000, -10, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.actualizarVuelo("COD01", "COD02", "codigo1", 5000, 0, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.actualizarVuelo("COD01", "COD02", "codigo1", 5000, 360, -10, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

    }

    @Test
    void registrarVueloError2() {
        retorno = s.actualizarVuelo("", "COD02", "codigo1", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
        retorno = s.actualizarVuelo("  ", "COD02", "codigo1", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
        retorno = s.actualizarVuelo(null, "COD02", "codigo1", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

        retorno = s.actualizarVuelo("COD01", "", "codigo1", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
        retorno = s.actualizarVuelo("COD01", "   ", "codigo1", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
        retorno = s.actualizarVuelo("COD01", null, "codigo1", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

        retorno = s.actualizarVuelo("COD01", "COD02", "", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
        retorno = s.actualizarVuelo("COD01", "COD02", "   ", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
        retorno = s.actualizarVuelo("COD01", "COD02", null, 5000, 360, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

        retorno = s.actualizarVuelo("COD01", "COD02", "codigo1", 5000, 360, 1500, null);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

    }

    @Test
    void registrarVueloError3() {
        retorno = s.actualizarVuelo("COD01", "COD02", "codigo1", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_3, retorno.getResultado());
    }

    @Test
    void registrarVueloError4() {
        s.registrarCiudad("COD01", "Ciudad1");
        retorno = s.actualizarVuelo("COD01", "COD02", "codigo1", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_4, retorno.getResultado());
    }

    @Test
    void registrarVueloError5() {
        s.registrarCiudad("COD01", "Ciudad1");
        s.registrarCiudad("COD02", "Ciudad2");
        retorno = s.actualizarVuelo("COD01", "COD02", "codigo1", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_5, retorno.getResultado());
    }

    @Test
    void registrarVueloError6() {
        s.registrarCiudad("COD01", "Ciudad1");
        s.registrarCiudad("COD02", "Ciudad2");
        s.registrarConexion("COD01", "COD02");
        retorno = s.actualizarVuelo("COD01", "COD02", "codigo1", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_6, retorno.getResultado());
    }



}
