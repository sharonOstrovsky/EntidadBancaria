package Entity;

public class CuentaBancaria {

    private String usuario;
    private String clave;
    private Cliente cliente;
    private int tarjeta;
    private float saldo;

    public CuentaBancaria() {
        this.saldo = 0;
    }

    public CuentaBancaria(String usuario, String clave, Cliente cliente, int tarjeta) {
        this.usuario = usuario;
        this.clave = clave;
        this.cliente = cliente;
        this.tarjeta = tarjeta;
        this.saldo = 0;
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

    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
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
