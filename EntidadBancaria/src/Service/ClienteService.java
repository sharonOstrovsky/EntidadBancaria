package Service;
//crear cliente()
//fijaste que todos los datos no esten vacios

import Entity.Cliente;

import java.util.Scanner;

public class ClienteService {

    Scanner input = new Scanner(System.in).useDelimiter("\n");

    public Cliente crearCliente(){
        Cliente cliente = new Cliente();

        System.out.println("");
        System.out.println("----------FORMULARIO----------");
        System.out.println("");

        System.out.print("Nombre: ");
        cliente.setNombre(input.nextLine());
        System.out.print("Apellido: ");
        cliente.setApellido(input.nextLine());
        System.out.print("DNI: ");
        cliente.setDocumento(input.nextInt());
        System.out.print("Edad: ");
        cliente.setEdad(input.nextInt());
        System.out.print("Email: ");
        cliente.setMail(input.next());
        System.out.print("Direccion: ");
        cliente.setDireccion(input.next());
        System.out.print("Nacionalidad: ");
        cliente.setNacionalidad(input.next());

        System.out.println("");
        System.out.println("----------FIN FORMULARIO----------");
        System.out.println("");

        return cliente;
    }


}
