import java.util.InputMismatchException;
import java.util.Scanner;

public class Validaciones {
    public static String validarIngresoCadena(){
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        String cadena = "";
        do{
            try{
                cadena = sc.nextLine();
                validarCadena(cadena);
                check = false;
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
            }catch( Exception in){
                System.out.println(in.getMessage());

            }
        }while(check);

        return cadena;
    }

    public static String validarIngresoCadenaAlfanumerica(){
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        String cadena = "";
        do{
            try{
                cadena = sc.nextLine();
                validarCadenaAlfanumerico(cadena);
                check = false;
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
            }catch( Exception in){
                System.out.println(in.getMessage());

            }
        }while(check);

        return cadena;
    }

    public static void validarCadena(String cadena)throws Exception {
        cadena = cadena.toLowerCase();
        if(cadena.isEmpty()) {
            throw new Exception("Porfavor, ingrese un valor");
        }
        if(!(cadena.matches("[a-zA-Z ,]+"))){
            throw new Exception("Cuidado! Solo se puede ingresar letras");
        }
    }

    public static void validarCadenaAlfanumerico(String cadena)throws Exception {
        cadena = cadena.toLowerCase();
        if(cadena.isEmpty()) {
            throw new Exception("Porfavor, ingrese un valor");
        }
    }

    public static int validarIngresoNumeroEnero(){

        int num = -1;
        do{
            Scanner scanner = new Scanner(System.in).useDelimiter("\n");
            try{
                num = scanner.nextInt();
            }catch(InputMismatchException e){
                System.out.println(e.getMessage() + ": solo se puede ingresar numeros enteros, intente nuevamente");
            }catch(Exception e){
                System.out.println(e.getMessage() + ": Error del sistema, intente nuevamente");
            }

        }while(num<=0);

        return num;
    }

    public static double validarIngresoNumeroDouble(){
        double num = -1.0;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        do{
            // Scanner scanner = new Scanner(System.in).useDelimiter("");
            try{
                num = scanner.nextDouble();
            }catch(InputMismatchException e){
                System.out.println(e.getMessage() + ": solo se puede ingresar numeros enteros, intente nuevamente");
                scanner.nextLine();
            }catch(Exception e){
                System.out.println(e.getMessage() + ": Error del sistema, intente nuevamente");
                scanner.nextLine();
            }

        }while(num<=0.0);
        return num;
    }
}
