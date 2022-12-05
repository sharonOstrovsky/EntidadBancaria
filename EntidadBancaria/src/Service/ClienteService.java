package Service;

import Entity.Cliente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClienteService {

    Scanner input = new Scanner(System.in).useDelimiter("\n");

    //crea el cliente mediante un formulario que el usuario debe completar y lo devuelve.
    public Cliente crearCliente(){
        Cliente cliente = new Cliente();

        System.out.println("");
        System.out.println("----------FORMULARIO----------");
        System.out.println("");

        System.out.print("Nombre: ");
        cliente.setNombre(validarIngresoCadena());
        //cliente.setNombre(ingresarCadena());
        //cliente.setNombre(input.next());
        System.out.print("Apellido: ");
        cliente.setApellido(validarIngresoCadena());
        System.out.print("DNI: ");
        cliente.setDocumento(validarIngresoNumeroEnero());
        //cliente.setDocumento(input.nextInt());
        System.out.print("Edad: ");
        cliente.setEdad(validarIngresoNumeroEnero());
        //cliente.setEdad(input.nextInt());
        System.out.print("Email: ");
        cliente.setMail(validarIngresoCadenaAlfanumerica());
        System.out.print("Direccion: ");
        cliente.setDireccion(validarIngresoCadenaAlfanumerica());
        System.out.print("Nacionalidad: ");
        cliente.setNacionalidad(validarIngresoCadena());

        System.out.println("");
        System.out.println("----------FIN FORMULARIO----------");
        System.out.println("");

        return cliente;
    }


    public String validarIngresoCadena(){
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        String s = "";
        do{
            try{
                s = sc.nextLine();
                validateCadena(s);
                check = false;
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
            }catch( Exception in){
                System.out.println(in.getMessage());

            }
        }while(check);

        return s;
    }

    public String validarIngresoCadenaAlfanumerica(){
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        String s = "";
        do{
            try{
                s = sc.nextLine();
                validateCadenaAlfanumerico(s);
                check = false;
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
            }catch( Exception in){
                System.out.println(in.getMessage());

            }
        }while(check);

        return s;
    }

    public static void validateCadena(String s)throws Exception {
        s = s.toLowerCase();
        if(s.isEmpty()) {
            throw new Exception("Porfavor, ingrese un valor");
        }
        if(!(s.matches("[a-zA-Z ,]+"))){
            throw new Exception("Cuidado! Solo se puede ingresar letras");
        }
    }

    public static void validateCadenaAlfanumerico(String s)throws Exception {
        s = s.toLowerCase();
        if(s.isEmpty()) {
            throw new Exception("Porfavor, ingrese un valor");
        }
    }

    public int validarIngresoNumeroEnero(){
      //  Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int num = -1;
        do{
            Scanner scanner = new Scanner(System.in).useDelimiter("\n");
            try{
                num = scanner.nextInt();
            }catch(InputMismatchException e){
                System.out.println(e.getMessage() + ": solo se puede ingresar numeros enteros, intente nuevamente");
               // scanner.next();
            }catch(Exception e){
                System.out.println(e.getMessage() + ": Error del sistema, intente nuevamente");
               // scanner.next();
            }

        }while(num<=0);
        return num;
    }


}
