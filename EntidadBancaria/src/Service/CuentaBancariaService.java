package Service;
//validar usuario y contraseña de la creacion
//consultar datos
import Entity.Cliente;
import Entity.CuentaBancaria;

import java.util.*;

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
        String confirmClave;
        boolean claveConfirmada = false;
        CuentaBancaria cuenta = new CuentaBancaria();

        System.out.println("Ingrese el nombre de usuario: ");
        String usuario = input.next();

        do{

                System.out.println("Ingrese la constraseña: ");
                clave = input.next();
                System.out.println("Confirme la contraseña: ");
                confirmClave = input.next();
                if(!clave.equals(confirmClave)){
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
    public void ingresarACuenta( ArrayList<CuentaBancaria> cuentas){
        boolean ingreso = false;

        System.out.println("");
        System.out.println("----------");
        System.out.println("");

        System.out.print("Usuario: ");
        String usuario = clienteServicio.validarIngresoCadenaAlfanumerica();
        System.out.print("Contraseña: ");
        String clave = clienteServicio.validarIngresoCadenaAlfanumerica();

        CuentaBancaria cuenta = encontrarCuentaPorUsuario(cuentas, usuario);
    if(cuenta != null){
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
    }else{
        System.out.println("usuario no encontrado");
    }

        if(ingreso){
            menuCuentas(cuentas, cuenta);
        }

    }

    //menu de las cuentas bancarias
    //se llama desde ingresarCuentas
    public void menuCuentas(ArrayList<CuentaBancaria> cuentas, CuentaBancaria cuenta){
        boolean cerrarSesion = false;
        int opcionElegida;
        do{
            System.out.println("");
            System.out.println("¿Que desea realizar? ");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Ingresar Dinero");
            System.out.println("3. Retirar Dinero");
            System.out.println("4. Tranferencia");
            System.out.println("5. Consultar Datos de la cuenta");
            System.out.println("6. Cerrar Sesion");

            opcionElegida = clienteServicio.validarIngresoNumeroEnero();

            switch(opcionElegida){
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
                    double dineroIngresar = validarIngresoNumeroDouble();
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
                    double dineroRetirar = validarIngresoNumeroDouble();
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
                    System.out.println("");
                    System.out.println("----------CONSULTAR DATOS----------");
                    System.out.println("");

                    consultarDatosCuenta(cuenta);

                    System.out.println("");
                    System.out.println("----------CONSULTAR DATOS----------");
                    System.out.println("");
                    break;
                case 6:
                    cerrarSesion = true;
                    System.out.println("");
                    System.out.println("----------SESION CERRADA----------");
                    System.out.println("");
                    break;
                default:
                    System.out.println("");
                    break;
            }
        }while(!cerrarSesion);


    }

    //consultar el sado de la cuenta bancaria
    //se llama desde el menu de  las cuentas bancarias
    private void consultarSaldo(CuentaBancaria cuenta){
        String nombre = cuenta.getCliente().getNombre();
        String apellido = cuenta.getCliente().getApellido();
        double saldo = cuenta.getSaldo();

        System.out.println("Cuenta " + nombre + " " + apellido);
        System.out.println("Saldo: " + saldo);
    }

    //retirar dinero, recibe la cuenta y la cantidad de dinero a retirar
    ////se llama desde el menu de  las cuentas bancarias
    private void retirarDinero(CuentaBancaria cuenta, double dinero){
        double saldo = cuenta.getSaldo();
        double nuevoSaldo;
        if(saldo >= dinero){
            nuevoSaldo = saldo - dinero;
            cuenta.setSaldo(nuevoSaldo);
        }else{
            System.out.println("Saldo insuficiente");
        }
    }

    //ingresar dinero, recibe la cuenta y la cantidad de dinero a ingresar
    ////se llama desde el menu de  las cuentas bancarias
    private void ingresarDinero(CuentaBancaria cuenta, double dinero){
        double saldo = cuenta.getSaldo();
        double nuevoSaldo = saldo + dinero;
        cuenta.setSaldo(nuevoSaldo);

    }

    //cuentas es una lista con todas las cuentas
    //cuenta es la cuanta bancaria que ingrese y que va a hacer la tranferencia con otra cuenta
    //se llama desde el menu de las cuentas bancarias
    private void tranferencia(ArrayList<CuentaBancaria> cuentas, CuentaBancaria cuenta){
        double saldo = cuenta.getSaldo();
        double nuevoSaldo;

        System.out.print("Ingrese el nombre de usuario al que desea transferir: ");
        String usuarioATrasferir = clienteServicio.validarIngresoCadenaAlfanumerica();
        CuentaBancaria cuentaATrasferir = encontrarCuentaPorUsuario(cuentas, usuarioATrasferir);
        System.out.println("Su saldo actual es: " + saldo);
        System.out.println("¿Cuanto dinero quiere enviar?");
        double dinero = validarIngresoNumeroDouble();

        if(saldo < dinero){
            System.out.println("saldo insuficiente");
        }else{
            ingresarDinero(cuentaATrasferir, dinero);
            retirarDinero(cuenta, dinero);

            nuevoSaldo = cuenta.getSaldo();

            System.out.println("");
            System.out.println("TRANSFERENCIA REALIZADA");
            System.out.println("Su saldo actual es: " + nuevoSaldo);
            System.out.println("");
        }

    }

    private void consultarDatosCuenta(CuentaBancaria cuenta){
        String nombre = cuenta.getCliente().getNombre();
        String apellido = cuenta.getCliente().getApellido();
        String tarjeta = cuenta.getTarjeta().getNumero();
        double saldo = cuenta.getSaldo();

        System.out.println("Titular: " + nombre + apellido);
        System.out.println("Numero de Tarjeta: " + tarjeta);
        System.out.println("Saldo: " + saldo);
    }

    //busca a un nombre de usuario en la lista de cuentas bancarias y devuelve la cuenta bancaria que pertece ese usuario
    private CuentaBancaria encontrarCuentaPorUsuario(ArrayList<CuentaBancaria> cuentas,String usuarioBuscado){
        String usuarioCliente;
        for (CuentaBancaria clientes : cuentas) {
            usuarioCliente = clientes.getUsuario();
            if(usuarioCliente.equalsIgnoreCase(usuarioBuscado)){
                return clientes;
            }
        }
        return null;

    }

    public double validarIngresoNumeroDouble(){
        double num = -1;
        do{
            Scanner scanner = new Scanner(System.in).useDelimiter("");
            try{
                num = scanner.nextDouble();
            }catch(InputMismatchException e){
                System.out.println(e.getMessage() + ": solo se puede ingresar numeros enteros, intente nuevamente");
            }catch(Exception e){
                System.out.println(e.getMessage() + ": Error del sistema, intente nuevamente");
            }

        }while(num<=0);
        return num;
    }




}
