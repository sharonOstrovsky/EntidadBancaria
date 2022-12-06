import Entity.Banco;

import Service.BancoService;

public class Main {
    public static void main(String[] args) {

        BancoService servicoBanco = new BancoService();
        Banco banco = servicoBanco.crearBancoPreArmado();
        servicoBanco.menu(banco);




    }
}