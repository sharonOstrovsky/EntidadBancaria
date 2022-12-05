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

        BancoService servicoBanco = new BancoService();
        Banco banco = servicoBanco.crearBancoPreArmado();
        servicoBanco.menu(banco);


    }
}