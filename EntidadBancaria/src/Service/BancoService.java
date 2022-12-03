package Service;

import Entity.Banco;
import Entity.Cliente;
import Entity.CuentaBancaria;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Scanner;

//crearBanco (arraylist de 10 cuentas bancarias)
//validar que sea mayor de edad para crear cuenta bancaria
//menu con opciones (ingresar, retirar, transferir, cerrar sesion) ->primero ingreso a la cuenta
public class BancoService {

    Scanner input = new Scanner(System.in).useDelimiter("\n");
    CuentaBancariaService cuentaServicio = new CuentaBancariaService();
    ClienteService clienteServicio = new ClienteService();
    //creo un banco con 10 cuentas bancarias
    public Banco crearBanco(){

        Banco banco = new Banco();
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

        while(cuentas.size() != 2){
            Cliente cliente = clienteServicio.crearCliente();
            if(esMayorEdad(cliente)){
                CuentaBancaria cuenta = cuentaServicio.crearCuenta(cliente);
                cuentas.add(cuenta);
            }
        }


        banco.setCuentas(cuentas);

        return banco;
    }

    public void menu(Banco banco){

        boolean salir = false;

        System.out.println("");
        System.out.println("----------BIENVENIDO/A AL BANCO----------");
        System.out.println("");

        System.out.println("¿Ingresar o Registrarse?");
        String rta = input.next();
        if(rta.equalsIgnoreCase("registrarse")){
            registrarse(banco);
        }else if(rta.equalsIgnoreCase("ingresar")){
            do{

                if(cuentaServicio.ingresarACuenta(banco.getCuentas())){
                    System.out.println("desea ingresar a otra cuenta? (s/n)");
                    String volver = input.next();
                    if(volver.equalsIgnoreCase("n")){
                        salir = true;
                        System.out.println("");
                        System.out.println("----------VUELVA PRONTO----------");
                        System.out.println("");
                    }
                }
            }while(!salir);
            //boolean ingreso = cuentaServicio.ingresarACuenta(banco.getCuentas());

        }

    }

    public void registrarse(Banco banco){
        System.out.println("");
        System.out.println("----------REGISTRARSE----------");
        System.out.println("");

        ArrayList<CuentaBancaria> cuentasAux = new ArrayList<>();
        Cliente cliente = clienteServicio.crearCliente();
        CuentaBancaria cuenta = cuentaServicio.crearCuenta(cliente);
        cuentasAux = banco.getCuentas();
        cuentasAux.add(cuenta);
        banco.setCuentas(cuentasAux);

        System.out.println("");
        System.out.println("----------CUENTA REGISTRADA----------");
        System.out.println("");
    }

    public boolean esMayorEdad(Cliente cliente){
        return cliente.getEdad() >= 18;
    }


}
