package Service;
//crear cuenta bancaria
//validar usuario y contraseña de la creacion
//usuario,clave, client, tarjeta, saldo
//generar tarjeta
import Entity.Cliente;
import Entity.CuentaBancaria;

import java.util.Scanner;

//falta la tarjeta y validar
public class CuentaBancariaService {

    Scanner input = new Scanner(System.in).useDelimiter("\n");

    public CuentaBancaria crearCuenta(Cliente cliente){
        String clave, confirm;
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
            }
        }while(!clave.equals(confirm));

        cuenta.setCliente(cliente);


        return cuenta;

    }
}
