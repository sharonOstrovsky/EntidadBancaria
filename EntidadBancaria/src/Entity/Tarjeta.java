package Entity;

public class Tarjeta {
    private String numero;

    public Tarjeta() {
    }

    public Tarjeta(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "numero='" + numero + '\'' +
                '}';
    }
}

