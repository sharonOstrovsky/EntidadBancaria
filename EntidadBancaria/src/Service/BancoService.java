package Service;

import Entity.Banco;
import Entity.Cliente;
import Entity.CuentaBancaria;

import java.util.ArrayList;
import java.util.Scanner;

//crearBanco (arraylist de 10 cuentas bancarias)
//transaccion entre cuentas bancarias (sacar plata de una y ponerlo en otra)
//retirar dinero
//consultar saldo
//ingresar dinero
//ingresar a la cuenta de banco
//validar que sea mayor de edad para crear cuenta bancaria
public class BancoService {

    Scanner input = new Scanner(System.in);
    CuentaBancariaService cuentaServicio = new CuentaBancariaService();
    ClienteService clienteServicio = new ClienteService();
    //creo un banco con 10 cuentas bancarias
    public Banco crearBanco(){

        Banco banco = new Banco();
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

        while(cuentas.size() != 10){
            Cliente cliente = clienteServicio.crearCliente();
            if(esMayorEdad(cliente)){
                CuentaBancaria cuenta = cuentaServicio.crearCuenta(cliente);
                cuentas.add(cuenta);
            }
        }


        banco.setCuentas(cuentas);

        return banco;
    }

    public boolean esMayorEdad(Cliente cliente){
        return cliente.getEdad() >= 18;
    }

    public boolean ingresarACuenta(CuentaBancaria cuenta){
        boolean ingreso = false;

        System.out.println("");
        System.out.println("----------");
        System.out.println("");

        System.out.print("Usuario: ");
        String usuario = input.next();
        System.out.println("Contraseña: ");
        String clave = input.next();

        if( !usuario.equals( cuenta.getUsuario() )  || !clave.equals( cuenta.getClave() ) ){
            System.out.println("clave o contraseña incorrecta, vulva a intentarlo");
        }else{
            System.out.println("BIENVENIDO "+ cuenta.getCliente().getNombre() + " " + cuenta.getCliente().getApellido());
            ingreso = true;
        }

        System.out.println("");
        System.out.println("----------");
        System.out.println("");

        return ingreso;
    }

    public void consultarSaldo(CuentaBancaria cuenta){
        System.out.println("Saldo: " + cuenta.getSaldo());
    }

    public void retirarDinero(CuentaBancaria cuenta, float dinero){

        if(cuenta.getSaldo() >= dinero){
            cuenta.setSaldo(cuenta.getSaldo() - dinero);
            System.out.println("--------¿ACCION? TERMINADA----------");
        }else{
            System.out.println("Saldo insuficiente");
        }

    }

    public void ingresarDinero(CuentaBancaria cuenta, float dinero){
        cuenta.setSaldo(cuenta.getSaldo() + dinero);
        System.out.println("--------¿ACCION? TERMINADA----------");

    }
}
