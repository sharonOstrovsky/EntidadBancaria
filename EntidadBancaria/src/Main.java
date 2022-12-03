import Entity.Banco;
import Entity.Cliente;
import Entity.CuentaBancaria;
import Service.BancoService;
import Service.ClienteService;
import Service.CuentaBancariaService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        BancoService servicoBanco = new BancoService();
        Banco banco = servicoBanco.crearBanco();
        servicoBanco.menu(banco);

/*
        ClienteService serv  = new ClienteService();
        Cliente cliente = serv.crearCliente();
        System.out.println(cliente);
        Cliente cliente = new Cliente("sharon", "ostrovsky", 39915620,26,"sharonostro@gmail.com","boyaca 1853", "Argentina" );
        CuentaBancariaService sc = new CuentaBancariaService();
        CuentaBancaria cuenta = sc.crearCuenta(cliente);

        Cliente cliente2 = new Cliente("federico", "lillo", 35654520,21,"fedelillo@gmail.com","boyaca 1853", "Argentina" );
        CuentaBancaria cuenta2 = sc.crearCuenta(cliente2);

        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
        cuentas.add(cuenta);
        cuentas.add(cuenta2);

        sc.ingresarDinero(cuenta, 12000);
        sc.ingresarDinero(cuenta2, 3000);
        sc.tranferencia(cuentas, cuenta);
        sc.consultarSaldo(cuenta);
        sc.consultarSaldo(cuenta2);
        System.out.println(cuenta);

 */
    }
}