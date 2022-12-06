package Entity;

public class CuentaBancaria {

    private String usuario;
    private String clave;
    private Cliente cliente;
    private Tarjeta tarjeta;
    private double saldo;


    public CuentaBancaria() {
        this.saldo = 0;
    }

    public CuentaBancaria(String usuario, String clave, Cliente cliente, Tarjeta tarjeta, double saldo) {
        this.usuario = usuario;
        this.clave = clave;
        this.cliente = cliente;
        this.tarjeta = tarjeta;
        this.saldo = saldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                ", cliente=" + cliente +
                ", tarjeta=" + tarjeta +
                ", saldo=" + saldo +
                '}';
    }
}
