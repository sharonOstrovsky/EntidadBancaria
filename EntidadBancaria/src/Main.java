import Entity.Banco;
import Entity.Cliente;
import Entity.CuentaBancaria;
import Entity.Tarjeta;
import Service.BancoService;
import Service.ClienteService;
import Service.CuentaBancariaService;
import Service.TarjetaService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

     //   BancoService servicoBanco = new BancoService();
       // Banco banco = servicoBanco.crearBanco();
        //servicoBanco.menu(banco);
        TarjetaService tarjetaServicio = new TarjetaService();
        Tarjeta tarjeta = tarjetaServicio.crearTarjeta();
        System.out.println(tarjeta);
        Tarjeta tarjeta2 = tarjetaServicio.crearTarjeta();
        System.out.println(tarjeta2);
        Tarjeta tarjeta3 = tarjetaServicio.crearTarjeta();
        System.out.println(tarjeta3);
        Tarjeta tarjeta4 = tarjetaServicio.crearTarjeta();
        System.out.println(tarjeta4);
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