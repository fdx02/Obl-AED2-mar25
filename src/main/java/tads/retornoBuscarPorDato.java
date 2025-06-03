package tads;

public class retornoBuscarPorDato {
    String string;
    int entero;
    public retornoBuscarPorDato(String string, int entero) {
        this.string = string;
        this.entero = entero;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public double getEntero() {
        return entero;
    }

    public void setEntero(int entero) {
        this.entero = entero;
    }
}
