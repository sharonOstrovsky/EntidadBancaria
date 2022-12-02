package Entity;

import java.util.ArrayList;

public class Banco {
    private ArrayList<CuentaBancaria> cuentas;

    public Banco() {
    }

    public Banco(ArrayList<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    public ArrayList<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "cuentas=" + cuentas +
                '}';
    }
}
