package Service;
//crear cliente()
//fijaste que todos los datos no esten vacios

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
                validate(s);
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
                validateAlfanumerico(s);
                check = false;
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
            }catch( Exception in){
                System.out.println(in.getMessage());

            }
        }while(check);

        return s;
    }

    public static void validate(String s)throws Exception {
        s = s.toLowerCase();
        if(s.isEmpty()) {
            throw new Exception("Porfavor, ingrese un valor");
        }
        if(!(s.matches("[a-zA-Z ,]+"))){
            throw new Exception("Cuidado! Solo se puede ingresar letras");
        }
    }

    public static void validateAlfanumerico(String s)throws Exception {
        s = s.toLowerCase();
        if(s.isEmpty()) {
            throw new Exception("Porfavor, ingrese un valor");
        }
    }

    public int validarIngresoNumeroEnero(){
        int num = 0;
        boolean validador = true;
        do{
            Scanner scanner = new Scanner(System.in).useDelimiter("\n");
            try{
                num = scanner.nextInt();
                if(num > 0){
                    validador = false;
                }else{
                    System.out.println("El numero ingresado no es valido, no se permite el ingreso de numeros negativos");
                }

            }catch(InputMismatchException e){
                System.out.println(e.getMessage() + ": solo se puede ingresar numeros enteros, intente nuevamente");
            }catch(Exception e){
                System.out.println(e.getMessage() + ": Error del sistema, intente nuevamente");
            }

        }while(validador);
        return num;
    }

/*
    //valida cadenas que pueden tener numeros y caracters especiales
    public String ingresarCadenaAlfanumerica(){
        String cadena = "";
        boolean ok = true;
        do{
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            try{
                cadena = sc.next();
                if(cadena.length() > 0){

                    ok = false;
                }else{
                    System.out.println("no ingreso ningun caracter, intente nuevamente");
                }

            }catch(InputMismatchException e){
                System.out.println(e.getMessage() + ": solo se pude ingresar caracteres, intente nuevamente");
            }catch (Exception e){
                System.out.println(e.getMessage() + ": Error del sistema, intente nuevamente");
            }
        }while(ok);

        return cadena;
    }

    //no permite el ingreso de numeros en la cadena
    public String ingresarCadena(){
        String cadena = "";
        boolean ok = true;
        do{
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            try{
                cadena = sc.next();
                if(!validarIngresoLetras(cadena)){
                    ok = false;
                }

            }catch(InputMismatchException e){
                System.out.println(e.getMessage() + ": solo se pude ingresar caracteres, intente nuevamente");
            }catch (Exception e){
                System.out.println(e.getMessage() + ": Error del sistema, intente nuevamente");
            }
        }while(ok);

        return cadena;
    }
    public boolean validarIngresoLetras(String cadena){
        boolean resultado = true;
        int contador = 0;
        char caracter;

        if(cadena.length() > 0){
            for (int i = 0; i < cadena.length(); i++) {
                caracter = cadena.charAt(i);
              if(caracter < 'a' || caracter > 'z'){
                    contador++;
              }
            }
            if(contador == 0) {
                resultado  = false;
            }else{
                System.out.println("solo puede ingresar letras, intenta nuevamente");

            }
        }else{
            System.out.println("no ingreso ningun caracter, intente nuevamente");

        }
        return resultado;
    }
*/

}
