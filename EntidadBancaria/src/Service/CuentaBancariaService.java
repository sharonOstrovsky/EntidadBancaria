package Service;
//crear cuenta bancaria
//validar usuario y contraseña de la creacion
//usuario,clave, client, tarjeta, saldo
//generar tarjeta
//transaccion entre cuentas bancarias (sacar plata de una y ponerlo en otra)
//retirar dinero
//consultar saldo
//ingresar dinero
//ingresar a la cuenta de banco
//consultar datos
import Entity.Cliente;
import Entity.CuentaBancaria;
import Entity.Tarjeta;
import Utility.Comparators;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

//falta validar
public class CuentaBancariaService {

    Scanner input = new Scanner(System.in).useDelimiter("\n");
    ClienteService clienteServicio = new ClienteService();
    TarjetaService tarjetaServicio = new TarjetaService();


    //crea la cuenta bancaria de un cliente pasado por parametro y la devuelve
    //crea el usuario y la contraseña, y confirmacion de la contraseña creada
    //agregar validacion del usuario y contraseña(que sea de las de 8 caracteres, que contenga numeros,)
    public CuentaBancaria crearCuenta(Cliente cliente){
        String clave;
        String confirm;
        boolean claveConfirmada = false;
        CuentaBancaria cuenta = new CuentaBancaria();

        System.out.println("Ingrese el nombre de usuario: ");
        String usuario = input.next();

        do{

                System.out.println("Ingrese la constraseña: ");
                clave = input.next();
                System.out.println("Confirme la contraseña: ");
                confirm = input.next();
                if(!clave.equals(confirm)){
                    System.out.println("las contraseñas no coinciden");
                }else{
                    claveConfirmada = true;
                }

        }while(!claveConfirmada);

        cuenta.setCliente(cliente);
        cuenta.setClave(clave);
        cuenta.setUsuario(usuario);

        cuenta.setTarjeta(tarjetaServicio.crearTarjeta());

        return cuenta;

    }







    //ingresar a la cuenta bancaria
    //si no coincide el usuario o la contraseña vuelve a intentarlo (se podria agregar que tenga solo 3 intentos)
    //una vez que ingreso a la cuenta se abre el menu de las cuentas bancarias hasta que cierra sesion
    //se llama desde el manu de los bancos
    public boolean ingresarACuenta( ArrayList<CuentaBancaria> cuentas){
        boolean ingreso = false;

        System.out.println("");
        System.out.println("----------");
        System.out.println("");

        System.out.print("Usuario: ");
        String usuario = input.next();
        System.out.print("Contraseña: ");
        String clave = input.next();

        CuentaBancaria cuenta = encontrarCuentaPorUsuario(cuentas, usuario);

        if( !usuario.equals( cuenta.getUsuario() )  || !clave.equals( cuenta.getClave() ) ){
            System.out.println("clave o contraseña incorrecta, vulva a intentarlo");
            System.out.println("");
            System.out.println("----------");
            System.out.println("");
        }else{
            System.out.println("");
            System.out.println("BIENVENIDO "+ cuenta.getCliente().getNombre() + " " + cuenta.getCliente().getApellido());
            ingreso = true;
        }


        if(ingreso){
            menuCuentas(cuentas, cuenta);
        }

        return ingreso;
    }

    //menu de las cuentas bancarias
    //se llama desde ingresarCuentas
    public void menuCuentas(ArrayList<CuentaBancaria> cuentas, CuentaBancaria cuenta){
        boolean cerrarSecion = false;
        do{
            System.out.println("");
            System.out.println("¿Que desea realizar? ");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Ingresar Dinero");
            System.out.println("3. Retirar Dinero");
            System.out.println("4. Tranferencia");
            System.out.println("5. Cerrar Sesion");

            switch(input.nextInt()){
                case 1:
                    System.out.println("");
                    System.out.println("----------CONSULTAR SALDO----------");
                    System.out.println("");

                    consultarSaldo(cuenta);

                    System.out.println("");
                    System.out.println("----------FIN CONSULTAR SALDO----------");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("----------INGRESAR DINERO----------");
                    System.out.println("");

                    System.out.print("¿Cuanto dinero deseas ingresar? ");
                    float dineroIngresar = input.nextFloat();
                    ingresarDinero(cuenta, dineroIngresar);

                    System.out.println("");
                    System.out.println("----------FIN INGRESAR DINERO----------");
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("----------RETIRAR DINERO----------");
                    System.out.println("");

                    System.out.print("¿Cuanto dinero desea retirar? ");
                    float dineroRetirar = input.nextFloat();
                    retirarDinero(cuenta, dineroRetirar);

                    System.out.println("");
                    System.out.println("----------FIN RETIRAR DINERO----------");
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("----------TRANFERENCIA----------");
                    System.out.println("");

                    tranferencia(cuentas, cuenta);

                    System.out.println("");
                    System.out.println("----------FIN TRANFERENCIA----------");
                    System.out.println("");
                    break;
                case 5:
                    cerrarSecion = true;
                    System.out.println("");
                    System.out.println("----------SESION CERRADA----------");
                    System.out.println("");
                    break;
                default:
                    System.out.println("");
                    break;
            }
        }while(!cerrarSecion);


    }

    //consultar el sado de la cuenta bancaria
    //se llama desde el menu de  las cuentas bancarias
    private void consultarSaldo(CuentaBancaria cuenta){
        System.out.println("Cuenta " + cuenta.getCliente().getNombre() + " " + cuenta.getCliente().getApellido());
        System.out.println("Saldo: " + cuenta.getSaldo());
    }

    //retirar dinero, recibe la cuenta y la cantidad de dinero a retirar
    ////se llama desde el menu de  las cuentas bancarias
    private void retirarDinero(CuentaBancaria cuenta, float dinero){
        if(cuenta.getSaldo() >= dinero){
            cuenta.setSaldo(cuenta.getSaldo() - dinero);
        }else{
            System.out.println("Saldo insuficiente");
        }
    }

    //ingresar dinero, recibe la cuenta y la cantidad de dinero a ingresar
    ////se llama desde el menu de  las cuentas bancarias
    private void ingresarDinero(CuentaBancaria cuenta, float dinero){

        cuenta.setSaldo(cuenta.getSaldo() + dinero);

    }

    //cuentas es una lista con todas las cuentas
    //cuenta es la cuanta bancaria que ingrese y que va a hacer la tranferencia con otra cuenta
    //se llama desde el menu de las cuentas bancarias
    private void tranferencia(ArrayList<CuentaBancaria> cuentas, CuentaBancaria cuenta){

        System.out.print("Ingrese el nombre de usuario al que desea transferir: ");
        String usuarioATrasferir = input.next();
        CuentaBancaria cuentaATrasferir = encontrarCuentaPorUsuario(cuentas, usuarioATrasferir);
        System.out.println("Su saldo actual es: " + cuenta.getSaldo());
        System.out.println("¿Cuanto dinero quiere enviar?");
        float dinero = input.nextFloat();

        ingresarDinero(cuentaATrasferir, dinero);
        retirarDinero(cuenta, dinero);
        //cuentaATrasferir.setSaldo(cuentaATrasferir.getSaldo() + dinero);
        //cuenta.setSaldo(cuenta.getSaldo() - dinero);

        System.out.println("");
        System.out.println("TRANSFERENCIA REALIZADA");
        System.out.println("Su saldo actual es: " + cuenta.getSaldo());
        System.out.println("");


    }

    //busca a un nombre de usuario en la lista de cuentas bancarias y devuelve la cuenta bancaria que pertece ese usuario
    private CuentaBancaria encontrarCuentaPorUsuario(ArrayList<CuentaBancaria> cuentas,String usuario){

        for (CuentaBancaria clientes : cuentas) {
            if(clientes.getUsuario().equalsIgnoreCase(usuario)){
                return clientes;
            }
        }
        return null;

    }




}
